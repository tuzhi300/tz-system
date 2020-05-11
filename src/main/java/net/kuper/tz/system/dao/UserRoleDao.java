package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.UserRoleEntity;
import net.kuper.tz.system.entity.UserRoleQueryEntity;
import net.kuper.tz.system.entity.UserRoleUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:13
 */
public interface UserRoleDao {

    /**
     * 用户角色详情
     *
     * @param id
     * @return
     */
    UserRoleEntity queryObject(String id);

    /**
     * 用户角色列表
     *
     * @param userRoleQueryEntity
     * @return
     */
    List<UserRoleEntity> queryList(UserRoleQueryEntity userRoleQueryEntity);

    /**
     * 查询用户角色
     *
     * @param userI
     * @param curUserId
     * @return
     */
    List<UserRoleEntity> queryListByUser(@Param("userId") String userI, @Param("curUserId") String curUserId);

    /**
     * 用户角色新增
     *
     * @param userRoleUpdateEntity
     */
    void save(UserRoleUpdateEntity userRoleUpdateEntity);

    /**
     * 用户角色修改
     *
     * @param userRoleUpdateEntity
     */
    void update(UserRoleUpdateEntity userRoleUpdateEntity);

    /**
     * 用户角色单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 用户角色批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
