package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@ApiModel(value = "")
@Data
public class RoleMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    private String roleId;
    @ApiModelProperty(value = "")
    private String menuId;
    @ApiModelProperty(value = "菜单名称")
    private String menuName;
    @ApiModelProperty(value = "菜单类型：0目录，1菜单")
    private Integer menuType;
    @ApiModelProperty(value = "上级菜单Id")
    private String parentId;
    @ApiModelProperty(value = "可编辑: 1是，2否")
    private Integer editable;
    @ApiModelProperty(value = "已选中: 1是，0否")
    private Integer checked;
    /**
     * 授权类型：0仅访问，1可授权，2禁用
     */
    @ApiModelProperty(value = "授权类型：0仅访问，1可授权，2禁用")
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
