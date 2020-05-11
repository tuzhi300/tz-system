package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.service.SuperRoleService;
import net.kuper.tz.system.dao.RoleDataDao;
import net.kuper.tz.system.dao.UserDataDao;
import net.kuper.tz.system.entity.RoleDataEntity;
import net.kuper.tz.system.entity.RoleDataQueryEntity;
import net.kuper.tz.system.entity.RoleDataUpdateEntity;
import net.kuper.tz.system.service.RoleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色数据权限Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Service("roleDataService")
public class RoleDataServiceImpl implements RoleDataService {

    @Autowired
    private RoleDataDao roleDataDao;
    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    private SuperRoleService superRoleService;

    @Override
    public List<RoleDataEntity> queryList(RoleDataQueryEntity roleDataQueryEntity, String userId) {
        List<RoleDataEntity> list = null;
        if (superRoleService.isSuperRoleByUser(userId)) {
            list = roleDataDao.queryListBySuperRole(roleDataQueryEntity.getRoleId());
        } else {
            list = roleDataDao.queryListByUser(roleDataQueryEntity.getRoleId(), userId);
        }
        return list;
    }

    private void verifyRole(List<RoleDataUpdateEntity> list) {
        String roleId = null;
        for (RoleDataUpdateEntity roleDataUpdateEntity : list) {
            if (roleId == null) {
                roleId = roleDataUpdateEntity.getRoleId();
            } else {
                if (!roleId.equals(roleDataUpdateEntity.getRoleId())) {
                    throw new ApiException("角色ID不错");
                }
            }
        }
    }

    @Transactional
    @Override
    public void update(List<RoleDataUpdateEntity> roleDataUpdateEntityList, String userId) {
        verifyRole(roleDataUpdateEntityList);
        if (superRoleService.isSuperRoleByUser(userId)) {
            roleDataDao.deleteByRole(roleDataUpdateEntityList.get(0).getRoleId());
            roleDataDao.saveBatch(roleDataUpdateEntityList);
        } else {
            List<String> enableRight = userDataDao.queryEnableDeptIdList(userId);
            List<RoleDataUpdateEntity> updateList = new ArrayList<>();
            if (enableRight != null && !enableRight.isEmpty() && !roleDataUpdateEntityList.isEmpty()) {
                for (RoleDataUpdateEntity dataUpdateEntity : roleDataUpdateEntityList) {
                    if (enableRight.contains(dataUpdateEntity.getDeptId())) {
                        updateList.add(dataUpdateEntity);
                    }
                }
            }
            roleDataDao.deleteByRole(roleDataUpdateEntityList.get(0).getRoleId());
            roleDataDao.saveBatch(updateList);
        }
    }

}
