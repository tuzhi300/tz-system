package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.UserElementEntity;
import net.kuper.tz.system.entity.UserElementQueryEntity;
import net.kuper.tz.system.entity.UserElementUpdateEntity;

import java.util.List;

/**
 * 用户菜单功能
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface UserElementService {

    /**
     * 分页查询:用户菜单功能
     *
     * @param userElementQueryEntity 分页查询参数
     * @return Pagination
     */
    List<UserElementEntity> queryList(UserElementQueryEntity userElementQueryEntity, String userId);

    /**
     * 修改 用户菜单功能
     *
     * @param userElementUpdateEntities
     * @return
     */
    void update(List<UserElementUpdateEntity> userElementUpdateEntities,String userId);


}

