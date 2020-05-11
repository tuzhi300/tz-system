package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.ElementOperationEntity;
import net.kuper.tz.system.entity.ElementOperationQueryEntity;
import net.kuper.tz.system.entity.ElementOperationUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 11:02:55
 */
public interface ElementOperationDao {

    /**
     * 详情
     *
     * @param id
     * @return
     */
    ElementOperationEntity queryObject(String id);

    /**
     * 列表
     *
     * @param elementOperationQueryEntity
     * @return
     */
    List<ElementOperationEntity> queryList(ElementOperationQueryEntity elementOperationQueryEntity);

    List<ElementOperationEntity> queryListByElement(@Param("elementId") String elementId, @Param("userId") String userId);

    /**
     * 新增
     *
     * @param elementOperationUpdateEntity
     */
    void save(ElementOperationUpdateEntity elementOperationUpdateEntity);

    /**
     * 修改
     *
     * @param elementOperationUpdateEntity
     */
    void update(ElementOperationUpdateEntity elementOperationUpdateEntity);

    /**
     * 单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
