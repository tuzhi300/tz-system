package net.kuper.tz.system.service;


import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.entity.UserTokenEntity;
import net.kuper.tz.system.entity.UserTokenQueryEntity;
import net.kuper.tz.system.entity.UserTokenUpdateEntity;

/**
 * 系统用户Token
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2019-04-22 00:40:03
 */
public interface UserTokenService {

    /**
     * 分页查询:系统用户Token
     *
     * @param userTokenQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<UserTokenEntity> queryList(UserTokenQueryEntity userTokenQueryEntity);

    /**
     * 系统用户Token详情查询
     *
     * @param userId
     * @return 系统用户Token
     */
    UserTokenEntity queryObject(String userId);

    /**
     * 创建：系统用户Token
     *
     * @param userTokenAddEntity
     * @return 系统用户Token
     */
    UserTokenEntity save(UserTokenUpdateEntity userTokenAddEntity);

    /**
     * 修改 系统用户Token
     *
     * @param userTokenAddEntity
     * @return
     */
    void update(UserTokenUpdateEntity userTokenAddEntity);

    /**
     * 系统用户Token单条根据删除
     *
     * @param userId
     * @return
     */
    void delete(String userId);

    /**
     * 系统用户Token批量删除
     *
     * @param userIds
     * @return
     */
    void deleteBatch(String[] userIds);

    
    /**
     * 根据token查询:系统用户Token
     *
     * @param token
     * @return 菜单管理
     */
    UserTokenEntity queryObjectByToken(String token);

    /**
     * 创建：系统用户Token
     *
     * @param userId
     * @return 保存条数
     */
    UserTokenEntity createTokenByUser(String userId);

}

