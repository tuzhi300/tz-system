package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.common.entity.MacroEntity;
import net.kuper.tz.common.entity.MacroQueryEntity;
import net.kuper.tz.common.service.MacroService;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.ControllerEntity;
import net.kuper.tz.system.entity.ControllerQueryEntity;
import net.kuper.tz.system.entity.ControllerUpdateEntity;
import net.kuper.tz.system.service.ControllerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 控制器（接口操作分类）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Api(value = "控制器（接口操作分类）", description = "控制器（接口操作分类）")
@RestController
@RequestMapping("system/controller")
public class ControllerController {

    @Autowired
    private ControllerService controllerService;
    @Autowired
    private MacroService macroService;


    @Log(type = LogType.QUERY, value = "查询所有模块")
    @ApiOperation("查询所有模块")
//    @RequiresPermissions("system:controller:module:list")
    @ResponseBody
    @GetMapping("/module")
    public Res<List<MacroEntity>> moduleList() {
        MacroQueryEntity queryEntity = new MacroQueryEntity();
        queryEntity.setParentKey("fun_module");
        queryEntity.setStatus(1);
        List<MacroEntity> list = macroService.queryAllList(queryEntity);
        return Res.ok(list);
    }

    /**
     * 分页查询：控制器（接口操作分类）
     *
     * @param controllerQueryEntity
     */
    @Log(type = LogType.QUERY, value = "分页查询控制器")
    @ApiOperation("分页查询控制器（接口操作分类）")
    @RequiresPermissions("system:controller:list")
    @ResponseBody
    @GetMapping
    public Res<Pagination<ControllerEntity>> list(ControllerQueryEntity controllerQueryEntity) {
        ValidatorUtils.validateEntity(controllerQueryEntity);
        Pagination pagination = controllerService.queryList(controllerQueryEntity);
        return Res.ok(pagination);
    }


    @Log(type = LogType.QUERY, value = "按模块查询控制器")
    @ApiOperation("按模块查询控制器")
    @RequiresPermissions("system:controller:list:by-module")
    @ResponseBody
    @GetMapping("/module-{module}")
    public Res<List<ControllerEntity>> list(@PathVariable("module") String module) {
        List<ControllerEntity> list = controllerService.queryList(module);
        return Res.ok(list);
    }

    /**
     * 控制器（接口操作分类）详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY, value = "查询控制器详情")
    @ApiOperation("控制器（接口操作分类）详情查询")
    @RequiresPermissions("system:controller:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<ControllerEntity> detail(@PathVariable("id") String id) {
        ControllerEntity controller = controllerService.queryObject(id);
        return Res.ok(controller);
    }

    /**
     * 添加控制器（接口操作分类）
     *
     * @param controllerUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加控制器（接口操作分类）")
    @ApiOperation("添加控制器（接口操作分类）")
    @RequiresPermissions("system:controller:add")
    @ResponseBody
    @PostMapping
    public Res<ControllerEntity> save(@RequestBody ControllerUpdateEntity controllerUpdateEntity) {
        ValidatorUtils.validateEntity(controllerUpdateEntity, AddGroup.class);
        ControllerEntity controllerEntity = controllerService.save(controllerUpdateEntity);
        return Res.ok(controllerEntity);
    }

    /**
     * 修改控制器（接口操作分类）
     *
     * @param controllerUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改控制器（接口操作分类）")
    @ApiOperation("修改控制器（接口操作分类）")
    @RequiresPermissions("system:controller:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody ControllerUpdateEntity controllerUpdateEntity) {
        ValidatorUtils.validateEntity(controllerUpdateEntity, UpdateGroup.class);
        controllerService.update(controllerUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除控制器（接口操作分类）
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除控制器（接口操作分类）")
    @ApiOperation("删除控制器（接口操作分类）")
    @RequiresPermissions("system:controller:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id) {
        controllerService.delete(id);
        return Res.ok();
    }

}