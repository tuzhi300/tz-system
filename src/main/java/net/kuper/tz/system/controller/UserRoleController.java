package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.system.entity.UserRoleEntity;
import net.kuper.tz.system.entity.UserRoleQueryEntity;
import net.kuper.tz.system.entity.UserRoleUpdateEntity;
import net.kuper.tz.system.service.UserRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 用户角色
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:13
 */
@Api(value = "用户角色", description = "用户角色")
@RestController
@RequestMapping("system/userrole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 分页查询：用户角色
     *
     * @param userRoleQueryEntity
     * @param userId
     */
    @Log(type = LogType.QUERY, value = "查询用户角色列表")
    @ApiOperation("分页查询用户角色")
//    @RequiresPermissions("system:userrole:list")
    @ResponseBody
    @GetMapping
    public Res<List<UserRoleEntity>> list(UserRoleQueryEntity userRoleQueryEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(userRoleQueryEntity);
        List list = userRoleService.queryList(userRoleQueryEntity, userId);
        return Res.ok(list);
    }

    /**
     * 查看自己的角色
     *
     * @param userId
     */
    @Log(type = LogType.QUERY, value = "查询用户角色列表")
    @ApiOperation("分页查询用户角色")
    @ResponseBody
    @GetMapping("/self")
    public Res<List<UserRoleEntity>> listBySelf(@ApiIgnore @UserId String userId) {
        UserRoleQueryEntity userRoleQueryEntity = new UserRoleQueryEntity();
        userRoleQueryEntity.setUserId(userId);
        List list = userRoleService.queryList(userRoleQueryEntity, userId);
        return Res.ok(list);
    }

    /**
     * 添加用户角色
     *
     * @param userRoleUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加用户角色")
    @ApiOperation("添加用户角色")
//    @RequiresPermissions("system:userrole:add" )
    @ResponseBody
    @PostMapping
    public Res<UserRoleEntity> save(@RequestBody UserRoleUpdateEntity userRoleUpdateEntity) {
        ValidatorUtils.validateEntity(userRoleUpdateEntity, AddGroup.class);
        UserRoleEntity userRoleEntity = userRoleService.save(userRoleUpdateEntity);
        return Res.ok(userRoleEntity);
    }


    /**
     * 删除用户角色
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除用户角色")
    @ApiOperation("删除用户角色")
    @RequiresPermissions("system:userrole:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id, @ApiIgnore @UserId String userId) {
        userRoleService.delete(id, userId);
        return Res.ok();
    }


}