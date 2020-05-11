package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.MenuEntity;
import net.kuper.tz.system.entity.MenuQueryEntity;
import net.kuper.tz.system.entity.MenuUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface MenuDao {

    /**
     * 菜单详情
     *
     * @param id
     * @return
     */
    MenuEntity queryObject(String id);

    /**
     * 根据上级菜单查询
     *
     * @param parentId
     * @return
     */
    List<MenuEntity> queryListByParentId(String parentId);

    /**
     * 菜单列表
     *
     * @param menuQueryEntity
     * @return
     */
    List<MenuEntity> queryList(MenuQueryEntity menuQueryEntity);

    /**
     * 用户菜单列表
     *
     * @param userId 被查询用户
     * @return
     */
    List<MenuEntity> queryUserMenuList(@Param("userId") String userId);

    /**
     * 查询子菜单列表
     *
     * @param parentId 父菜单Id
     * @return
     */
    List<String> queryChildrenId(@Param("parentId") String parentId, @Param("status") Integer status);

    /**
     * 查询编辑角色菜单信息
     *
     * @param roleId 被操作角色
     * @param userId 当前登录用户
     * @return
     */
    List<MenuEntity> queryEditRoleMenuListByUser(@Param("roleId") String roleId, @Param("userId") String userId);

    /**
     * 查询编辑角色菜单信息（超级管理员角色）
     *
     * @param roleId 被操作角色
     * @return
     */
    List<MenuEntity> queryEditRoleMenuListBySuperRole(@Param("roleId") String roleId);

    /**
     * 菜单新增
     *
     * @param menuUpdateEntity
     */
    void save(MenuUpdateEntity menuUpdateEntity);

    /**
     * 菜单修改
     *
     * @param menuUpdateEntity
     */
    void update(MenuUpdateEntity menuUpdateEntity);

    /**
     * 菜单单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 菜单批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
