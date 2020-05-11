package net.kuper.tz.system.dao;

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
public interface ElementCategoryDao {

    /**
     * 元素分类详情
     *
     * @param id
     * @return
     */
    ElementCategoryEntity queryObject(String id);

    /**
     *  元素分类列表
     *
     * @param elementCategoryQueryEntity
     * @return
     */
    List<ElementCategoryEntity> queryList(ElementCategoryQueryEntity elementCategoryQueryEntity);

    /**
     * 元素分类新增
     *
     * @param elementCategoryUpdateEntity
     */
    void save(ElementCategoryUpdateEntity elementCategoryUpdateEntity);

    /**
     *  元素分类修改
     *
     * @param elementCategoryUpdateEntity
     */
    void update(ElementCategoryUpdateEntity elementCategoryUpdateEntity);

    /**
     * 元素分类单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 元素分类批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
