package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
/**
 * 分页查询控制器（接口操作分类）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "分页查询控制器（接口操作分类）")
@Data
public class ControllerQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 逻辑名称（代码）
    */
    @Length(max = 50 ,message = "逻辑名称（代码）不能超过50个字符")
    @ApiModelProperty(value = "逻辑名称（代码），最大长度：50", required = true, position = 1 )
    private String controller;
    /**
    * 显示名称
    */
    @Length(max = 50 ,message = "显示名称不能超过50个字符")
    @ApiModelProperty(value = "显示名称，最大长度：50", required = true, position = 2 )
    private String name;
    /**
    * 所属模块（字典值）
    */
    @Length(max = 50 ,message = "所属模块（字典值）不能超过50个字符")
    @ApiModelProperty(value = "所属模块（字典值），最大长度：50", required = true, position = 3 )
    private String module;



}
