package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.DeptEntity;
import net.kuper.tz.system.entity.DeptQueryEntity;
import net.kuper.tz.system.entity.DeptUpdateEntity;

import java.util.List;

/**
 * 部门
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface DeptService {

    /**
     * 分页查询:部门
     *
     * @param deptQueryEntity 分页查询参数
     * @return Pagination
     */
    List<DeptEntity> queryList(DeptQueryEntity deptQueryEntity);

    /**
     * 部门详情查询
     *
     * @param id
     * @return 部门
     */
    DeptEntity queryObject(String id);

    /**
     * 查询子部门
     *
     * @param
     * @return 部门列表
     */
    List<DeptEntity> queryListByParentId(String parentId);

    /**
     * 自动生成部门编号
     *
     * @param
     * @return 部门列表
     */
    String autoBuildCode(String parentId);

    /**
     * 新增：部门
     *
     * @param deptUpdateEntity
     * @return 部门
     */
    DeptEntity save(DeptUpdateEntity deptUpdateEntity);

    /**
     * 修改 部门
     *
     * @param deptUpdateEntity
     * @return
     */
    void update(DeptUpdateEntity deptUpdateEntity);

    /**
     * 部门单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 部门批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

