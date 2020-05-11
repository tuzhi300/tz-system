package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.UserDataEntity;
import net.kuper.tz.system.entity.UserDataQueryEntity;
import net.kuper.tz.system.entity.UserDataUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface UserDataDao {

    /**
     * 用户数据权限详情
     *
     * @param id
     * @return
     */
    UserDataEntity queryObject(String id);

    /**
     * 用户数据权限列表
     *
     * @param userDataQueryEntity
     * @return
     */
    List<UserDataEntity> queryList(UserDataQueryEntity userDataQueryEntity);

    /**
     * 查询用户读写权限的部门
     *
     * @param userId
     * @return
     */
    List<String> queryEnableDeptIdList(@Param("userId") String userId);

    /**
     * 查询用户授权信息
     *
     * @param userId
     * @param curUserId
     * @return
     */
    List<UserDataEntity> queryListByUser(@Param("userId") String userId, @Param("curUserId") String curUserId);


    /**
     * 用户数据权限新增
     *
     * @param userDataUpdateEntity
     */
    void save(UserDataUpdateEntity userDataUpdateEntity);

    /**
     * 批量保存
     *
     * @param userDataUpdateEntities
     */
    void saveBatch(List<UserDataUpdateEntity> userDataUpdateEntities);

    /**
     * 用户数据权限修改
     *
     * @param userDataUpdateEntity
     */
    void update(UserDataUpdateEntity userDataUpdateEntity);

    /**
     * 用户数据权限单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 删除用户数据权限
     *
     * @param userId
     */
    void deleteByUser(String userId);

    /**
     * 用户数据权限批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
