package net.kuper.tz.system.controller;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.cache.Cache;
import net.kuper.tz.core.constant.Time;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.IgnoreAuth;
import net.kuper.tz.core.controller.auth.User;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.utils.HttpServletUtils;
import net.kuper.tz.core.utils.ShiroUtils;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.system.entity.LoginLogUpdateEntity;
import net.kuper.tz.system.entity.MenuEntity;
import net.kuper.tz.system.entity.UserEntity;
import net.kuper.tz.system.entity.UserTokenEntity;
import net.kuper.tz.system.params.LoginEntity;
import net.kuper.tz.system.service.*;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Api(value = "后台初始化")
@RestController
@RequestMapping("system/auth")
public class AuthController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private Cache cache;
    @Autowired
    private Producer producer;
    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private LoginLogService loginLogService;
    @Autowired
    private ElementService elementService;
    @Autowired
    private UserService userService;

    /**
     * 图片验证码，验证码
     */
    @Log(type = LogType.OPERATOR, value = "获取登录验证码")
    @IgnoreAuth
    @ApiOperation("获取验证码")
    @ResponseBody
    @GetMapping(value = "/login/captcha")
    public void captcha(@RequestParam("key") String key, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        cache.set(key, text, 5 * Time.MIN);
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", out);
        byte[] bytes = out.toByteArray();
        IOUtils.write(bytes, response.getOutputStream());
        IOUtils.closeQuietly(out);
    }


    @Log(type = LogType.LOGIN, value = "管理员登录")
    @IgnoreAuth
    @ApiOperation("管理后台登录")
    @ResponseBody
    @PostMapping(value = "/login")
    public Res<UserTokenEntity> login(@RequestBody LoginEntity form, HttpServletRequest request) {
        ValidatorUtils.validateEntity(form);
        UserTokenEntity tokenEntity;
        String code = cache.get(form.getKey(), String.class);
        if (code == null) {
            throw new ApiException("验证码已失效");
        }
        if (!code.equals(form.getCode())) {
            throw new ApiException("验证码错误");
        }
        LoginLogUpdateEntity loginLogAdd = new LoginLogUpdateEntity();
        loginLogAdd.setClientType(request.getHeader("client"));
        loginLogAdd.setClientVersion(request.getHeader("version"));
        loginLogAdd.setLoginName(form.getUsername());
        loginLogAdd.setCreateTime(new Date());
        loginLogAdd.setIp(HttpServletUtils.getIpAddr(request));
        Subject subject = ShiroUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername(), form.getPassword());
            subject.login(token);
            UserEntity user = ShiroUtils.getUserEntity();
            tokenEntity = userTokenService.createTokenByUser(user.getId());
            user.setToken(tokenEntity.getToken());
            loginLogAdd.setSuccessed(1);
            loginLogAdd.setPassword(user.getPassword());
            loginLogAdd.setUserId(user.getId());
        } catch (Exception e) {
            loginLogAdd.setSuccessed(0);
            if (e.getCause() != null && e.getCause() instanceof ApiException) {
                throw (ApiException) e.getCause();
            } else {
                throw e;
            }
        } finally {
            loginLogService.save(loginLogAdd);
        }
        return Res.ok(tokenEntity);
    }

    @Log(type = LogType.LOGOUT, value = "管理员登出")
    @IgnoreAuth
    @ResponseBody
    @GetMapping(value = "/logout")
    public Res logout(@ApiIgnore @User UserEntity user) {
        if (user != null) {
            String token = user.getToken();
            cache.delete(token);
            userTokenService.delete(user.getId());
            String key = user.getToken() + "_" + user.getId();
            cache.delete(key);
        }
        ShiroUtils.getSubject().logout();
        return Res.ok();
    }

    @Log(type = LogType.QUERY, value = "查询当前登录管理员菜单")
    @ApiOperation("菜单列表")
    @ResponseBody
    @GetMapping(value = "/menus")
    public Res<List<MenuEntity>> getMenuList(@ApiIgnore @User UserEntity userEntity) {
        List<MenuEntity> list = menuService.queryUserMenuList(userEntity.getId());
        return Res.ok(list);
    }

    @Log(type = LogType.QUERY, value = "登录管理员信息")
    @ApiOperation("登录管理员信息")
    @ResponseBody
    @GetMapping(value = "/info")
    public Res<UserEntity> info(@ApiIgnore @UserId String userId) {
        UserEntity userEntity = userService.queryObject(userId);
        return Res.ok(userEntity);
    }


    @Log(type = LogType.QUERY, value = "查询当前登录管理员页面权限")
    @ApiOperation("权限代码列表")
    @ResponseBody
    @GetMapping(value = "/codes")
    public Res<List<String>> getPermissionCodeList(@ApiIgnore @User UserEntity userEntity) {
        List<String> list = elementService.queryCodeListByUser(userEntity.getId());
        return Res.ok(list);
    }
}
