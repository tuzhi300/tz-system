package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.RoleDataEntity;
import net.kuper.tz.system.entity.RoleDataQueryEntity;
import net.kuper.tz.system.entity.RoleDataUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface RoleDataDao {

    /**
     * 角色数据权限详情
     *
     * @param id
     * @return
     */
    RoleDataEntity queryObject(String id);

    /**
     * 角色数据权限列表
     *
     * @param roleDataQueryEntity
     * @return
     */
    List<RoleDataEntity> queryList(RoleDataQueryEntity roleDataQueryEntity);

    /**
     * 超级角色用户查询
     *
     * @param roleId
     * @return
     */
    List<RoleDataEntity> queryListBySuperRole(@Param("roleId") String roleId);

    /**
     * 普通角色用户查询
     *
     * @param roleId
     * @param userId
     * @return
     */
    List<RoleDataEntity> queryListByUser(@Param("roleId") String roleId, @Param("userId") String userId);


    /**
     * 角色数据权限新增
     *
     * @param roleDataUpdateEntity
     */
    void save(RoleDataUpdateEntity roleDataUpdateEntity);

    /**
     * 批量保存
     *
     * @param roleDataUpdateEntityList
     */
    void saveBatch(List<RoleDataUpdateEntity> roleDataUpdateEntityList);

    /**
     * 角色数据权限修改
     *
     * @param roleDataUpdateEntity
     */
    void update(RoleDataUpdateEntity roleDataUpdateEntity);


    void deleteByRole(String roleId);

    /**
     * 角色数据权限单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 角色数据权限批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
