package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.UserDataEntity;
import net.kuper.tz.system.entity.UserDataQueryEntity;
import net.kuper.tz.system.entity.UserDataUpdateEntity;

import java.util.List;

/**
 * 用户数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface UserDataService {

    /**
     * @param userDataQueryEntity
     * @param curUserId
     * @return
     */
    List<UserDataEntity> queryList(UserDataQueryEntity userDataQueryEntity, String curUserId);


    /**
     * 修改 用户数据权限
     *
     * @param userDataUpdateEntities
     * @return
     */
    void update(List<UserDataUpdateEntity> userDataUpdateEntities, String userId);

}

