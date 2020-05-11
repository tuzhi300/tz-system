package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.RoleDataEntity;
import net.kuper.tz.system.entity.RoleDataQueryEntity;
import net.kuper.tz.system.entity.RoleDataUpdateEntity;
import net.kuper.tz.system.service.RoleDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 角色数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Api(value = "角色数据权限", description = "角色数据权限")
@RestController
@RequestMapping("system/roledata")
public class RoleDataController {

    @Autowired
    private RoleDataService roleDataService;

    /**
     * 分页查询：角色数据权限
     *
     * @param roleDataQueryEntity
     */
    @Log(type = LogType.QUERY,value = "查询角色数据权限列表" )
    @ApiOperation("查询角色数据权限列表")
    @RequiresPermissions("system:roledata:list" )
    @ResponseBody
    @GetMapping
    public Res<List<RoleDataEntity>> list(RoleDataQueryEntity roleDataQueryEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(roleDataQueryEntity);
        List<RoleDataEntity> list = roleDataService.queryList(roleDataQueryEntity, userId);
        return Res.ok(list);
    }

    /**
     * 修改角色数据权限
     *
     * @param roleDataUpdateEntityList
     */
    @Log(type = LogType.UPDATE, value = "修改角色数据权限")
    @ApiOperation("修改角色数据权限")
    @RequiresPermissions("system:roledata:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody List<RoleDataUpdateEntity> roleDataUpdateEntityList, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(roleDataUpdateEntityList, UpdateGroup.class);
        roleDataService.update(roleDataUpdateEntityList, userId);
        return Res.ok();
    }
}