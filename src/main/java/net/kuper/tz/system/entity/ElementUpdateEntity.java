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
 * 变更页面元素（功能按钮）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-06 17:07:58
 */
@ApiModel(value = "变更页面元素（功能按钮）")
@Data
public class ElementUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0 )
    private String id;
    /**
     * 菜单页面元素
     */
    @NotNull(message = "菜单页面元素为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "菜单页面元素", required = true, position = 1 )
    private String categoryId;
    /**
     * 元素名称
     */
    @NotNull(message = "元素名称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "元素名称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 45 ,message = "元素名称不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "元素名称，最大长度：45", required = true, position = 2 )
    private String name;

    @NotNull(message = "权限编码为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "权限编码不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "权限编码不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "权限编码，前端验证编码")
    private String code;
    
    /**
     * 状态  1：正常  0：禁用
     */
    @NotNull(message = "状态  1：正常  0：禁用为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "状态  1：正常  0：禁用，默认值：1", required = true, position = 3 )
    private Integer status;

}
