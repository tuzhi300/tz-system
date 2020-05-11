package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.UserMenuEntity;
import net.kuper.tz.system.entity.UserMenuQueryEntity;
import net.kuper.tz.system.entity.UserMenuUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface UserMenuDao {

    /**
     * 详情
     *
     * @param id
     * @return
     */
    UserMenuEntity queryObject(String id);

    /**
     * 列表
     *
     * @param userMenuQueryEntity
     * @return
     */
    List<UserMenuEntity> queryList(UserMenuQueryEntity userMenuQueryEntity);

    /**
     * 根据用户查询读写权限菜单
     *
     * @param userId
     * @return
     */
    List<String> queryEnableMenuIdByUser(@Param("userId") String userId);

    /**
     * 查询用户授权信息
     *
     * @param userId
     * @param curUserId
     * @return
     */
    List<UserMenuEntity> queryListByUser(@Param("userId") String userId, @Param("curUserId") String curUserId);

    /**
     * 查询超级用户菜单
     *
     * @return
     */
    List<String> queryEnableMenuIdBySuperRole();

    /**
     * 新增
     *
     * @param userMenuUpdateEntity
     */
    void save(UserMenuUpdateEntity userMenuUpdateEntity);

    /**
     * 批量保存
     *
     * @param userDataUpdateEntities
     */
    void saveBatch(List<UserMenuUpdateEntity> userDataUpdateEntities);

    /**
     * 修改
     *
     * @param userMenuUpdateEntity
     */
    void update(UserMenuUpdateEntity userMenuUpdateEntity);

    /**
     * 单条删除
     *
     * @param id
     */
    void delete(String id);
    /**
     * 删除用户菜单
     *
     * @param userId
     */
    void deleteByUser(String userId);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
