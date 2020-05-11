package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 变更控制器（接口操作分类）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "变更控制器（接口操作分类）")
@Data
public class ControllerUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0 )
    private String id;
    /**
     * 逻辑名称（代码）
     */
    @NotNull(message = "逻辑名称（代码）为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "逻辑名称（代码）不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "逻辑名称（代码）不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "逻辑名称（代码），最大长度：50", required = true, position = 1 )
    private String controller;
    /**
     * 显示名称
     */
    @NotNull(message = "显示名称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "显示名称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "显示名称不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "显示名称，最大长度：50", required = true, position = 2 )
    private String name;
    /**
     * 所属模块（字典值）
     */
    @NotNull(message = "所属模块（字典值）为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "所属模块（字典值）不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "所属模块（字典值）不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "所属模块（字典值），最大长度：50", required = true, position = 3 )
    private String module;


}
