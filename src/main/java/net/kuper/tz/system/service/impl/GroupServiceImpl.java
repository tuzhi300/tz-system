package net.kuper.tz.system.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.dao.GroupDao;
import net.kuper.tz.system.entity.GroupEntity;
import net.kuper.tz.system.entity.GroupQueryEntity;
import net.kuper.tz.system.entity.GroupUpdateEntity;
import net.kuper.tz.system.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Service("groupService" )
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public Pagination<GroupEntity> queryList(GroupQueryEntity groupQueryEntity) {
        PageHelper.startPage(groupQueryEntity.getPage(), groupQueryEntity.getPageSize());
        List<GroupEntity> groupList = groupDao.queryList(groupQueryEntity);
        return new Pagination<GroupEntity>(groupList);
    }

    @Override
    public GroupEntity queryObject(String id) {
        return groupDao.queryObject(id);
    }

    @Override
    public GroupEntity save(GroupUpdateEntity groupUpdateEntity) {
        groupDao.save(groupUpdateEntity);
        return groupDao.queryObject(groupUpdateEntity.getId());
    }

    @Override
    public void update(GroupUpdateEntity groupUpdateEntity) {
        groupDao.update(groupUpdateEntity);
    }

    @Override
    public void delete(String id) {
        groupDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        groupDao.deleteBatch(ids);
    }
}
