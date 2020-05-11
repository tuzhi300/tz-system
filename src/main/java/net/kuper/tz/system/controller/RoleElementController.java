package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.RoleElementEntity;
import net.kuper.tz.system.entity.RoleElementQueryEntity;
import net.kuper.tz.system.entity.RoleElementUpdateEntity;
import net.kuper.tz.system.service.RoleElementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 角色菜单元素
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@Api(value = "角色菜单元素", description = "角色菜单元素")
@RestController
@RequestMapping("system/roleelement")
public class RoleElementController {

    @Autowired
    private RoleElementService roleElementService;

    /**
     * 分页查询：角色菜单元素
     *
     * @param roleElementQueryEntity
     */
    @Log(type = LogType.QUERY,value = "查询角色页面元素权限" )
    @ApiOperation("查询角色页面元素权限")
    @RequiresPermissions("system:roleelement:list")
    @ResponseBody
    @GetMapping
    public Res<List<RoleElementEntity>> list(RoleElementQueryEntity roleElementQueryEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(roleElementQueryEntity);
        List<RoleElementEntity> list = roleElementService.queryList(roleElementQueryEntity, userId);
        return Res.ok(list);
    }


    /**
     * 修改角色菜单元素
     *
     * @param roleElementUpdateEntities
     */
    @Log(type = LogType.UPDATE, value = "修改角色页面元素")
    @ApiOperation("修改角色页面元素")
    @RequiresPermissions("system:roleelement:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody List<RoleElementUpdateEntity> roleElementUpdateEntities, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(roleElementUpdateEntities, UpdateGroup.class);
        roleElementService.update(roleElementUpdateEntities,userId);
        return Res.ok();
    }

}