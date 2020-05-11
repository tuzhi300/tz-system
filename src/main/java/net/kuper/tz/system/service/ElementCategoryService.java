package net.kuper.tz.system.service;

import net.kuper.tz.system.entity.ElementCategoryEntity;
import net.kuper.tz.system.entity.ElementCategoryQueryEntity;
import net.kuper.tz.system.entity.ElementCategoryUpdateEntity;

import java.util.List;

/**
 * 元素分类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-08 21:00:14
 */
public interface ElementCategoryService {

    /**
     * 分页查询:元素分类
     *
     * @param elementCategoryQueryEntity 分页查询参数
     * @return Pagination
     */
    List<ElementCategoryEntity> queryList(ElementCategoryQueryEntity elementCategoryQueryEntity);

    /**
      * 元素分类详情查询
      *
      * @param id
      * @return 元素分类
      */
    ElementCategoryEntity queryObject(String id);

    /**
     * 新增：元素分类
     *
     * @param elementCategoryUpdateEntity
     * @return 元素分类
     */
     ElementCategoryEntity save(ElementCategoryUpdateEntity elementCategoryUpdateEntity);

    /**
     * 修改 元素分类
     *
     * @param elementCategoryUpdateEntity
     * @return
     */
    void update(ElementCategoryUpdateEntity elementCategoryUpdateEntity);

    /**
     * 元素分类单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 元素分类批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

