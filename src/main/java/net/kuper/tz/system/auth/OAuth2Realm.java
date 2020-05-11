package net.kuper.tz.system.auth;

import net.kuper.tz.core.cache.Cache;
import net.kuper.tz.core.constant.Time;
import net.kuper.tz.core.controller.ResCode;
import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.system.entity.UserEntity;
import net.kuper.tz.system.entity.UserTokenEntity;
import net.kuper.tz.system.service.OperationService;
import net.kuper.tz.system.service.UserService;
import net.kuper.tz.system.service.UserTokenService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 认证
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 14:00
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(OAuth2Realm.class);
    @Autowired
    private OperationService operationService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private Cache cache;


    @Override
    public boolean supports(AuthenticationToken token) {
        return super.supports(token) || token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserEntity user = (UserEntity) principals.getPrimaryPrincipal();
        String userId = user.getId();
        //用户权限列表
        List<String> permissionList = cache.getList(user.getToken() + "_" + userId, new Class[]{String.class});
        if (permissionList == null) {
            permissionList = operationService.queryUserOperationCodeList(userId);
            if (permissionList != null) {
                String key = user.getToken() + "_" + userId;
                cache.set(key, new ArrayList<>(permissionList), Time.HOUR);
            }
        }
        Set<String> permsSet = new HashSet<>();
        permsSet.addAll(permissionList);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info = null;
        if (token instanceof UsernamePasswordToken) {
            // 账号密码登录
            String userName = (String) token.getPrincipal();
            String password = new String((char[]) token.getCredentials());
            UserEntity userEntity = userService.queryByUserName(userName);
            if (userEntity == null) {
                throw new ApiException("该用户名不存在");
            }
            if (userEntity.getStatus() == 0) {
                throw new ApiException("该账号已锁定");
            }
            if (userEntity.getDeleteTime() != null) {
                throw new ApiException("该账号已删除");
            }
            String pwd = new Sha256Hash(password, userEntity.getSalt()).toHex();
            if (!pwd.equals(userEntity.getPassword())) {
                throw new ApiException("密码不正确");
            }
            info = new SimpleAuthenticationInfo(userEntity, password, getName());
        } else if (token instanceof OAuth2Token) {
            // token 自动登录 AuthenticationException
            String accessToken = (String) token.getPrincipal();
            UserTokenEntity userTokenEntity = userTokenService.queryObjectByToken(accessToken);
            if (userTokenEntity == null) {
                logger.info("自动登录失败，token不存在");
                throw new ApiException(ResCode.ERROR_SYS_AUTH_UNLOGIN);
            }
            if (userTokenEntity != null && userTokenEntity.getExpireTime().before(new Date())) {
                logger.info("自动登录失败，token已过期");
                throw new ApiException(ResCode.ERROR_SYS_AUTH_FAIL);
            }
            UserEntity userEntity = userService.queryObject(userTokenEntity.getUserId());
            userEntity.setToken(accessToken);
            info = new SimpleAuthenticationInfo(userEntity, accessToken, getName());
        }
        return info;
    }
}
