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
import net.kuper.tz.system.entity.GroupEntity;
import net.kuper.tz.system.entity.GroupQueryEntity;
import net.kuper.tz.system.entity.GroupUpdateEntity;
import net.kuper.tz.system.service.GroupService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Api(value = "管理员分组")
@RestController
@RequestMapping("system/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    /**
     * 分页查询：管理员分组
     *
     * @param groupQueryEntity
     */
    @Log(type = LogType.QUERY, value = "分页查询管理员分组")
    @ApiOperation("分页查询管理员分组")
    @RequiresPermissions("system:group:list")
    @ResponseBody
    @GetMapping
    public Res<Pagination<GroupEntity>> list(GroupQueryEntity groupQueryEntity) {
        ValidatorUtils.validateEntity(groupQueryEntity);
        Pagination pagination = groupService.queryList(groupQueryEntity);
        return Res.ok(pagination);
    }


    /**
     * 管理员分组详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY, value = "管理员分组详情查询")
    @ApiOperation("管理员分组详情查询")
    @RequiresPermissions("system:group:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<GroupEntity> detail(@PathVariable("id") String id) {
        GroupEntity group = groupService.queryObject(id);
        return Res.ok(group);
    }

    /**
     * 添加管理员分组
     *
     * @param groupUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加管理员分组")
    @ApiOperation("添加管理员分组")
    @RequiresPermissions("system:group:add")
    @ResponseBody
    @PostMapping
    public Res<GroupEntity> save(@RequestBody GroupUpdateEntity groupUpdateEntity) {
        ValidatorUtils.validateEntity(groupUpdateEntity, AddGroup.class);
        GroupEntity groupEntity = groupService.save(groupUpdateEntity);
        return Res.ok(groupEntity);
    }

    /**
     * 修改管理员分组
     *
     * @param groupUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改管理员分组")
    @ApiOperation("修改管理员分组")
    @RequiresPermissions("system:group:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody GroupUpdateEntity groupUpdateEntity) {
        ValidatorUtils.validateEntity(groupUpdateEntity, UpdateGroup.class);
        groupService.update(groupUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除管理员分组
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除管理员分组")
    @ApiOperation("删除管理员分组")
    @RequiresPermissions("system:group:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id) {
        groupService.delete(id);
        return Res.ok();
    }

}