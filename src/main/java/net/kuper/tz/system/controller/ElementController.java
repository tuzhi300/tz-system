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
import net.kuper.tz.system.entity.ElementEntity;
import net.kuper.tz.system.entity.ElementQueryEntity;
import net.kuper.tz.system.entity.ElementUpdateEntity;
import net.kuper.tz.system.service.ElementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 页面元素（功能按钮）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-06 17:07:58
 */
@Api(value = "页面元素（功能按钮）" , description = "页面元素（功能按钮）" )
@RestController
@RequestMapping("system/element" )
public class ElementController {

    @Autowired
    private ElementService elementService;

    /**
     * 分页查询：页面元素（功能按钮）
     * @param elementQueryEntity
     */
    @Log(type = LogType.QUERY, value = "分页查询页面元素（功能按钮）")
    @ApiOperation("分页查询页面元素（功能按钮）" )
    @RequiresPermissions("system:element:list" )
    @ResponseBody
    @GetMapping
    public Res<Pagination<ElementEntity>> list(ElementQueryEntity elementQueryEntity) {
        ValidatorUtils.validateEntity(elementQueryEntity);
        Pagination pagination = elementService.queryList(elementQueryEntity);
        return Res.ok(pagination);
    }


    /**
     * 页面元素（功能按钮）详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY, value = "页面元素（功能按钮）详情查询")
    @ApiOperation("页面元素（功能按钮）详情查询" )
    @RequiresPermissions("system:element:detail" )
    @ResponseBody
    @GetMapping(value = "/{id}" )
    public Res<ElementEntity> detail(@PathVariable("id") String id) {
        ElementEntity  element = elementService.queryObject(id);
        return Res.ok(element);
    }

    /**
     * 添加页面元素（功能按钮）
     *
     * @param elementUpdateEntity
     */
    @Log(type = LogType.SAVE,value = "添加页面元素（功能按钮）" )
    @ApiOperation("添加页面元素（功能按钮）" )
    @RequiresPermissions("system:element:add" )
    @ResponseBody
    @PostMapping
    public Res<ElementEntity> save(@RequestBody ElementUpdateEntity elementUpdateEntity) {
        ValidatorUtils.validateEntity(elementUpdateEntity, AddGroup.class);
        ElementEntity elementEntity =elementService.save(elementUpdateEntity);
        return Res.ok(elementEntity);
    }

    /**
     * 修改页面元素（功能按钮）
     * @param elementUpdateEntity
     */
    @Log(type = LogType.UPDATE,value = "修改页面元素（功能按钮）" )
    @ApiOperation("修改页面元素（功能按钮）" )
    @RequiresPermissions("system:element:update" )
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody ElementUpdateEntity elementUpdateEntity) {
        ValidatorUtils.validateEntity(elementUpdateEntity, UpdateGroup.class);
        elementService.update(elementUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除页面元素（功能按钮）
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除页面元素（功能按钮）" )
    @ApiOperation("删除页面元素（功能按钮）" )
    @RequiresPermissions("system:element:delete" )
    @ResponseBody
    @DeleteMapping(value = "/{id}" )
    public Res delete(@PathVariable("id") String id) {
        elementService.delete(id);
        return Res.ok();
    }

}