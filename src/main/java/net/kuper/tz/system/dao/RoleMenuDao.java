package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.RoleMenuEntity;
import net.kuper.tz.system.entity.RoleMenuQueryEntity;
import net.kuper.tz.system.entity.RoleMenuUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface RoleMenuDao {

    /**
     * 详情
     *
     * @param id
     * @return
     */
    RoleMenuEntity queryObject(String id);

    /**
     * 列表
     *
     * @param roleMenuQueryEntity
     * @return
     */
    List<RoleMenuEntity> queryList(RoleMenuQueryEntity roleMenuQueryEntity);

    /**
     * 超级角色用户查询
     *
     * @param roleId
     * @return
     */
    List<RoleMenuEntity> queryListBySuperRole(@Param("roleId") String roleId);

    /**
     * 普通角色用户查询
     *
     * @param roleId
     * @param userId
     * @return
     */
    List<RoleMenuEntity> queryListByUser(@Param("roleId") String roleId, @Param("userId") String userId);


    /**
     * 新增
     *
     * @param roleMenuUpdateEntity
     */
    void save(RoleMenuUpdateEntity roleMenuUpdateEntity);

    /**
     * 批量保存
     *
     * @param roleMenuUpdateEntity
     */
    void saveBatch(List<RoleMenuUpdateEntity> roleMenuUpdateEntity);

    /**
     * 修改
     *
     * @param roleMenuUpdateEntity
     */
    void update(RoleMenuUpdateEntity roleMenuUpdateEntity);

    /**
     * 单条删除
     *
     * @param id
     */
    void delete(String id);

    void deleteByRole(String roleId);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
