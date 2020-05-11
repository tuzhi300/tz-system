package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作（接口）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "操作（接口）")
@Data
public class OperationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String name;
    /**
     * 权限代码，如：sys:user:delete
     */
    @ApiModelProperty(value = "权限代码，如：sys:user:delete")
    private String code;
    /**
     * 控制器
     */
    @ApiModelProperty(value = "控制器")
    private String controllerId;
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
    @ApiModelProperty(value = "控制器名称")
    private String controllerName;
    @ApiModelProperty(value = "控制器")
    private String controller;
    @ApiModelProperty(value = "模块键值")
    private String moduleKey;
    @ApiModelProperty(value = "模块名称")
    private String moduleName;


}
