package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@ApiModel(value = "用户数据权限")
@Data
public class UserDataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    private String userId;
    @ApiModelProperty(value = "")
    private String deptId;
    @ApiModelProperty(value = "")
    private String parentId;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "授权类型：0仅访问，1可授权，2禁用")
    private Integer rightType;
    @ApiModelProperty(value = "可编辑: 1是，2否")
    private Integer editable;
    @ApiModelProperty(value = "已选中: 1是，0否")
    private Integer checked;
    @ApiModelProperty(value = "角色权限已选中: 1是，0否")
    private Integer roleChecked;


}
