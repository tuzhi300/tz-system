package net.kuper.tz.system.service;

import net.kuper.tz.core.mybatis.Pagination;
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
public interface ControllerService {

    /**
     * 分页查询:控制器（接口操作分类）
     *
     * @param controllerQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<ControllerEntity> queryList(ControllerQueryEntity controllerQueryEntity);

    /**
     * 按模块查询控制器
     * @param module
     * @return
     */
    List<ControllerEntity> queryList(String module);

    /**
      * 控制器（接口操作分类）详情查询
      *
      * @param id
      * @return 控制器（接口操作分类）
      */
    ControllerEntity queryObject(String id);

    /**
     * 新增：控制器（接口操作分类）
     *
     * @param controllerUpdateEntity
     * @return 控制器（接口操作分类）
     */
     ControllerEntity save(ControllerUpdateEntity controllerUpdateEntity);

    /**
     * 修改 控制器（接口操作分类）
     *
     * @param controllerUpdateEntity
     * @return
     */
    void update(ControllerUpdateEntity controllerUpdateEntity);

    /**
     * 控制器（接口操作分类）单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 控制器（接口操作分类）批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

