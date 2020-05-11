package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.service.SuperRoleService;
import net.kuper.tz.system.dao.RoleMenuDao;
import net.kuper.tz.system.dao.UserMenuDao;
import net.kuper.tz.system.entity.*;
import net.kuper.tz.system.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Service("userMenuService")
public class UserMenuServiceImpl implements UserMenuService {

    @Autowired
    private UserMenuDao userMenuDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private SuperRoleService superRoleService;


    @Override
    public List<UserMenuEntity> queryList(UserMenuQueryEntity userMenuQueryEntity, String curUserId) {
        return userMenuDao.queryListByUser(userMenuQueryEntity.getUserId(), curUserId);
    }


    private void verifyRole(List<UserMenuUpdateEntity> list) {
        String roleId = null;
        for (UserMenuUpdateEntity userDataUpdateEntity : list) {
            if (roleId == null) {
                roleId = userDataUpdateEntity.getUserId();
            } else {
                if (!roleId.equals(userDataUpdateEntity.getUserId())) {
                    throw new ApiException("用户ID不错");
                }
            }
        }
    }

    private String getUserId(List<UserMenuUpdateEntity> userMenuUpdateEntities) {
        String userId = null;
        if (userMenuUpdateEntities != null && !userMenuUpdateEntities.isEmpty()) {
            for (UserMenuUpdateEntity userMenuUpdateEntity : userMenuUpdateEntities) {
                userId = userMenuUpdateEntity.getUserId();
                if (userId != null) {
                    break;
                }
            }
        }
        return userId;
    }


    @Override
    public void update(List<UserMenuUpdateEntity> userMenuUpdateEntities, String userId) {
        // 在当前登录用户读写权限内，不在被修改用户的角色权限内
        verifyRole(userMenuUpdateEntities);
        List<String> enableIdList = null;
        if (superRoleService.isSuperRoleByUser(userId)) {
            enableIdList = userMenuDao.queryEnableMenuIdBySuperRole();
        } else {
            enableIdList = userMenuDao.queryEnableMenuIdByUser(userId);
        }
        List<UserMenuUpdateEntity> enableList = new ArrayList<>();
        for (UserMenuUpdateEntity userDataUpdateEntity : userMenuUpdateEntities) {
            if (enableIdList.contains(userDataUpdateEntity.getMenuId())) {
                enableList.add(userDataUpdateEntity);
            }
        }
        String eUserId = getUserId(userMenuUpdateEntities);
        List<String> rightIdList = new ArrayList<>();
        RoleMenuQueryEntity roleMenuQueryEntity = new RoleMenuQueryEntity();
        roleMenuQueryEntity.setUserId(eUserId);
        List<RoleMenuEntity> roleDataEntityList = roleMenuDao.queryList(roleMenuQueryEntity);
        for (RoleMenuEntity roleMenuEntity : roleDataEntityList) {
            rightIdList.add(roleMenuEntity.getMenuId() + "_" + roleMenuEntity.getRightType());
        }

        List<UserMenuUpdateEntity> rightList = new ArrayList<>();
        for (UserMenuUpdateEntity userDataUpdateEntity : enableList) {
            if (!rightIdList.contains(userDataUpdateEntity.getMenuId() + "_" + userDataUpdateEntity.getRightType())) {
                rightList.add(userDataUpdateEntity);
            }
        }

        userMenuDao.deleteByUser(eUserId);
        if (rightList != null && !rightList.isEmpty()) {
            userMenuDao.saveBatch(rightList);
        }
    }

}
