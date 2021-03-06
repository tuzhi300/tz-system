package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.SortQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * 分页查询角色数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@ApiModel(value = "分页查询角色数据权限")
@Data
public class RoleDataQueryEntity extends SortQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @Length(max = 45, message = "角色ID不能超过45个字符")
    @ApiModelProperty(value = "角色ID，最大长度：45", required = true, position = 1)
    private String roleId;
    /**
     * 角色ID
     */
    @Length(max = 45, message = "用户ID不能超过45个字符")
    @ApiModelProperty(value = "用户ID", required = true, position = 1, hidden = true)
    private String userId;
    @Length(max = 45, message = "部门ID不能超过45个字符")
    @ApiModelProperty(value = "部门ID", required = true, position = 1, hidden = true)
    private String deptId;
    @ApiModelProperty(value = "", hidden = true)
    private Integer rightType;

}
