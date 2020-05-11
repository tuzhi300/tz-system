package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.system.dao.RoleDao;
import net.kuper.tz.system.dao.UserDataDao;
import net.kuper.tz.system.dao.UserRoleDao;
import net.kuper.tz.system.entity.RoleEntity;
import net.kuper.tz.system.entity.UserRoleEntity;
import net.kuper.tz.system.entity.UserRoleQueryEntity;
import net.kuper.tz.system.entity.UserRoleUpdateEntity;
import net.kuper.tz.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:13
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<UserRoleEntity> queryList(UserRoleQueryEntity userRoleQueryEntity, String curUserId) {
        List<UserRoleEntity> userRoleList = userRoleDao.queryListByUser(userRoleQueryEntity.getUserId(), curUserId);
        return userRoleList;
    }

    @Override
    public UserRoleEntity queryObject(String id) {
        return userRoleDao.queryObject(id);
    }

    @Override
    public UserRoleEntity save(UserRoleUpdateEntity userRoleUpdateEntity) {
        userRoleDao.save(userRoleUpdateEntity);
        return userRoleDao.queryObject(userRoleUpdateEntity.getId());
    }

    @Override
    public void delete(String id, String userId) {
        UserRoleEntity userRoleEntity = userRoleDao.queryObject(id);
        String roleId = null;
        if (userRoleEntity != null) {
            roleId = userRoleEntity.getRoleId();
        }
        String deptId = null;
        if (roleId != null) {
            RoleEntity roleEntity = roleDao.queryObject(roleId);
            deptId = roleEntity.getDeptId();
        }

        boolean right = false;
        List<String> rightList = userDataDao.queryEnableDeptIdList(userId);
        if (rightList != null && deptId != null && rightList.contains(deptId)) {
            right = true;
        }
        if (right) {
            userRoleDao.delete(id);
        } else {
            throw new ApiException("删除失败，没有该角色的操作权限");
        }
    }

}
