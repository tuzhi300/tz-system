package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.service.SuperRoleService;
import net.kuper.tz.system.dao.ElementCategoryDao;
import net.kuper.tz.system.dao.RoleElementDao;
import net.kuper.tz.system.dao.UserElementDao;
import net.kuper.tz.system.entity.*;
import net.kuper.tz.system.service.UserElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户菜单功能Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Service("userElementService")
public class UserElementServiceImpl implements UserElementService {

    @Autowired
    private UserElementDao userElementDao;
    @Autowired
    private ElementCategoryDao categoryDao;
    @Autowired
    private RoleElementDao roleElementDao;
    @Autowired
    private SuperRoleService superRoleService;

    @Override
    public List<UserElementEntity> queryList(UserElementQueryEntity userElementQueryEntity, String userId) {
        List<UserElementEntity> allList = new ArrayList<>();
        ElementCategoryQueryEntity categoryQueryEntity = new ElementCategoryQueryEntity();
        List<ElementCategoryEntity> categoryList = categoryDao.queryList(categoryQueryEntity);
        // 分类处理为相同数据，到前端处理为树形结构。
        if (categoryList != null && !categoryList.isEmpty()) {
            for (ElementCategoryEntity elementCategoryEntity : categoryList) {
                UserElementEntity entity = new UserElementEntity();
                entity.setElementName(elementCategoryEntity.getName());
                entity.setElementId(elementCategoryEntity.getId());
                allList.add(entity);
            }
        }
        List<UserElementEntity> list;
        if (superRoleService.isSuperRoleByUser(userId)) {
            list = userElementDao.queryListBySuperRole(userElementQueryEntity.getUserId());
        } else {
            list = userElementDao.queryListByUser(userElementQueryEntity.getUserId(), userId);
        }
        if (list != null) {
            allList.addAll(list);
        }
        return allList;
    }


    private void verifyRole(List<UserElementUpdateEntity> list) {
        String roleId = null;
        for (UserElementUpdateEntity userDataUpdateEntity : list) {
            if (roleId == null) {
                roleId = userDataUpdateEntity.getUserId();
            } else {
                if (!roleId.equals(userDataUpdateEntity.getUserId())) {
                    throw new ApiException("用户ID不错");
                }
            }
        }
    }


    private String getUserId(List<UserElementUpdateEntity> userElementUpdateEntities) {
        String userId = null;
        if (userElementUpdateEntities != null && !userElementUpdateEntities.isEmpty()) {
            for (UserElementUpdateEntity userElementUpdateEntity : userElementUpdateEntities) {
                userId = userElementUpdateEntity.getUserId();
                if (userId != null) {
                    break;
                }
            }
        }
        return userId;
    }


    @Override
    public void update(List<UserElementUpdateEntity> userElementUpdateEntities, String userId) {

        // 在当前登录用户读写权限内，不在被修改用户的角色权限内
        verifyRole(userElementUpdateEntities);

        String eUserId = getUserId(userElementUpdateEntities);
        List<String> enableIdList = userElementDao.queryEnableElementIdByUser(userId);
        List<UserElementUpdateEntity> enableList = new ArrayList<>();
        if (enableIdList != null && !enableIdList.isEmpty()) {
            for (UserElementUpdateEntity userDataUpdateEntity : userElementUpdateEntities) {
                if (enableIdList.contains(userDataUpdateEntity.getElementId())) {
                    enableList.add(userDataUpdateEntity);
                }
            }
        }
        List<String> rightIdList = new ArrayList<>();
        RoleElementQueryEntity userElementQueryEntity = new RoleElementQueryEntity();
        userElementQueryEntity.setUserId(eUserId);
        List<RoleElementEntity> roleDataEntityList = roleElementDao.queryList(userElementQueryEntity);
        for (RoleElementEntity roleElementEntity : roleDataEntityList) {
            rightIdList.add(roleElementEntity.getElementId() + "_" + roleElementEntity.getRightType());
        }

        List<UserElementUpdateEntity> rightList = new ArrayList<>();
        for (UserElementUpdateEntity userElementUpdateEntity : enableList) {
            if (!rightIdList.contains(userElementUpdateEntity.getElementId() + "_" + userElementUpdateEntity.getRightType())) {
                rightList.add(userElementUpdateEntity);
            }
        }

        if (rightList != null && !rightList.isEmpty()) {
            userElementDao.deleteByUser(eUserId);
            userElementDao.saveBatch(rightList);
        }
    }

}
