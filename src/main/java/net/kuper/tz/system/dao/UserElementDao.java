package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.UserElementEntity;
import net.kuper.tz.system.entity.UserElementQueryEntity;
import net.kuper.tz.system.entity.UserElementUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户菜单功能
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface UserElementDao {

    /**
     * 用户菜单功能详情
     *
     * @param id
     * @return
     */
    UserElementEntity queryObject(String id);

    /**
     * 用户菜单功能列表
     *
     * @param userElementQueryEntity
     * @return
     */
    List<UserElementEntity> queryList(UserElementQueryEntity userElementQueryEntity);

    /**
     * 查询用户可编辑菜单元素
     *
     * @param userId
     * @return
     */
    List<String> queryEnableElementIdByUser(@Param("userId") String userId);

    /**
     * 按超级用户查询
     * @param userId
     * @return
     */
    List<UserElementEntity> queryListBySuperRole(@Param("userId") String userId);

    /**
     *
     * @param userId
     * @param curUserId
     * @return
     */
    List<UserElementEntity> queryListByUser(@Param("userId") String userId, @Param("curUserId") String curUserId);

    /**
     * 用户菜单功能新增
     *
     * @param userElementUpdateEntity
     */
    void save(UserElementUpdateEntity userElementUpdateEntity);

    /**
     * 批量保存
     *
     * @param userElementUpdateEntities
     */
    void saveBatch(List<UserElementUpdateEntity> userElementUpdateEntities);

    /**
     * 用户菜单功能修改
     *
     * @param userElementUpdateEntity
     */
    void update(UserElementUpdateEntity userElementUpdateEntity);

    /**
     * 用户菜单功能单条删除
     *
     * @param id
     */
    void delete(String id);
    /**
     * 删除用户权限
     *
     * @param userId
     */
    void deleteByUser(String userId);

    /**
     * 用户菜单功能批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
