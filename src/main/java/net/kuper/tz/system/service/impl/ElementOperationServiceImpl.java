package net.kuper.tz.system.service.impl;

import net.kuper.tz.system.dao.ElementOperationDao;
import net.kuper.tz.system.entity.ElementOperationEntity;
import net.kuper.tz.system.entity.ElementOperationQueryEntity;
import net.kuper.tz.system.entity.ElementOperationUpdateEntity;
import net.kuper.tz.system.service.ElementOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 11:02:55
 */
@Service("elementOperationService")
public class ElementOperationServiceImpl implements ElementOperationService {

    @Autowired
    private ElementOperationDao elementOperationDao;

    @Override
    public List<ElementOperationEntity> queryList(ElementOperationQueryEntity elementOperationQueryEntity, String userId) {
        List<ElementOperationEntity> elementOperationList = elementOperationDao.queryListByElement(elementOperationQueryEntity.getElementId(),userId);
        return elementOperationList;
    }

    @Override
    public ElementOperationEntity save(ElementOperationUpdateEntity elementOperationUpdateEntity) {
        elementOperationDao.save(elementOperationUpdateEntity);
        return elementOperationDao.queryObject(elementOperationUpdateEntity.getId());
    }

    @Override
    public void delete(String id, String userId) {
        elementOperationDao.delete(id);
    }

}
