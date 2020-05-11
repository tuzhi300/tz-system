package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.OperationEntity;
import net.kuper.tz.system.entity.OperationQueryEntity;
import net.kuper.tz.system.entity.OperationUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作（接口）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
public interface OperationDao {

    /**
     * 操作（接口）详情
     *
     * @param id
     * @return
     */
    OperationEntity queryObject(String id);

    /**
     * 操作（接口）列表
     *
     * @param operationQueryEntity
     * @return
     */
    List<OperationEntity> queryList(OperationQueryEntity operationQueryEntity);

    /**
     * 用户操作（接口）代码列表
     *
     * @param userId
     * @return
     */
    List<String> queryUserOperationCodeList(@Param("userId") String userId);

    /**
     * 操作（接口）新增
     *
     * @param operationUpdateEntity
     */
    void save(OperationUpdateEntity operationUpdateEntity);

    /**
     * 操作（接口）修改
     *
     * @param operationUpdateEntity
     */
    void update(OperationUpdateEntity operationUpdateEntity);

    /**
     * 操作（接口）单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 操作（接口）批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
