package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.RoleElementEntity;
import net.kuper.tz.system.entity.RoleElementQueryEntity;
import net.kuper.tz.system.entity.RoleElementUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单元素
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface RoleElementDao {

    /**
     * 角色菜单元素详情
     *
     * @param id
     * @return
     */
    RoleElementEntity queryObject(String id);

    /**
     * 角色菜单元素列表
     *
     * @param roleElementQueryEntity
     * @return
     */
    List<RoleElementEntity> queryList(RoleElementQueryEntity roleElementQueryEntity);

    /**
     * 超级角色用户查询
     *
     * @param roleId
     * @return
     */
    List<RoleElementEntity> queryListBySuperRole(@Param("roleId") String roleId);

    /**
     * 普通角色用户查询
     *
     * @param userId
     * @param roleId
     * @return
     */
    List<RoleElementEntity> queryListByUser(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 角色菜单元素新增
     *
     * @param roleElementUpdateEntity
     */
    void save(RoleElementUpdateEntity roleElementUpdateEntity);

    /**
     * 批量保存
     *
     * @param roleElementUpdateEntities
     */
    void saveBatch(List<RoleElementUpdateEntity> roleElementUpdateEntities);

    /**
     * 角色菜单元素修改
     *
     * @param roleElementUpdateEntity
     */
    void update(RoleElementUpdateEntity roleElementUpdateEntity);

    /**
     * 按角色删除
     *
     * @param roleId
     */
    void deleteByRole(String roleId);

    /**
     * 角色菜单元素单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 角色菜单元素批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
