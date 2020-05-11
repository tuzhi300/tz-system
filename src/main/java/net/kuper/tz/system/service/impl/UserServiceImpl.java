package net.kuper.tz.system.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.dao.UserDao;
import net.kuper.tz.system.entity.UserEntity;
import net.kuper.tz.system.entity.UserQueryEntity;
import net.kuper.tz.system.entity.UserUpdateEntity;
import net.kuper.tz.system.params.UserUpdatePwdEntity;
import net.kuper.tz.system.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private String defPwd = "aaAA1234";

    @Autowired
    private UserDao userDao;

    @Override
    public Pagination<UserEntity> queryList(UserQueryEntity userQueryEntity) {
        PageHelper.startPage(userQueryEntity.getPage(), userQueryEntity.getPageSize());
        List<UserEntity> userList = userDao.queryList(userQueryEntity);
        return new Pagination<UserEntity>(userList);
    }

    @Override
    public UserEntity queryObject(String id) {
        return userDao.queryObject(id);
    }

    @Override
    public UserEntity save(UserUpdateEntity userUpdateEntity) {
        String salt = RandomStringUtils.randomAlphanumeric(20);
        userUpdateEntity.setSalt(salt);
        userUpdateEntity.setPassword(new Sha256Hash(defPwd, salt).toHex());
        userDao.save(userUpdateEntity);
        return userDao.queryObject(userUpdateEntity.getId());
    }

    @Override
    public void update(UserUpdateEntity userUpdateEntity) {
        userDao.update(userUpdateEntity);
    }

    @Override
    public void updatePwd(UserUpdatePwdEntity userUpdatePwdEntity) {
        UserEntity user = userDao.queryObject(userUpdatePwdEntity.getId());
        if (user == null) {
            throw new ApiException("用户不存在");
        }
        String pwd = new Sha256Hash(userUpdatePwdEntity.getOldPwd(), user.getSalt()).toHex();
        if (!pwd.equals(user.getPassword())) {
            throw new ApiException("原始密码不正确");
        }
        UserUpdateEntity userUpdateEntity = new UserUpdateEntity();
        String salt = RandomStringUtils.randomAlphanumeric(20);
        userUpdateEntity.setId(userUpdatePwdEntity.getId());
        userUpdateEntity.setSalt(salt);
        userUpdateEntity.setPassword(new Sha256Hash(userUpdatePwdEntity.getPassword(), salt).toHex());
        userDao.updatePwd(userUpdateEntity);
    }

    @Override
    public void resetPwd(String userId) {
        UserEntity user = userDao.queryObject(userId);
        if (user == null) {
            throw new ApiException("用户不存在");
        }
        String salt = RandomStringUtils.randomAlphanumeric(20);
        UserUpdateEntity userUpdate = new UserUpdateEntity();
        userUpdate.setId(userId);
        userUpdate.setSalt(salt);
        userUpdate.setPassword(new Sha256Hash(defPwd, salt).toHex());
        userDao.update(userUpdate);
    }

    @Override
    public UserEntity queryByUserName(String account) {
        return userDao.queryByUserName(account);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        userDao.deleteBatch(ids);
    }
}
