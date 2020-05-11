package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.RoleDataEntity;
import net.kuper.tz.system.entity.RoleDataQueryEntity;
import net.kuper.tz.system.entity.RoleDataUpdateEntity;

import java.util.List;

/**
 * 角色数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface RoleDataService {

    /**
     * 分页查询:角色数据权限
     *
     * @param roleDataQueryEntity 分页查询参数
     * @return Pagination
     */
    List<RoleDataEntity> queryList(RoleDataQueryEntity roleDataQueryEntity, String userId);

    /**
     * 修改 角色数据权限
     *
     * @param roleDataUpdateEntityList
     * @return
     */
    void update(List<RoleDataUpdateEntity> roleDataUpdateEntityList, String userId);

}

