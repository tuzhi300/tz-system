package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.RoleEntity;
import net.kuper.tz.system.entity.RoleQueryEntity;
import net.kuper.tz.system.entity.RoleUpdateEntity;
import net.kuper.tz.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 角色
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Api(value = "角色" , description = "角色" )
@RestController
@RequestMapping("system/role" )
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 分页查询：角色
     * @param roleQueryEntity
     */
    @Log(type = LogType.QUERY,value = "分页查询角色" )
    @ApiOperation("分页查询角色" )
    @RequiresPermissions("system:role:list" )
    @ResponseBody
    @GetMapping
    public Res<Pagination<RoleEntity>> list(RoleQueryEntity roleQueryEntity) {
        ValidatorUtils.validateEntity(roleQueryEntity);
        Pagination pagination = roleService.queryList(roleQueryEntity);
        return Res.ok(pagination);
    }

    @Log(type = LogType.OPERATOR,value = "按部门查询" )
    @ApiOperation("按部门查询" )
//    @RequiresPermissions("system:role:list" )
    @ResponseBody
    @GetMapping("/dept/{deptId}")
    public Res<List<RoleEntity>> list(@PathVariable("deptId") String deptId) {
        List list = roleService.queryListByDept(deptId);
        return Res.ok(list);
    }


    /**
     * 角色详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY,value = "角色详情查询" )
    @ApiOperation("角色详情查询" )
    @RequiresPermissions("system:role:detail" )
    @ResponseBody
    @GetMapping(value = "/{id}" )
    public Res<RoleEntity> detail(@PathVariable("id") String id) {
        RoleEntity  role = roleService.queryObject(id);
        return Res.ok(role);
    }

    /**
     * 添加角色
     *
     * @param roleUpdateEntity
     */
    @Log(type = LogType.SAVE,value = "添加角色" )
    @ApiOperation("添加角色" )
    @RequiresPermissions("system:role:add" )
    @ResponseBody
    @PostMapping
    public Res<RoleEntity> save(@RequestBody RoleUpdateEntity roleUpdateEntity) {
        ValidatorUtils.validateEntity(roleUpdateEntity, AddGroup.class);
        RoleEntity roleEntity =roleService.save(roleUpdateEntity);
        return Res.ok(roleEntity);
    }

    /**
     * 修改角色
     * @param roleUpdateEntity
     */
    @Log(type = LogType.UPDATE,value = "修改角色" )
    @ApiOperation("修改角色" )
    @RequiresPermissions("system:role:update" )
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody RoleUpdateEntity roleUpdateEntity) {
        ValidatorUtils.validateEntity(roleUpdateEntity, UpdateGroup.class);
        roleService.update(roleUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除角色
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除角色" )
    @ApiOperation("删除角色" )
    @RequiresPermissions("system:role:delete" )
    @ResponseBody
    @DeleteMapping(value = "/{id}" )
    public Res delete(@PathVariable("id") String id) {
        roleService.delete(id);
        return Res.ok();
    }

}