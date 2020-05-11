package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.service.SuperRoleService;
import net.kuper.tz.system.dao.RoleMenuDao;
import net.kuper.tz.system.dao.UserMenuDao;
import net.kuper.tz.system.entity.RoleMenuEntity;
import net.kuper.tz.system.entity.RoleMenuQueryEntity;
import net.kuper.tz.system.entity.RoleMenuUpdateEntity;
import net.kuper.tz.system.service.RoleMenuService;
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
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private UserMenuDao userMenuDao;
    @Autowired
    private SuperRoleService superRoleService;

    @Override
    public List<RoleMenuEntity> queryList(RoleMenuQueryEntity roleMenuQueryEntity, String userId) {
        List<RoleMenuEntity> list = null;
        if (superRoleService.isSuperRoleByUser(userId)) {
            list = roleMenuDao.queryListBySuperRole(roleMenuQueryEntity.getRoleId());
        } else {
            list = roleMenuDao.queryListByUser(roleMenuQueryEntity.getRoleId(), userId);
        }
        return list;
    }


    private void verifyRole(List<RoleMenuUpdateEntity> list) {
        String roleId = null;
        for (RoleMenuUpdateEntity roleMenuUpdateEntity : list) {
            if (roleId == null) {
                roleId = roleMenuUpdateEntity.getRoleId();
            } else {
                if (!roleId.equals(roleMenuUpdateEntity.getRoleId())) {
                    throw new ApiException("角色ID不错");
                }
            }
        }
    }

    @Override
    public void update(List<RoleMenuUpdateEntity> roleMenuUpdateEntities, String userId) {
        verifyRole(roleMenuUpdateEntities);
        List<String> enableRight;
        if (superRoleService.isSuperRoleByUser(userId)) {
            enableRight = userMenuDao.queryEnableMenuIdBySuperRole();
        } else {
            enableRight = userMenuDao.queryEnableMenuIdByUser(userId);
        }
        List<RoleMenuUpdateEntity> updateList = new ArrayList<>();
        if (enableRight != null && !enableRight.isEmpty()) {
            for (RoleMenuUpdateEntity dataUpdateEntity : roleMenuUpdateEntities) {
                if (enableRight.contains(dataUpdateEntity.getMenuId())) {
                    updateList.add(dataUpdateEntity);
                }
            }
        }
        if (!updateList.isEmpty()) {
            roleMenuDao.deleteByRole(updateList.get(0).getRoleId());
            roleMenuDao.saveBatch(updateList);
        }
    }
}
