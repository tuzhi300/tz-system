package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;

import java.io.Serializable;
/**
 * 分页查询角色
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "分页查询角色")
@Data
public class RoleQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 权限所在部门权限
    */
    @ApiModelProperty(value = "权限所在部门权限", position = 1 )
    private String deptId;
    @ApiModelProperty(value = "角色名称")
    private String roleName;

}
