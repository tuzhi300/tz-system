package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.system.dao.RoleDataDao;
import net.kuper.tz.system.dao.UserDataDao;
import net.kuper.tz.system.entity.*;
import net.kuper.tz.system.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据权限Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Service("userDataService")
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    private RoleDataDao roleDataDao;

    @Override
    public List<UserDataEntity> queryList(UserDataQueryEntity userDataQueryEntity, String curUserId) {
        return userDataDao.queryListByUser(userDataQueryEntity.getUserId(), curUserId);
    }


    private void verifyRole(List<UserDataUpdateEntity> list) {
        String roleId = null;
        for (UserDataUpdateEntity userDataUpdateEntity : list) {
            if (roleId == null) {
                roleId = userDataUpdateEntity.getUserId();
            } else {
                if (!roleId.equals(userDataUpdateEntity.getUserId())) {
                    throw new ApiException("用户ID不错");
                }
            }
        }
    }


    private String getUserId(List<UserDataUpdateEntity> userDataUpdateEntities) {
        String userId = null;
        if (userDataUpdateEntities != null && !userDataUpdateEntities.isEmpty()) {
            for (UserDataUpdateEntity userDataUpdateEntity : userDataUpdateEntities) {
                userId = userDataUpdateEntity.getUserId();
                if (userId != null) {
                    break;
                }
            }
        }
        return userId;
    }
    @Override
    public void update(List<UserDataUpdateEntity> userDataUpdateEntities, String userId) {
        // 在当前登录用户读写权限内，不在被修改用户的角色权限内
        verifyRole(userDataUpdateEntities);

        String eUserId = getUserId(userDataUpdateEntities);
        List<String> enableIdList = userDataDao.queryEnableDeptIdList(userId);
        List<UserDataUpdateEntity> enableList = new ArrayList<>();
        for (UserDataUpdateEntity userDataUpdateEntity : userDataUpdateEntities) {
            if (enableIdList.contains(userDataUpdateEntity.getDeptId())) {
                enableList.add(userDataUpdateEntity);
            }
        }
        List<String> rightIdList = new ArrayList<>();
        RoleDataQueryEntity roleDataQueryEntity = new RoleDataQueryEntity();
        roleDataQueryEntity.setUserId(eUserId);
        List<RoleDataEntity> roleDataEntityList = roleDataDao.queryList(roleDataQueryEntity);
        for (RoleDataEntity roleDataEntity : roleDataEntityList) {
            rightIdList.add(roleDataEntity.getDeptId() + "_" + roleDataEntity.getRightType());
        }

        List<UserDataUpdateEntity> rightList = new ArrayList<>();
        for (UserDataUpdateEntity userDataUpdateEntity : enableList) {
            if (!rightIdList.contains(userDataUpdateEntity.getDeptId() + "_" + userDataUpdateEntity.getRightType())) {
                rightList.add(userDataUpdateEntity);
            }
        }

        if (rightList != null && !rightList.isEmpty()) {
            userDataDao.deleteByUser(eUserId);
            userDataDao.saveBatch(rightList);
        }
    }
}
