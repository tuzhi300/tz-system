package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.DeptEntity;
import net.kuper.tz.system.entity.DeptQueryEntity;
import net.kuper.tz.system.entity.DeptUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface DeptDao {

    /**
     * 部门详情
     *
     * @param id
     * @return
     */
    DeptEntity queryObject(String id);

    /**
     * 部门列表
     *
     * @param deptQueryEntity
     * @return
     */
    List<DeptEntity> queryList(DeptQueryEntity deptQueryEntity);

    /**
     * 查询子部门
     *
     * @param parentId
     * @param status
     * @return
     */
    List<DeptEntity> queryListByParentId(@Param("parentId") String parentId, @Param("status") Integer status);

    /**
     * 查询子部门列表
     *
     * @param parentId 上级部门Id
     * @param status   子部门状态
     * @return
     */
    List<String> queryChildrenId(@Param("parentId") String parentId, @Param("status") Integer status);

    /**
     * 部门新增
     *
     * @param deptUpdateEntity
     */
    void save(DeptUpdateEntity deptUpdateEntity);

    /**
     * 部门修改
     *
     * @param deptUpdateEntity
     */
    void update(DeptUpdateEntity deptUpdateEntity);

    /**
     * 部门单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 部门批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
