package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.UserElementEntity;
import net.kuper.tz.system.entity.UserElementQueryEntity;
import net.kuper.tz.system.entity.UserElementUpdateEntity;
import net.kuper.tz.system.service.UserElementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 用户菜单功能
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Api(value = "用户菜单功能", description = "用户菜单功能")
@RestController
@RequestMapping("system/userelement")
public class UserElementController {

    @Autowired
    private UserElementService userElementService;

    /**
     * 分页查询：用户菜单功能
     *
     * @param userElementQueryEntity
     */
    @Log(type = LogType.QUERY,value = "查询用户菜单功能列表" )
    @ApiOperation("查询用户菜单功能列表")
    @RequiresPermissions("system:userelement:list" )
    @ResponseBody
    @GetMapping
    public Res<List<UserElementEntity>> list(UserElementQueryEntity userElementQueryEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(userElementQueryEntity);
        List<UserElementEntity> list = userElementService.queryList(userElementQueryEntity, userId);
        return Res.ok(list);
    }

    /**
     * 修改用户菜单功能
     *
     * @param userElementUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改用户菜单功能")
    @ApiOperation("修改用户菜单功能")
    @RequiresPermissions("system:userelement:update" )
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody List<UserElementUpdateEntity> userElementUpdateEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(userElementUpdateEntity, UpdateGroup.class);
        userElementService.update(userElementUpdateEntity, userId);
        return Res.ok();
    }

}