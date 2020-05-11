package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.MenuEntity;
import net.kuper.tz.system.entity.MenuQueryEntity;
import net.kuper.tz.system.entity.MenuUpdateEntity;

import java.util.List;

/**
 * 菜单
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface MenuService {

    /**
     * 分页查询:菜单
     *
     * @param menuQueryEntity 分页查询参数
     * @return Pagination
     */
    List<MenuEntity> queryList(MenuQueryEntity menuQueryEntity);

    /**
     * 根据上级菜单查询子菜单
     *
     * @param parentId
     * @return
     */
    List<MenuEntity> queryListByParentId(String parentId);

    /**
     * 菜单详情查询
     *
     * @param id
     * @return 菜单
     */
    MenuEntity queryObject(String id);

    /**
     * 菜单详情查询
     *
     * @param userId
     * @return 菜单
     */
    List<MenuEntity> queryUserMenuList(String userId);

    /**
     * 新增：菜单
     *
     * @param menuUpdateEntity
     * @return 菜单
     */
    MenuEntity save(MenuUpdateEntity menuUpdateEntity);

    /**
     * 修改 菜单
     *
     * @param menuUpdateEntity
     * @return
     */
    void update(MenuUpdateEntity menuUpdateEntity);

    /**
     * 菜单单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 菜单批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

