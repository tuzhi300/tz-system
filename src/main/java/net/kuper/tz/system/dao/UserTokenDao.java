package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.UserTokenEntity;
import net.kuper.tz.system.entity.UserTokenQueryEntity;
import net.kuper.tz.system.entity.UserTokenUpdateEntity;

import java.util.List;

/**
 * 系统用户Token
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2019-04-22 00:40:03
 */
public interface UserTokenDao {

    /**
     * 系统用户Token详情
     *
     * @param userId
     * @return
     */
    UserTokenEntity queryObject(String userId);

    /**
     *  系统用户Token列表
     *
     * @param userTokenQueryEntity
     * @return
     */
    List<UserTokenEntity> queryList(UserTokenQueryEntity userTokenQueryEntity);

    /**
     * 系统用户Token新增
     *
     * @param userTokenUpdateEntity
     */
    void save(UserTokenUpdateEntity userTokenUpdateEntity);

    /**
     *  系统用户Token修改
     *
     * @param userTokenUpdateEntity
     */
    void update(UserTokenUpdateEntity userTokenUpdateEntity);

    /**
     * 系统用户Token单条删除
     *
     * @param userId
     */
    void delete(String userId);

    /**
     * 系统用户Token批量删除
     *
     * @param userIds
     */
    void deleteBatch(String[] userIds);



    UserTokenEntity queryObjectByToken(String token);
}
