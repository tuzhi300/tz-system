package net.kuper.tz.system.service;

import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.entity.RoleEntity;
import net.kuper.tz.system.entity.RoleQueryEntity;
import net.kuper.tz.system.entity.RoleUpdateEntity;

import java.util.List;

/**
 * 角色
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface RoleService {

    /**
     * 分页查询:角色
     *
     * @param roleQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<RoleEntity> queryList(RoleQueryEntity roleQueryEntity);

    /**
     * 按部门查询
     *
     * @param deptId
     * @return
     */
    List<RoleEntity> queryListByDept(String deptId);

    /**
     * 角色详情查询
     *
     * @param id
     * @return 角色
     */
    RoleEntity queryObject(String id);

    /**
     * 新增：角色
     *
     * @param roleUpdateEntity
     * @return 角色
     */
    RoleEntity save(RoleUpdateEntity roleUpdateEntity);

    /**
     * 修改 角色
     *
     * @param roleUpdateEntity
     * @return
     */
    void update(RoleUpdateEntity roleUpdateEntity);

    /**
     * 角色单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 角色批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

