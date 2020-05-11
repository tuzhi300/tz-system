package net.kuper.tz.system.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.dao.ControllerDao;
import net.kuper.tz.system.entity.ControllerEntity;
import net.kuper.tz.system.entity.ControllerQueryEntity;
import net.kuper.tz.system.entity.ControllerUpdateEntity;
import net.kuper.tz.system.service.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 控制器（接口操作分类）Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Service("controllerService")
public class ControllerServiceImpl implements ControllerService {

    @Autowired
    private ControllerDao controllerDao;

    @Override
    public Pagination<ControllerEntity> queryList(ControllerQueryEntity controllerQueryEntity) {
        PageHelper.startPage(controllerQueryEntity.getPage(), controllerQueryEntity.getPageSize());
        List<ControllerEntity> controllerList = controllerDao.queryList(controllerQueryEntity);
        return new Pagination<ControllerEntity>(controllerList);
    }

    @Override
    public List<ControllerEntity> queryList(String module) {
        ControllerQueryEntity queryEntity = new ControllerQueryEntity();
        queryEntity.setModule(module);
        return controllerDao.queryList(queryEntity);
    }

    @Override
    public ControllerEntity queryObject(String id) {
        return controllerDao.queryObject(id);
    }

    @Override
    public ControllerEntity save(ControllerUpdateEntity controllerUpdateEntity) {
        controllerDao.save(controllerUpdateEntity);
        return controllerDao.queryObject(controllerUpdateEntity.getId());
    }

    @Override
    public void update(ControllerUpdateEntity controllerUpdateEntity) {
        controllerDao.update(controllerUpdateEntity);
    }

    @Override
    public void delete(String id) {
        controllerDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        controllerDao.deleteBatch(ids);
    }
}
