package net.kuper.tz.system.service;

import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.entity.GroupEntity;
import net.kuper.tz.system.entity.GroupQueryEntity;
import net.kuper.tz.system.entity.GroupUpdateEntity;

/**
 * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface GroupService {

    /**
     * 分页查询:角色或用户组[仅实现分组，代码中按组实现批量处理功能]
     *
     * @param groupQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<GroupEntity> queryList(GroupQueryEntity groupQueryEntity);

    /**
      * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]详情查询
      *
      * @param id
      * @return 角色或用户组[仅实现分组，代码中按组实现批量处理功能]
      */
    GroupEntity queryObject(String id);

    /**
     * 新增：角色或用户组[仅实现分组，代码中按组实现批量处理功能]
     *
     * @param groupUpdateEntity
     * @return 角色或用户组[仅实现分组，代码中按组实现批量处理功能]
     */
     GroupEntity save(GroupUpdateEntity groupUpdateEntity);

    /**
     * 修改 角色或用户组[仅实现分组，代码中按组实现批量处理功能]
     *
     * @param groupUpdateEntity
     * @return
     */
    void update(GroupUpdateEntity groupUpdateEntity);

    /**
     * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

