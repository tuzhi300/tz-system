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
import net.kuper.tz.system.entity.OperationEntity;
import net.kuper.tz.system.entity.OperationQueryEntity;
import net.kuper.tz.system.entity.OperationUpdateEntity;
import net.kuper.tz.system.service.OperationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 操作（接口）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Api(value = "操作（接口）", description = "操作（接口）")
@RestController
@RequestMapping("system/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    /**
     * 分页查询：操作（接口）
     *
     * @param operationQueryEntity
     */
    @Log(type = LogType.QUERY,value = "分页查询操作（接口）" )
    @ApiOperation("分页查询操作（接口）")
    @RequiresPermissions("system:operation:list")
    @ResponseBody
    @GetMapping
    public Res<Pagination<OperationEntity>> list(OperationQueryEntity operationQueryEntity) {
        ValidatorUtils.validateEntity(operationQueryEntity);
        Pagination pagination = operationService.queryList(operationQueryEntity);
        return Res.ok(pagination);
    }

    @Log(type = LogType.QUERY,value = "按控制器查询操作（接口）" )
    @ApiOperation("按控制器查询操作（接口）")
    @RequiresPermissions("system:operation:list:by-controller")
    @ResponseBody
    @GetMapping("/controller/{controllerId}")
    public Res<List<OperationEntity>> list(@PathVariable("controllerId") String controllerId) {
        List<OperationEntity> list = operationService.queryListByController(controllerId);
        return Res.ok(list);
    }

    /**
     * 操作（接口）详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY,value = "操作（接口）详情查询" )
    @ApiOperation("操作（接口）详情查询")
    @RequiresPermissions("system:operation:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<OperationEntity> detail(@PathVariable("id") String id) {
        OperationEntity operation = operationService.queryObject(id);
        return Res.ok(operation);
    }

    /**
     * 添加操作（接口）
     *
     * @param operationUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加操作（接口）")
    @ApiOperation("添加操作（接口）")
    @RequiresPermissions("system:operation:add")
    @ResponseBody
    @PostMapping
    public Res<OperationEntity> save(@RequestBody OperationUpdateEntity operationUpdateEntity) {
        ValidatorUtils.validateEntity(operationUpdateEntity, AddGroup.class);
        OperationEntity operationEntity = operationService.save(operationUpdateEntity);
        return Res.ok(operationEntity);
    }

    /**
     * 修改操作（接口）
     *
     * @param operationUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改操作（接口）")
    @ApiOperation("修改操作（接口）")
    @RequiresPermissions("system:operation:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody OperationUpdateEntity operationUpdateEntity) {
        ValidatorUtils.validateEntity(operationUpdateEntity, UpdateGroup.class);
        operationService.update(operationUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除操作（接口）
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除操作（接口）")
    @ApiOperation("删除操作（接口）")
    @RequiresPermissions("system:operation:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id) {
        operationService.delete(id);
        return Res.ok();
    }

}