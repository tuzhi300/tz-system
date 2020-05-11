package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.UserMenuEntity;
import net.kuper.tz.system.entity.UserMenuQueryEntity;
import net.kuper.tz.system.entity.UserMenuUpdateEntity;
import net.kuper.tz.system.service.UserMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Api(value = "用户菜单授管理", description = "")
@RestController
@RequestMapping("system/usermenu")
public class UserMenuController {

    @Autowired
    private UserMenuService userMenuService;

    /**
     * 分页查询：
     *
     * @param userMenuQueryEntity
     */
    @Log(type = LogType.QUERY,value = "查询用户菜单列表" )
    @ApiOperation("查询用户菜单列表")
    @RequiresPermissions("system:usermenu:list")
    @ResponseBody
    @GetMapping
    public Res<List<UserMenuEntity>> list(UserMenuQueryEntity userMenuQueryEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(userMenuQueryEntity);
        List list = userMenuService.queryList(userMenuQueryEntity, userId);
        return Res.ok(list);
    }

    /**
     * 修改
     *
     * @param userMenuUpdateEntities
     * @param userId
     */
    @Log(type = LogType.UPDATE, value = "修改用户菜单")
    @ApiOperation("修改用户菜单")
    @RequiresPermissions("system:usermenu:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody List<UserMenuUpdateEntity> userMenuUpdateEntities, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(userMenuUpdateEntities, UpdateGroup.class);
        userMenuService.update(userMenuUpdateEntities, userId);
        return Res.ok();
    }

}