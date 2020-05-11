package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.service.SuperRoleService;
import net.kuper.tz.system.dao.ElementCategoryDao;
import net.kuper.tz.system.dao.RoleElementDao;
import net.kuper.tz.system.dao.UserElementDao;
import net.kuper.tz.system.entity.*;
import net.kuper.tz.system.service.RoleElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色菜单元素Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Service("roleElementService")
public class RoleElementServiceImpl implements RoleElementService {

    @Autowired
    private ElementCategoryDao categoryDao;
    @Autowired
    private RoleElementDao roleElementDao;
    @Autowired
    private UserElementDao userElementDao;
    @Autowired
    private SuperRoleService superRoleService;

    @Override
    public List<RoleElementEntity> queryList(RoleElementQueryEntity roleElementQueryEntity, String userId) {
        List<RoleElementEntity> allList = new ArrayList<>();
        ElementCategoryQueryEntity categoryQueryEntity = new ElementCategoryQueryEntity();
        List<ElementCategoryEntity> categoryList = categoryDao.queryList(categoryQueryEntity);
        // 分类处理为相同数据，到前端处理为树形结构。
        if (categoryList != null && !categoryList.isEmpty()) {
            for (ElementCategoryEntity elementCategoryEntity : categoryList) {
                RoleElementEntity entity = new RoleElementEntity();
                entity.setElementName(elementCategoryEntity.getName());
                entity.setElementId(elementCategoryEntity.getId());
                allList.add(entity);
            }
        }
        List<RoleElementEntity> list;
        if (superRoleService.isSuperRoleByUser(userId)) {
            list = roleElementDao.queryListBySuperRole(roleElementQueryEntity.getRoleId());
        } else {
            list = roleElementDao.queryListByUser(userId, roleElementQueryEntity.getRoleId());
        }
        if (list != null) {
            allList.addAll(list);
        }
        return allList;
    }


    private void verifyRole(List<RoleElementUpdateEntity> list) {
        String roleId = null;
        for (RoleElementUpdateEntity roleElementUpdateEntity     : list) {
            if (roleId == null) {
                roleId = roleElementUpdateEntity.getRoleId();
            } else {
                if (!roleId.equals(roleElementUpdateEntity.getRoleId())) {
                    throw new ApiException("角色ID不错");
                }
            }
        }
    }

    @Override
    public void update(List<RoleElementUpdateEntity> roleElementUpdateEntityList, String userId) {
        verifyRole(roleElementUpdateEntityList);
        if (superRoleService.isSuperRoleByUser(userId)) {
            roleElementDao.deleteByRole(roleElementUpdateEntityList.get(0).getRoleId());
            roleElementDao.saveBatch(roleElementUpdateEntityList);
        } else {
            List<String> enableRight = userElementDao.queryEnableElementIdByUser(userId);
            List<RoleElementUpdateEntity> updateList = new ArrayList<>();
            if (enableRight != null && !enableRight.isEmpty() && !roleElementUpdateEntityList.isEmpty()) {
                for (RoleElementUpdateEntity dataUpdateEntity : roleElementUpdateEntityList) {
                    if (enableRight.contains(dataUpdateEntity.getElementId())) {
                        updateList.add(dataUpdateEntity);
                    }
                }
            }
            roleElementDao.deleteByRole(roleElementUpdateEntityList.get(0).getRoleId());
            roleElementDao.saveBatch(updateList);
        }
    }
}
