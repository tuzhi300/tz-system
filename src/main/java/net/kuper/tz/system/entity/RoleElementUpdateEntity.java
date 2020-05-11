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
 * 变更角色菜单元素
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@ApiModel(value = "变更角色菜单元素")
@Data
public class RoleElementUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

//    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 0 )
    private String id;
    /**
     * 角色ID
     */
//    @NotNull(message = "角色ID为必填", groups = {AddGroup.class, UpdateGroup.class})
//    @NotBlank(message = "角色ID不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
//    @Length(max = 45 ,message = "角色ID不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "角色ID，最大长度：45", required = true, position = 1 )
    private String roleId;
    /**
     * 页面元素ID
     */
    @NotNull(message = "页面元素ID为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "页面元素ID不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 45 ,message = "页面元素ID不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "页面元素ID，最大长度：45", required = true, position = 2 )
    private String elementId;
    /**
     * 授权类型：0仅访问，1可授权
     */
    @NotNull(message = "授权类型：0仅访问，1可授权为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "授权类型：0仅访问，1可授权，默认值：0", required = true, position = 3 )
    private Integer rightType;

}
