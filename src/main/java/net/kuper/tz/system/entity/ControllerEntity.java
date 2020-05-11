package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 控制器（接口操作分类）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "控制器（接口操作分类）")
@Data
public class ControllerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 逻辑名称（代码）
     */
    @ApiModelProperty(value = "逻辑名称（代码）")
    private String controller;
    /**
     * 显示名称
     */
    @ApiModelProperty(value = "显示名称")
    private String name;
    /**
     * 所属模块（字典值）
     */
    @ApiModelProperty(value = "所属模块（字典值）")
    private String module;
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
