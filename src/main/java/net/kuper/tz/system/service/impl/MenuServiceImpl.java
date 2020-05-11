package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.system.dao.MenuDao;
import net.kuper.tz.system.entity.MenuEntity;
import net.kuper.tz.system.entity.MenuQueryEntity;
import net.kuper.tz.system.entity.MenuUpdateEntity;
import net.kuper.tz.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MenuEntity> queryList(MenuQueryEntity menuQueryEntity) {
        List<MenuEntity> menuList = menuDao.queryList(menuQueryEntity);
        return menuList;
    }

    @Override
    public List<MenuEntity> queryListByParentId(String parentId) {
        return menuDao.queryListByParentId(parentId);
    }

    @Override
    public MenuEntity queryObject(String id) {
        return menuDao.queryObject(id);
    }

    @Override
    public List<MenuEntity> queryUserMenuList(String userId) {
        return menuDao.queryUserMenuList(userId);
    }

    /**
     * 验证菜单类型
     *
     * @param menuUpdateEntity
     */
    private void verifyMenuType(MenuUpdateEntity menuUpdateEntity) {
        MenuEntity parent = null;
        if (menuUpdateEntity.getParentId() != null) {
            parent = menuDao.queryObject(menuUpdateEntity.getParentId());
        }
        if (parent == null) {
            menuUpdateEntity.setParentId(null);
        } else if (parent.getType() == 1 && menuUpdateEntity.getType() == 0) {
            throw new ApiException("页面下不能添加目录菜单");
        }
    }

    /**
     * 验证无限循环
     *
     * @param menuUpdateEntity
     */
    private void verifyCycleParentId(MenuUpdateEntity menuUpdateEntity) {
        List<String> ids = menuDao.queryChildrenId(menuUpdateEntity.getId(), null);
        boolean has = false;
        if (ids != null && !ids.isEmpty()) {
            has = ids.contains(menuUpdateEntity.getParentId());
        }
        if (has) {
            throw new ApiException("不能选择子菜单为当前菜单的父菜单");
        }
    }

    @Override
    public MenuEntity save(MenuUpdateEntity menuUpdateEntity) {
        this.verifyMenuType(menuUpdateEntity);
        if (menuUpdateEntity.getType() == 0) {
            menuUpdateEntity.setComponent(null);
        }
        menuDao.save(menuUpdateEntity);
        return menuDao.queryObject(menuUpdateEntity.getId());
    }

    @Override
    public void update(MenuUpdateEntity menuUpdateEntity) {
        this.verifyMenuType(menuUpdateEntity);
        this.verifyCycleParentId(menuUpdateEntity);
        if (menuUpdateEntity.getType() == 0) {
            menuUpdateEntity.setComponent(null);
        }
        menuDao.update(menuUpdateEntity);
    }

    @Override
    public void delete(String id) {
        List<String> children = menuDao.queryChildrenId(id, null);
        if (children != null && children.size() > 0) {
            throw new ApiException("还有子菜单，不能删除");
        }
        menuDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
//        menuDao.deleteBatch(ids);
    }
}
