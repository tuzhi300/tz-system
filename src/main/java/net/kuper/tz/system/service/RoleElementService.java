package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.RoleElementEntity;
import net.kuper.tz.system.entity.RoleElementQueryEntity;
import net.kuper.tz.system.entity.RoleElementUpdateEntity;

import java.util.List;

/**
 * 角色菜单元素
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
public interface RoleElementService {

    /**
     * 分页查询:角色菜单元素
     *
     * @param roleElementQueryEntity 分页查询参数
     * @return Pagination
     */
    List<RoleElementEntity> queryList(RoleElementQueryEntity roleElementQueryEntity, String userId);


    /**
     * 修改 角色菜单元素
     *
     * @param roleElementUpdateEntities
     * @param userId
     * @return
     */
    void update(List<RoleElementUpdateEntity> roleElementUpdateEntities,String userId);

}

