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
import net.kuper.tz.system.entity.LoginLogEntity;
import net.kuper.tz.system.entity.LoginLogQueryEntity;
import net.kuper.tz.system.entity.LoginLogUpdateEntity;
import net.kuper.tz.system.service.LoginLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 登录历史
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:33:53
 */
@Api(value = "登录历史", description = "登录历史")
@RestController
@RequestMapping("system/loginlog")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 分页查询：登录历史
     *
     * @param loginLogQueryEntity
     */
    @Log(type = LogType.QUERY, value = "分页查询登录历史")
    @ApiOperation("分页查询登录历史")
    @RequiresPermissions("system:loginlog:list")
    @ResponseBody
    @GetMapping
    public Res<Pagination<LoginLogEntity>> list(LoginLogQueryEntity loginLogQueryEntity) {
        ValidatorUtils.validateEntity(loginLogQueryEntity);
        Pagination pagination = loginLogService.queryList(loginLogQueryEntity);
        return Res.ok(pagination);
    }


    /**
     * 登录历史详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY, value = "登录历史详情查询")
    @ApiOperation("登录历史详情查询")
    @RequiresPermissions("system:loginlog:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<LoginLogEntity> detail(@PathVariable("id") String id) {
        LoginLogEntity loginLog = loginLogService.queryObject(id);
        return Res.ok(loginLog);
    }

    /**
     * 删除登录历史
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除登录历史")
    @ApiOperation("删除登录历史")
    @RequiresPermissions("system:loginlog:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id) {
        loginLogService.delete(id);
        return Res.ok();
    }

}