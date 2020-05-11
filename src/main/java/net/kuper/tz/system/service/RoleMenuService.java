package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.RoleMenuEntity;
import net.kuper.tz.system.entity.RoleMenuQueryEntity;
import net.kuper.tz.system.entity.RoleMenuUpdateEntity;

import java.util.List;

/**
 * 
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface RoleMenuService {

    /**
     * 分页查询:
     *
     * @param roleMenuQueryEntity 分页查询参数
     * @return Pagination
     */
    List<RoleMenuEntity> queryList(RoleMenuQueryEntity roleMenuQueryEntity, String userId);

    /**
     * 修改 
     *
     * @param roleMenuUpdateEntities
     * @return
     */
    void update(List<RoleMenuUpdateEntity> roleMenuUpdateEntities, String userId);

}

