package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.system.entity.ElementOperationEntity;
import net.kuper.tz.system.entity.ElementOperationQueryEntity;
import net.kuper.tz.system.entity.ElementOperationUpdateEntity;
import net.kuper.tz.system.service.ElementOperationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 11:02:55
 */
@Api(value = "", description = "")
@RestController
@RequestMapping("system/elementoperation")
public class ElementOperationController {

    @Autowired
    private ElementOperationService elementOperationService;

    /**
     * 分页查询：
     *
     * @param elementOperationQueryEntity
     */
    @Log(type = LogType.QUERY, value = "查询页面元素关联接口")
    @ApiOperation("查询页面元素关联接口")
    @RequiresPermissions("system:elementoperation:list" )
    @ResponseBody
    @GetMapping
    public Res<List<ElementOperationEntity>> list(ElementOperationQueryEntity elementOperationQueryEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(elementOperationQueryEntity);
        List list = elementOperationService.queryList(elementOperationQueryEntity, userId);
        return Res.ok(list);
    }

    /**
     * 添加
     *
     * @param elementOperationUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加页面元素关联接口")
    @ApiOperation("添加页面元素关联接口")
    @RequiresPermissions("system:elementoperation:add" )
    @ResponseBody
    @PostMapping
    public Res<ElementOperationEntity> save(@RequestBody ElementOperationUpdateEntity elementOperationUpdateEntity) {
        ValidatorUtils.validateEntity(elementOperationUpdateEntity, AddGroup.class);
        ElementOperationEntity elementOperationEntity = elementOperationService.save(elementOperationUpdateEntity);
        return Res.ok(elementOperationEntity);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除页面元素关联接口")
    @ApiOperation("删除页面元素关联接口")
    @RequiresPermissions("system:elementoperation:delete" )
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id, @ApiIgnore @UserId String userId) {
        elementOperationService.delete(id, userId);
        return Res.ok();
    }

}