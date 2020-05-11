package net.kuper.tz.system.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.dao.LoginLogDao;
import net.kuper.tz.system.entity.LoginLogEntity;
import net.kuper.tz.system.entity.LoginLogQueryEntity;
import net.kuper.tz.system.entity.LoginLogUpdateEntity;
import net.kuper.tz.system.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登录历史Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:33:53
 */
@Service("loginLogService" )
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public Pagination<LoginLogEntity> queryList(LoginLogQueryEntity loginLogQueryEntity) {
        PageHelper.startPage(loginLogQueryEntity.getPage(), loginLogQueryEntity.getPageSize());
        List<LoginLogEntity> loginLogList = loginLogDao.queryList(loginLogQueryEntity);
        return new Pagination<LoginLogEntity>(loginLogList);
    }

    @Override
    public LoginLogEntity queryObject(String id) {
        return loginLogDao.queryObject(id);
    }

    @Override
    public LoginLogEntity save(LoginLogUpdateEntity loginLogUpdateEntity) {
        loginLogDao.save(loginLogUpdateEntity);
        return loginLogDao.queryObject(loginLogUpdateEntity.getId());
    }

    @Override
    public void update(LoginLogUpdateEntity loginLogUpdateEntity) {
        loginLogDao.update(loginLogUpdateEntity);
    }

    @Override
    public void delete(String id) {
        loginLogDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        loginLogDao.deleteBatch(ids);
    }
}
