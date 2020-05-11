package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.LoginLogEntity;
import net.kuper.tz.system.entity.LoginLogQueryEntity;
import net.kuper.tz.system.entity.LoginLogUpdateEntity;

import java.util.List;

/**
 * 登录历史
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:33:53
 */
public interface LoginLogDao {

    /**
     * 登录历史详情
     *
     * @param id
     * @return
     */
    LoginLogEntity queryObject(String id);

    /**
     *  登录历史列表
     *
     * @param loginLogQueryEntity
     * @return
     */
    List<LoginLogEntity> queryList(LoginLogQueryEntity loginLogQueryEntity);

    /**
     * 登录历史新增
     *
     * @param loginLogUpdateEntity
     */
    void save(LoginLogUpdateEntity loginLogUpdateEntity);

    /**
     *  登录历史修改
     *
     * @param loginLogUpdateEntity
     */
    void update(LoginLogUpdateEntity loginLogUpdateEntity);

    /**
     * 登录历史单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 登录历史批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
