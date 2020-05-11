package net.kuper.tz.system.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.dao.OperationDao;
import net.kuper.tz.system.entity.OperationEntity;
import net.kuper.tz.system.entity.OperationQueryEntity;
import net.kuper.tz.system.entity.OperationUpdateEntity;
import net.kuper.tz.system.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作（接口）Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Service("operationService")
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationDao operationDao;

    @Override
    public Pagination<OperationEntity> queryList(OperationQueryEntity operationQueryEntity) {
        PageHelper.startPage(operationQueryEntity.getPage(), operationQueryEntity.getPageSize());
        List<OperationEntity> operationList = operationDao.queryList(operationQueryEntity);
        return new Pagination<OperationEntity>(operationList);
    }

    @Override
    public List<OperationEntity> queryListByController(String controllerId) {
        OperationQueryEntity operationQueryEntity = new OperationQueryEntity();
        operationQueryEntity.setControllerId(controllerId);
        List<OperationEntity> operationList = operationDao.queryList(operationQueryEntity);
        return operationList;
    }

    @Override
    public OperationEntity queryObject(String id) {
        return operationDao.queryObject(id);
    }

    @Override
    public List<String> queryUserOperationCodeList(String userId) {
        return operationDao.queryUserOperationCodeList(userId);
    }

    @Override
    public OperationEntity save(OperationUpdateEntity operationUpdateEntity) {
        operationDao.save(operationUpdateEntity);
        return operationDao.queryObject(operationUpdateEntity.getId());
    }

    @Override
    public void update(OperationUpdateEntity operationUpdateEntity) {
        operationDao.update(operationUpdateEntity);
    }

    @Override
    public void delete(String id) {
        operationDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        operationDao.deleteBatch(ids);
    }
}
