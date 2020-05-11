package net.kuper.tz.system.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.core.constant.Time;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.system.dao.UserTokenDao;
import net.kuper.tz.system.entity.UserTokenEntity;
import net.kuper.tz.system.entity.UserTokenQueryEntity;
import net.kuper.tz.system.entity.UserTokenUpdateEntity;
import net.kuper.tz.system.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 系统用户TokenService实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2019-04-22 00:40:03
 */
@Service("userTokenService")
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    private UserTokenDao userTokenDao;

    @Override
    public Pagination<UserTokenEntity> queryList(UserTokenQueryEntity userTokenQueryEntity) {
        PageHelper.startPage(userTokenQueryEntity.getPage(), userTokenQueryEntity.getPageSize());
        List<UserTokenEntity> list = userTokenDao.queryList(userTokenQueryEntity);
        return new Pagination<UserTokenEntity>(list);
    }

    @Override
    public UserTokenEntity queryObject(String userId) {
        return userTokenDao.queryObject(userId);
    }

    @Override
    public UserTokenEntity save(UserTokenUpdateEntity userTokenAddEntity) {
        userTokenDao.save(userTokenAddEntity);
        return userTokenDao.queryObject(userTokenAddEntity.getUserId());
    }

    @Override
    public void update(UserTokenUpdateEntity userTokenAddEntity) {
        userTokenDao.update(userTokenAddEntity);
    }

    @Override
    public void delete(String userId) {
        userTokenDao.delete(userId);
    }

    @Override
    public void deleteBatch(String[] userIds) {
        userTokenDao.deleteBatch(userIds);
    }

    @Override
    public UserTokenEntity queryObjectByToken(String token) {
        return userTokenDao.queryObjectByToken(token);
    }


    @Override
    public UserTokenEntity createTokenByUser(String userId) {
        int expire = 7 * Time.DAY;
        String token = UUID.randomUUID().toString();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MILLISECOND, expire);
        //
        UserTokenUpdateEntity userToken = new UserTokenUpdateEntity();
        userToken.setUserId(userId);
        userToken.setToken(token);
        userToken.setExpireTime(calendar.getTime());
        userToken.setUpdateTime(new Date());
        userTokenDao.save(userToken);

        UserTokenEntity entity = new UserTokenEntity();
        entity.setToken(userToken.getToken());
        entity.setExpireTime(userToken.getExpireTime());
        entity.setUserId(userToken.getUserId());
        entity.setUpdateTime(userToken.getUpdateTime());
        return entity;
    }

}
