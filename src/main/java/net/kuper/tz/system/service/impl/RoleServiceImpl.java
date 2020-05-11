package net.kuper.tz.system.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.dao.RoleDao;
import net.kuper.tz.system.entity.RoleEntity;
import net.kuper.tz.system.entity.RoleQueryEntity;
import net.kuper.tz.system.entity.RoleUpdateEntity;
import net.kuper.tz.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Pagination<RoleEntity> queryList(RoleQueryEntity roleQueryEntity) {
        PageHelper.startPage(roleQueryEntity.getPage(), roleQueryEntity.getPageSize());
        List<RoleEntity> roleList = roleDao.queryList(roleQueryEntity);
        return new Pagination<RoleEntity>(roleList);
    }

    @Override
    public List<RoleEntity> queryListByDept(String deptId) {
        RoleQueryEntity roleQueryEntity = new RoleQueryEntity();
        roleQueryEntity.setDeptId(deptId);
        return roleDao.queryList(roleQueryEntity);
    }

    @Override
    public RoleEntity queryObject(String id) {
        return roleDao.queryObject(id);
    }

    @Override
    public RoleEntity save(RoleUpdateEntity roleUpdateEntity) {
        roleDao.save(roleUpdateEntity);
        return roleDao.queryObject(roleUpdateEntity.getId());
    }

    @Override
    public void update(RoleUpdateEntity roleUpdateEntity) {
        roleDao.update(roleUpdateEntity);
    }

    @Override
    public void delete(String id) {
        roleDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        roleDao.deleteBatch(ids);
    }
}
