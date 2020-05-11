package net.kuper.tz.system.service.impl;

import net.kuper.tz.system.dao.ElementCategoryDao;
import net.kuper.tz.system.entity.ElementCategoryEntity;
import net.kuper.tz.system.entity.ElementCategoryQueryEntity;
import net.kuper.tz.system.entity.ElementCategoryUpdateEntity;
import net.kuper.tz.system.service.ElementCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 元素分类Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-08 21:00:14
 */
@Service("elementCategoryService" )
public class ElementCategoryServiceImpl implements ElementCategoryService {

    @Autowired
    private ElementCategoryDao elementCategoryDao;

    @Override
    public List<ElementCategoryEntity> queryList(ElementCategoryQueryEntity elementCategoryQueryEntity) {
        List<ElementCategoryEntity> elementCategoryList = elementCategoryDao.queryList(elementCategoryQueryEntity);
        return elementCategoryList;
    }

    @Override
    public ElementCategoryEntity queryObject(String id) {
        return elementCategoryDao.queryObject(id);
    }

    @Override
    public ElementCategoryEntity save(ElementCategoryUpdateEntity elementCategoryUpdateEntity) {
        elementCategoryDao.save(elementCategoryUpdateEntity);
        return elementCategoryDao.queryObject(elementCategoryUpdateEntity.getId());
    }

    @Override
    public void update(ElementCategoryUpdateEntity elementCategoryUpdateEntity) {
        elementCategoryDao.update(elementCategoryUpdateEntity);
    }

    @Override
    public void delete(String id) {
        elementCategoryDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        elementCategoryDao.deleteBatch(ids);
    }
}
