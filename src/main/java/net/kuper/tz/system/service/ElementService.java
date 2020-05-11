package net.kuper.tz.system.service;

import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.entity.ElementEntity;
import net.kuper.tz.system.entity.ElementQueryEntity;
import net.kuper.tz.system.entity.ElementUpdateEntity;

import java.util.List;

/**
 * 页面元素（功能按钮）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-06 17:07:58
 */
public interface ElementService {

    /**
     * 分页查询:页面元素（功能按钮）
     *
     * @param elementQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<ElementEntity> queryList(ElementQueryEntity elementQueryEntity);

    /**
     * 页面元素（功能按钮）详情查询
     *
     * @param id
     * @return 页面元素（功能按钮）
     */
    ElementEntity queryObject(String id);

    /**
     * 查询用户的页面权限代码
     *
     * @param userId
     * @return
     */
    List<String> queryCodeListByUser(String userId);

    /**
     * 新增：页面元素（功能按钮）
     *
     * @param elementUpdateEntity
     * @return 页面元素（功能按钮）
     */
    ElementEntity save(ElementUpdateEntity elementUpdateEntity);

    /**
     * 修改 页面元素（功能按钮）
     *
     * @param elementUpdateEntity
     * @return
     */
    void update(ElementUpdateEntity elementUpdateEntity);

    /**
     * 页面元素（功能按钮）单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 页面元素（功能按钮）批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

