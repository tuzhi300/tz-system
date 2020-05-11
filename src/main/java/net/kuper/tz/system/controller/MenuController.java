package net.kuper.tz.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import net.kuper.tz.system.entity.MenuEntity;
import net.kuper.tz.system.entity.MenuQueryEntity;
import net.kuper.tz.system.entity.MenuUpdateEntity;
import net.kuper.tz.system.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 菜单
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Api(value = "菜单", description = "菜单")
@RestController
@RequestMapping("system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 分页查询：菜单
     *
     * @param menuQueryEntity
     */
    @Log(type = LogType.QUERY,value = "分页查询菜单" )
    @ApiOperation("分页查询菜单")
    @RequiresPermissions("system:menu:list")
    @ResponseBody
    @GetMapping
    public Res<List<MenuEntity>> list(MenuQueryEntity menuQueryEntity) {
        ValidatorUtils.validateEntity(menuQueryEntity);
        List list = menuService.queryList(menuQueryEntity);
        return Res.ok(list);
    }

    /**
     * 查询子菜单
     *
     * @param parentId
     */
    @Log(type = LogType.OPERATOR,value = "查询子菜单" )
    @ApiOperation("查询子菜单，不传参查询顶层菜单")
    @RequiresPermissions("system:menu:children" )
    @ResponseBody
    @GetMapping("/list-of-parent")
    public Res<List<MenuEntity>> listByParentId(String parentId) {
        List list = menuService.queryListByParentId(parentId);
        return Res.ok(list);
    }

    /**
     * 菜单详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY,value = "菜单详情查询" )
    @ApiOperation("菜单详情查询")
    @RequiresPermissions("system:menu:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<MenuEntity> detail(@PathVariable("id") String id) {
        MenuEntity menu = menuService.queryObject(id);
        return Res.ok(menu);
    }


    /**
     * 添加菜单
     *
     * @param menuUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加菜单")
    @ApiOperation("添加菜单")
    @RequiresPermissions("system:menu:add")
    @ResponseBody
    @PostMapping
    public Res<MenuEntity> save(@RequestBody MenuUpdateEntity menuUpdateEntity) {
        ValidatorUtils.validateEntity(menuUpdateEntity, AddGroup.class);
        MenuEntity menuEntity = menuService.save(menuUpdateEntity);
        return Res.ok(menuEntity);
    }

    /**
     * 修改菜单
     *
     * @param menuUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改菜单")
    @ApiOperation("修改菜单")
    @RequiresPermissions("system:menu:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody MenuUpdateEntity menuUpdateEntity) {
        ValidatorUtils.validateEntity(menuUpdateEntity, UpdateGroup.class);
        menuService.update(menuUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除菜单
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除菜单")
    @ApiOperation("删除菜单")
    @RequiresPermissions("system:menu:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id) {
        menuService.delete(id);
        return Res.ok();
    }

}