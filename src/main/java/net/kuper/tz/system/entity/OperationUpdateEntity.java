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
 * 变更操作（接口）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "变更操作（接口）")
@Data
public class OperationUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0 )
    private String id;
    /**
     * 权限名称
     */
    @NotNull(message = "权限名称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "权限名称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 64 ,message = "权限名称不能超过64个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "权限名称，最大长度：64", required = true, position = 1 )
    private String name;
    /**
     * 权限代码，如：sys:user:delete
     */
    @NotNull(message = "权限代码，如：sys:user:delete为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "权限代码，如：sys:user:delete不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 64 ,message = "权限代码，如：sys:user:delete不能超过64个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "权限代码，如：sys:user:delete，最大长度：64", required = true, position = 2 )
    private String code;
    /**
     * 控制器
     */
    @NotNull(message = "控制器为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "控制器", required = true, position = 3 )
    private String controllerId;


}
