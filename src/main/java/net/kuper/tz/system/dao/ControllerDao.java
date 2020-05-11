package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.ControllerEntity;
import net.kuper.tz.system.entity.ControllerQueryEntity;
import net.kuper.tz.system.entity.ControllerUpdateEntity;

import java.util.List;

/**
 * 控制器（接口操作分类）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface ControllerDao {

    /**
     * 控制器（接口操作分类）详情
     *
     * @param id
     * @return
     */
    ControllerEntity queryObject(String id);

    /**
     *  控制器（接口操作分类）列表
     *
     * @param controllerQueryEntity
     * @return
     */
    List<ControllerEntity> queryList(ControllerQueryEntity controllerQueryEntity);

    /**
     * 控制器（接口操作分类）新增
     *
     * @param controllerUpdateEntity
     */
    void save(ControllerUpdateEntity controllerUpdateEntity);

    /**
     *  控制器（接口操作分类）修改
     *
     * @param controllerUpdateEntity
     */
    void update(ControllerUpdateEntity controllerUpdateEntity);

    /**
     * 控制器（接口操作分类）单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 控制器（接口操作分类）批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
