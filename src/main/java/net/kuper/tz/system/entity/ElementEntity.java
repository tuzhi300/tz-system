package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 页面元素（功能按钮）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-06 17:07:58
 */
@ApiModel(value = "页面元素（功能按钮）")
@Data
public class ElementEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 菜单页面元素
     */
    @ApiModelProperty(value = "菜单页面元素")
    private String categoryId;
    /**
     * 元素名称
     */
    @ApiModelProperty(value = "元素名称")
    private String name;

    @ApiModelProperty(value = "权限编码，前端验证编码")
    private String code;
    /**
     * 状态  1：正常  0：禁用
     */
    @ApiModelProperty(value = "状态  1：正常  0：禁用")
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
    @ApiModelProperty(value = "元素类型名称")
    private String categoryName;


}
