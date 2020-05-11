package net.kuper.tz.system.service;

import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.entity.LoginLogEntity;
import net.kuper.tz.system.entity.LoginLogQueryEntity;
import net.kuper.tz.system.entity.LoginLogUpdateEntity;

/**
 * 登录历史
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:33:53
 */
public interface LoginLogService {

    /**
     * 分页查询:登录历史
     *
     * @param loginLogQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<LoginLogEntity> queryList(LoginLogQueryEntity loginLogQueryEntity);

    /**
      * 登录历史详情查询
      *
      * @param id
      * @return 登录历史
      */
    LoginLogEntity queryObject(String id);

    /**
     * 新增：登录历史
     *
     * @param loginLogUpdateEntity
     * @return 登录历史
     */
     LoginLogEntity save(LoginLogUpdateEntity loginLogUpdateEntity);

    /**
     * 修改 登录历史
     *
     * @param loginLogUpdateEntity
     * @return
     */
    void update(LoginLogUpdateEntity loginLogUpdateEntity);

    /**
     * 登录历史单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 登录历史批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

