package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "部门")
@Data
public class DeptEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 上级部门
     */
    @ApiModelProperty(value = "上级部门")
    private String parentId;
    /**
     * 部门代码：最高级3位，按次序依次递增2位
     */
    @ApiModelProperty(value = "部门代码：最高级3位，按次序依次递增2位")
    private String code;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String name;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer orderNum;
    /**
     * 状态：1启用，0禁用
     */
    @ApiModelProperty(value = "状态：1启用，0禁用")
    private Integer status;
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

    @ApiModelProperty(value = "上级部门名称")
    private String parentName;


}
