package net.kuper.tz.system.service;

import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.entity.UserEntity;
import net.kuper.tz.system.entity.UserQueryEntity;
import net.kuper.tz.system.entity.UserUpdateEntity;
import net.kuper.tz.system.params.UserUpdatePwdEntity;

/**
 * 用户
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface UserService {

    /**
     * 分页查询:用户
     *
     * @param userQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<UserEntity> queryList(UserQueryEntity userQueryEntity);

    /**
     * 用户详情查询
     *
     * @param id
     * @return 用户
     */
    UserEntity queryObject(String id);

    /**
     * 新增：用户
     *
     * @param userUpdateEntity
     * @return 用户
     */
    UserEntity save(UserUpdateEntity userUpdateEntity);

    /**
     * 修改 用户
     *
     * @param userUpdateEntity
     * @return
     */
    void update(UserUpdateEntity userUpdateEntity);

    /**
     * 修改密码
     *
     * @param userUpdateEntity
     */
    void updatePwd(UserUpdatePwdEntity userUpdateEntity);

    /**
     * 重置密码
     *
     * @param userId
     */
    void resetPwd(String userId);

    /**
     * 查询用户账号
     *
     * @param account
     * @return
     */
    UserEntity queryByUserName(String account);

    /**
     * 用户单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 用户批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

