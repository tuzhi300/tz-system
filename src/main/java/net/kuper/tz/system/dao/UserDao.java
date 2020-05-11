package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.UserEntity;
import net.kuper.tz.system.entity.UserQueryEntity;
import net.kuper.tz.system.entity.UserUpdateEntity;

import java.util.List;

/**
 * 用户
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface UserDao {

    /**
     * 用户详情
     *
     * @param id
     * @return
     */
    UserEntity queryObject(String id);

    /**
     * 用户列表
     *
     * @param userQueryEntity
     * @return
     */
    List<UserEntity> queryList(UserQueryEntity userQueryEntity);

    /**
     * 用户新增
     *
     * @param userUpdateEntity
     */
    void save(UserUpdateEntity userUpdateEntity);

    /**
     * 用户修改
     *
     * @param userUpdateEntity
     */
    void update(UserUpdateEntity userUpdateEntity);

    /**
     * 修改密码
     *
     * @param userUpdateEntity
     */
    void updatePwd(UserUpdateEntity userUpdateEntity);

    /**
     * 用户单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 用户批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    UserEntity queryByUserName(String userName);
}
