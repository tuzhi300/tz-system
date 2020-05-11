package net.kuper.tz.system.dao;

import net.kuper.tz.system.entity.ElementEntity;
import net.kuper.tz.system.entity.ElementQueryEntity;
import net.kuper.tz.system.entity.ElementUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 页面元素（功能按钮）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-06 17:07:58
 */
public interface ElementDao {

    /**
     * 页面元素（功能按钮）详情
     *
     * @param id
     * @return
     */
    ElementEntity queryObject(String id);

    /**
     * 页面元素（功能按钮）列表
     *
     * @param elementQueryEntity
     * @return
     */
    List<ElementEntity> queryList(ElementQueryEntity elementQueryEntity);

    /**
     * 查询页面权限代码
     *
     * @param userId
     * @return
     */
    List<String> queryCodeListByUser(@Param("userId") String userId);

    /**
     * 页面元素（功能按钮）新增
     *
     * @param elementUpdateEntity
     */
    void save(ElementUpdateEntity elementUpdateEntity);

    /**
     * 页面元素（功能按钮）修改
     *
     * @param elementUpdateEntity
     */
    void update(ElementUpdateEntity elementUpdateEntity);

    /**
     * 页面元素（功能按钮）单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 页面元素（功能按钮）批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
