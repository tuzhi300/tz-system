package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.DeptEntity;
import net.kuper.tz.system.entity.DeptQueryEntity;
import net.kuper.tz.system.entity.DeptUpdateEntity;
import net.kuper.tz.system.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 部门
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Api(value = "部门", description = "部门")
@RestController
@RequestMapping("system/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 分页查询：部门
     *
     * @param deptQueryEntity
     */
    @Log(type = LogType.QUERY, value = "分页查询部门")
    @ApiOperation("分页查询部门")
    @RequiresPermissions("system:dept:list")
    @ResponseBody
    @GetMapping
    public Res<List<DeptEntity>> list(DeptQueryEntity deptQueryEntity) {
        ValidatorUtils.validateEntity(deptQueryEntity);
        List list = deptService.queryList(deptQueryEntity);
        return Res.ok(list);
    }

    /**
     * 生成子部门代码
     *
     * @param parentId
     */
    @Log(type = LogType.OPERATOR, value = "生成子部门代码")
    @ApiOperation("生成子部门代码")
    @RequiresPermissions("system:dept:build:code")
    @ResponseBody
    @GetMapping("/{parentId}/last/code")
    public Res<String> buildCode(@PathVariable("parentId") String parentId) {
        Res res = Res.ok();
        res.setData(deptService.autoBuildCode(parentId));
        return res;
    }

    /**
     * 部门详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY, value = "部门详情查询")
    @ApiOperation("部门详情查询")
    @RequiresPermissions("system:dept:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<DeptEntity> detail(@PathVariable("id") String id) {
        DeptEntity dept = deptService.queryObject(id);
        return Res.ok(dept);
    }

    /**
     * 添加部门
     *
     * @param deptUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加部门")
    @ApiOperation("添加部门")
    @RequiresPermissions("system:dept:add")
    @ResponseBody
    @PostMapping
    public Res<DeptEntity> save(@RequestBody DeptUpdateEntity deptUpdateEntity) {
        ValidatorUtils.validateEntity(deptUpdateEntity, AddGroup.class);
        DeptEntity deptEntity = deptService.save(deptUpdateEntity);
        return Res.ok(deptEntity);
    }

    /**
     * 修改部门
     *
     * @param deptUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改部门")
    @ApiOperation("修改部门")
    @RequiresPermissions("system:dept:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody DeptUpdateEntity deptUpdateEntity) {
        ValidatorUtils.validateEntity(deptUpdateEntity, UpdateGroup.class);
        deptService.update(deptUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除部门
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除部门")
    @ApiOperation("删除部门")
    @RequiresPermissions("system:dept:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id) {
        deptService.delete(id);
        return Res.ok();
    }

}