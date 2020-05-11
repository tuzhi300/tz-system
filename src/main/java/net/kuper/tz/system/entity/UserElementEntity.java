package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户菜单功能
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@ApiModel(value = "用户菜单功能")
@Data
public class UserElementEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;
    /**
     * 页面元素ID
     */
    @ApiModelProperty(value = "页面元素ID")
    private String elementId;
    @ApiModelProperty(value = "功能分类")
    private String categoryId;
    @ApiModelProperty(value = "功能名称")
    private String elementName;
    @ApiModelProperty(value = "授权类型：0仅访问，1可授权，2禁用")
    private Integer rightType;
    @ApiModelProperty(value = "可编辑: 1是，2否")
    private Integer editable;
    @ApiModelProperty(value = "已选中: 1是，0否")
    private Integer checked;
    @ApiModelProperty(value = "角色权限已选中: 1是，0否")
    private Integer roleChecked;


}
