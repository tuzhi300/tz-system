package net.kuper.tz.system.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.dao.ElementDao;
import net.kuper.tz.system.entity.ElementEntity;
import net.kuper.tz.system.entity.ElementQueryEntity;
import net.kuper.tz.system.entity.ElementUpdateEntity;
import net.kuper.tz.system.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 页面元素（功能按钮）Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-06 17:07:58
 */
@Service("elementService")
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementDao elementDao;

    @Override
    public Pagination<ElementEntity> queryList(ElementQueryEntity elementQueryEntity) {
        PageHelper.startPage(elementQueryEntity.getPage(), elementQueryEntity.getPageSize());
        List<ElementEntity> elementList = elementDao.queryList(elementQueryEntity);
        return new Pagination<ElementEntity>(elementList);
    }

    @Override
    public ElementEntity queryObject(String id) {
        return elementDao.queryObject(id);
    }

    @Override
    public List<String> queryCodeListByUser(String userId) {
        return elementDao.queryCodeListByUser(userId);
    }

    @Override
    public ElementEntity save(ElementUpdateEntity elementUpdateEntity) {
        elementDao.save(elementUpdateEntity);
        return elementDao.queryObject(elementUpdateEntity.getId());
    }

    @Override
    public void update(ElementUpdateEntity elementUpdateEntity) {
        elementDao.update(elementUpdateEntity);
    }

    @Override
    public void delete(String id) {
        elementDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        elementDao.deleteBatch(ids);
    }
}
