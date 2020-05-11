package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.UserDataEntity;
import net.kuper.tz.system.entity.UserDataQueryEntity;
import net.kuper.tz.system.entity.UserDataUpdateEntity;
import net.kuper.tz.system.service.UserDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 用户数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Api(value = "用户数据权限", description = "用户数据权限")
@RestController
@RequestMapping("system/userdata")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    /**
     * 分页查询：用户数据权限
     *
     * @param userDataQueryEntity
     */
    @Log(type = LogType.QUERY,value = "查询用户数据权限列表" )
    @ApiOperation("查询用户数据权限列表")
    @RequiresPermissions("system:userdata:list")
    @ResponseBody
    @GetMapping
    public Res<List<UserDataEntity>> list(UserDataQueryEntity userDataQueryEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(userDataQueryEntity);
        List<UserDataEntity> list = userDataService.queryList(userDataQueryEntity, userId);
        return Res.ok(list);
    }

    /**
     * 修改用户数据权限
     *
     * @param userDataUpdateEntities
     */
    @Log(type = LogType.UPDATE, value = "修改用户数据权限")
    @ApiOperation("修改用户数据权限")
    @RequiresPermissions("system:userdata:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody List<UserDataUpdateEntity> userDataUpdateEntities, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(userDataUpdateEntities, UpdateGroup.class);
        userDataService.update(userDataUpdateEntities,userId);
        return Res.ok();
    }

}