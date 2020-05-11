package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.UserMenuEntity;
import net.kuper.tz.system.entity.UserMenuQueryEntity;
import net.kuper.tz.system.entity.UserMenuUpdateEntity;

import java.util.List;

/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface UserMenuService {

    /**
     * @param userMenuQueryEntity
     * @param userId
     * @return
     */
    List<UserMenuEntity> queryList(UserMenuQueryEntity userMenuQueryEntity, String userId);

    /**
     * 修改
     *
     * @param userMenuUpdateEntities
     * @param userId
     * @return
     */
    void update(List<UserMenuUpdateEntity> userMenuUpdateEntities, String userId);


}

