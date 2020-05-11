package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@ApiModel(value = "角色数据权限")
@Data
public class RoleDataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private String roleId;
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private String deptId;
    @ApiModelProperty(value = "上级部门ID")
    private String parentId;
    @ApiModelProperty(value = "部门编码")
    private String deptCode;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "可编辑：1是，0否")
    private Integer editable;
    @ApiModelProperty(value = "已选部门：1是，0否")
    private Integer checked;

    @ApiModelProperty(value = "授权类型：0仅访问，1可授权")
    private Integer rightType;
    /**
     * 变更时间
     */
    @ApiModelProperty(value = "变更时间")
    private Date updateTime;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 删除： >=1:是 ，0:否
     */
    @ApiModelProperty(value = "删除： >=1:是 ，0:否")
    private Date deleteTime;

}
