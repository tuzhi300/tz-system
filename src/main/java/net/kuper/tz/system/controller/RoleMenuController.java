package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.RoleMenuEntity;
import net.kuper.tz.system.entity.RoleMenuQueryEntity;
import net.kuper.tz.system.entity.RoleMenuUpdateEntity;
import net.kuper.tz.system.service.RoleMenuService;
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
@Api(value = "", description = "")
@RestController
@RequestMapping("system/rolemenu")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 分页查询：
     *
     * @param roleMenuQueryEntity
     */
    @Log(type = LogType.QUERY,value = "查询角色菜单列表" )
    @ApiOperation("查询角色菜单列表")
    @RequiresPermissions("system:rolemenu:list")
    @ResponseBody
    @GetMapping
    public Res<List<RoleMenuEntity>> list(RoleMenuQueryEntity roleMenuQueryEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(roleMenuQueryEntity);
        List<RoleMenuEntity> pagination = roleMenuService.queryList(roleMenuQueryEntity, userId);
        return Res.ok(pagination);
    }


    /**
     * 修改
     *
     * @param roleMenuUpdateEntities
     */
    @Log(type = LogType.UPDATE, value = "修改角色菜单")
    @ApiOperation("修改角色菜单")
    @RequiresPermissions("system:rolemenu:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody List<RoleMenuUpdateEntity> roleMenuUpdateEntities, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(roleMenuUpdateEntities, UpdateGroup.class);
        roleMenuService.update(roleMenuUpdateEntities, userId);
        return Res.ok();
    }

}