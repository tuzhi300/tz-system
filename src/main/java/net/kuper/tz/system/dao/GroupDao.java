package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.GroupEntity;
import net.kuper.tz.system.entity.GroupQueryEntity;
import net.kuper.tz.system.entity.GroupUpdateEntity;

import java.util.List;

/**
 * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface GroupDao {

    /**
     * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]详情
     *
     * @param id
     * @return
     */
    GroupEntity queryObject(String id);

    /**
     *  角色或用户组[仅实现分组，代码中按组实现批量处理功能]列表
     *
     * @param groupQueryEntity
     * @return
     */
    List<GroupEntity> queryList(GroupQueryEntity groupQueryEntity);

    /**
     * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]新增
     *
     * @param groupUpdateEntity
     */
    void save(GroupUpdateEntity groupUpdateEntity);

    /**
     *  角色或用户组[仅实现分组，代码中按组实现批量处理功能]修改
     *
     * @param groupUpdateEntity
     */
    void update(GroupUpdateEntity groupUpdateEntity);

    /**
     * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
