package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.ElementOperationEntity;
import net.kuper.tz.system.entity.ElementOperationQueryEntity;
import net.kuper.tz.system.entity.ElementOperationUpdateEntity;

import java.util.List;

/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 11:02:55
 */
public interface ElementOperationService {

    /**
     * 分页查询:
     *
     * @param elementOperationQueryEntity 分页查询参数
     * @return Pagination
     */
    List<ElementOperationEntity> queryList(ElementOperationQueryEntity elementOperationQueryEntity, String userId);

    /**
     * 新增：
     *
     * @param elementOperationUpdateEntity
     * @return
     */
    ElementOperationEntity save(ElementOperationUpdateEntity elementOperationUpdateEntity);

    /**
     * 单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id, String userId);

}

