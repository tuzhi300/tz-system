package net.kuper.tz.system.service;

import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.entity.OperationEntity;
import net.kuper.tz.system.entity.OperationQueryEntity;
import net.kuper.tz.system.entity.OperationUpdateEntity;

import java.util.List;

/**
 * 操作（接口）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface OperationService {

    /**
     * 分页查询:操作（接口）
     *
     * @param operationQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<OperationEntity> queryList(OperationQueryEntity operationQueryEntity);

    /**
     * 按控制器查询
     *
     * @param controllerId
     * @return
     */
    List<OperationEntity> queryListByController(String controllerId);

    /**
     * 操作（接口）详情查询
     *
     * @param id
     * @return 操作（接口）
     */
    OperationEntity queryObject(String id);

    /**
     * 查询用户操作代码
     *
     * @param userId
     * @return
     */
    List<String> queryUserOperationCodeList(String userId);

    /**
     * 新增：操作（接口）
     *
     * @param operationUpdateEntity
     * @return 操作（接口）
     */
    OperationEntity save(OperationUpdateEntity operationUpdateEntity);

    /**
     * 修改 操作（接口）
     *
     * @param operationUpdateEntity
     * @return
     */
    void update(OperationUpdateEntity operationUpdateEntity);

    /**
     * 操作（接口）单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 操作（接口）批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

