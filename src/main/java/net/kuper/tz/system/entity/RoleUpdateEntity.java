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
 * 变更角色
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "变更角色")
@Data
public class RoleUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0)
    private String id;
    /**
     * 权限所在部门权限
     */
    @ApiModelProperty(value = "权限所在部门权限", position = 1)
    private String deptId;
    /**
     * 角色名称
     */
    @NotNull(message = "角色名称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "角色名称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 20, message = "角色名称不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "角色名称，最大长度：20", required = true, position = 2)
    private String roleName;
    /**
     * 岗位个数
     */
    @ApiModelProperty(value = "岗位个数", position = 3)
    private Integer count;
    /**
     * 备注
     */
    @Length(max = 50, message = "备注不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "备注，最大长度：50", position = 4)
    private String remark;

}
