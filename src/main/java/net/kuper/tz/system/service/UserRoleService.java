package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.UserRoleEntity;
import net.kuper.tz.system.entity.UserRoleQueryEntity;
import net.kuper.tz.system.entity.UserRoleUpdateEntity;

import java.util.List;

/**
 * 用户角色
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:13
 */
public interface UserRoleService {

    /**
     * 查询用户的角色列表
     *
     * @param userRoleQueryEntity
     * @param curUserId
     * @return
     */
    List<UserRoleEntity> queryList(UserRoleQueryEntity userRoleQueryEntity, String curUserId);


    /**
     * 用户角色详情查询
     *
     * @param id
     * @return 用户角色
     */
    UserRoleEntity queryObject(String id);

    /**
     * 新增：用户角色
     *
     * @param userRoleUpdateEntity
     * @return 用户角色
     */
    UserRoleEntity save(UserRoleUpdateEntity userRoleUpdateEntity);

    /**
     * 用户角色单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id, String userId);
}

