package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.ElementCategoryEntity;
import net.kuper.tz.system.entity.ElementCategoryQueryEntity;
import net.kuper.tz.system.entity.ElementCategoryUpdateEntity;
import net.kuper.tz.system.service.ElementCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 元素分类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-08 21:00:14
 */
@Api(value = "元素分类", description = "元素分类")
@RestController
@RequestMapping("system/elementcategory")
public class ElementCategoryController {

    @Autowired
    private ElementCategoryService elementCategoryService;

    /**
     * 分页查询：元素分类
     *
     */
    @Log(type = LogType.QUERY, value = "分页查询元素分类")
    @ApiOperation("分页查询元素分类")
    @RequiresPermissions("system:elementcategory:list")
    @ResponseBody
    @GetMapping
    public Res<List<ElementCategoryEntity>> list() {
        ValidatorUtils.validateEntity(new ElementCategoryQueryEntity());
        List pagination = elementCategoryService.queryList(new ElementCategoryQueryEntity());
        return Res.ok(pagination);
    }


    /**
     * 元素分类详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY, value = "元素分类详情查询")
    @ApiOperation("元素分类详情查询")
    @RequiresPermissions("system:elementcategory:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<ElementCategoryEntity> detail(@PathVariable("id") String id) {
        ElementCategoryEntity elementCategory = elementCategoryService.queryObject(id);
        return Res.ok(elementCategory);
    }

    /**
     * 添加元素分类
     *
     * @param elementCategoryUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加元素分类")
    @ApiOperation("添加元素分类")
    @RequiresPermissions("system:elementcategory:add")
    @ResponseBody
    @PostMapping
    public Res<ElementCategoryEntity> save(@RequestBody ElementCategoryUpdateEntity elementCategoryUpdateEntity) {
        ValidatorUtils.validateEntity(elementCategoryUpdateEntity, AddGroup.class);
        ElementCategoryEntity elementCategoryEntity = elementCategoryService.save(elementCategoryUpdateEntity);
        return Res.ok(elementCategoryEntity);
    }

    /**
     * 修改元素分类
     *
     * @param elementCategoryUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改元素分类")
    @ApiOperation("修改元素分类")
    @RequiresPermissions("system:elementcategory:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody ElementCategoryUpdateEntity elementCategoryUpdateEntity) {
        ValidatorUtils.validateEntity(elementCategoryUpdateEntity, UpdateGroup.class);
        elementCategoryService.update(elementCategoryUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除元素分类
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除元素分类")
    @ApiOperation("删除元素分类")
    @RequiresPermissions("system:elementcategory:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id) {
        elementCategoryService.delete(id);
        return Res.ok();
    }

}