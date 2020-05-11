package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.UserEntity;
import net.kuper.tz.system.entity.UserQueryEntity;
import net.kuper.tz.system.entity.UserUpdateEntity;
import net.kuper.tz.system.params.UpdateUserSelfEntity;
import net.kuper.tz.system.params.UserUpdatePwdEntity;
import net.kuper.tz.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 管理员
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Api(value = "管理员", description = "管理员")
@RestController
@RequestMapping("system/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询：管理员
     *
     * @param userQueryEntity
     */
    @Log(type = LogType.QUERY, value = "分页查询管理员")
    @ApiOperation("分页查询管理员")
    @RequiresPermissions("system:user:list")
    @ResponseBody
    @GetMapping
    public Res<Pagination<UserEntity>> list(UserQueryEntity userQueryEntity) {
        ValidatorUtils.validateEntity(userQueryEntity);
        Pagination pagination = userService.queryList(userQueryEntity);
        return Res.ok(pagination);
    }


    /**
     * 用户详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY, value = "用户详情查询")
    @ApiOperation("用户详情查询")
    @RequiresPermissions("system:user:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<UserEntity> detail(@PathVariable("id") String id) {
        UserEntity user = userService.queryObject(id);
        return Res.ok(user);
    }

    /**
     * 添加用户
     *
     * @param userUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加管理员")
    @ApiOperation("添加管理员")
    @RequiresPermissions("system:user:add")
    @ResponseBody
    @PostMapping
    public Res<UserEntity> save(@RequestBody UserUpdateEntity userUpdateEntity) {
        ValidatorUtils.validateEntity(userUpdateEntity, AddGroup.class);
        UserEntity userEntity = userService.save(userUpdateEntity);
        return Res.ok(userEntity);
    }

    /**
     * 修改用户
     *
     * @param userUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改管理员")
    @ApiOperation("修改管理员")
    @RequiresPermissions("system:user:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody UserUpdateEntity userUpdateEntity) {
        ValidatorUtils.validateEntity(userUpdateEntity, UpdateGroup.class);
        userService.update(userUpdateEntity);
        return Res.ok();
    }

    /**
     * 修改个人信息
     *
     * @param userUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改个人信息")
    @ApiOperation("修改个人信息")
    @ResponseBody
    @PutMapping("/update-self")
    public Res updateSelf(@RequestBody UpdateUserSelfEntity userUpdateEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(userUpdateEntity, UpdateGroup.class);
        UserUpdateEntity updateEntity = new UserUpdateEntity();
        updateEntity.setId(userId);
        updateEntity.setEmail(userUpdateEntity.getEmail());
        updateEntity.setMobile(userUpdateEntity.getMobile());
        userService.update(updateEntity);
        return Res.ok();
    }

    /**
     * 修改个人密码
     *
     * @param userUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改个人密码")
    @ApiOperation("修改个人密码")
    @ResponseBody
    @PutMapping("/update-pwd")
    public Res updatePwd(@RequestBody UserUpdatePwdEntity userUpdateEntity, @ApiIgnore @UserId String userId) {
        userUpdateEntity.setId(userId);
        ValidatorUtils.validateEntity(userUpdateEntity, UpdateGroup.class);
        userService.updatePwd(userUpdateEntity);
        return Res.ok();
    }

    /**
     * 重置密码
     *
     * @param userId
     */
    @Log(type = LogType.UPDATE, value = "重置密码")
    @ApiOperation("重置密码")
    @RequiresPermissions("system:user:reset-pwd")
    @ResponseBody
    @PutMapping("/reset-pwd-{userId}")
    public Res updatePwd(@PathVariable("userId") String userId) {
        userService.resetPwd(userId);
        return Res.ok();
    }


    /**
     * 删除管理员
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除管理员")
    @ApiOperation("删除管理员")
    @RequiresPermissions("system:user:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id) {
        userService.delete(id);
        return Res.ok();
    }

}