package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.RoleEntity;
import net.kuper.tz.system.entity.RoleQueryEntity;
import net.kuper.tz.system.entity.RoleUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface RoleDao {

    /**
     * 角色详情
     *
     * @param id
     * @return
     */
    RoleEntity queryObject(String id);

    /**
     *  角色列表
     *
     * @param roleQueryEntity
     * @return
     */
    List<RoleEntity> queryList(RoleQueryEntity roleQueryEntity);

    /**
     * 查询用户的所有角色Id
     * @param userId
     * @return
     */
    List<String> queryUserRoleIds(@Param("userId") String userId);

    /**
     * 角色新增
     *
     * @param roleUpdateEntity
     */
    void save(RoleUpdateEntity roleUpdateEntity);

    /**
     *  角色修改
     *
     * @param roleUpdateEntity
     */
    void update(RoleUpdateEntity roleUpdateEntity);

    /**
     * 角色单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 角色批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
