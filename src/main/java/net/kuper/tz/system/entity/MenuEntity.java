package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "菜单")
@Data
public class MenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 父菜单ID，一级菜单为0
     */
    @ApiModelProperty(value = "父菜单ID，一级菜单为0")
    private String parentId;
    /**
     * 类型   0：目录   1：菜单
     */
    @ApiModelProperty(value = "类型   0：目录   1：菜单")
    private Integer type;
    /**
     * 菜单显示名称
     */
    @ApiModelProperty(value = "菜单显示名称")
    private String title;
    /**
     * 组件或链接
     */
    @ApiModelProperty(value = "组件或链接")
    private String component;
    /**
     * 访问地址（路由文件地址）
     */
    @ApiModelProperty(value = "访问地址（路由文件地址）")
    private String routePath;
    /**
     * 路由名称(英文与数字)
     */
    @ApiModelProperty(value = "路由名称(英文与数字)")
    private String routeName;
    /**
     * 菜单显示图标
     */
    @ApiModelProperty(value = "菜单显示图标")
    private String icon;
    /**
     * 固定页签：1是，0否
     */
    @ApiModelProperty(value = "固定页签：1是，0否")
    private Integer affix;
    /**
     * 菜单隐藏：1是，0否
     */
    @ApiModelProperty(value = "菜单隐藏：1是，0否")
    private Integer hidden;
    /**
     * 显示面包屑：1是，0否
     */
    @ApiModelProperty(value = "显示面包屑：1是，0否")
    private Integer breadcrumb;
    /**
     * 打开方式：1浏览器Tab，0自带Tag，2隐藏Tag
     */
    @ApiModelProperty(value = "打开方式：1浏览器Tab，0自带Tag，2隐藏Tag")
    private Integer openIn;
    /**
     * 激活菜单
     */
    @ApiModelProperty(value = "激活菜单")
    private String activeMenu;
    /**
     * 非组件：1是，0否
     */
    @ApiModelProperty(value = "非组件：1是，0否")
    private Integer noComponent;
    /**
     * 不缓存页面：1是，0否
     */
    @ApiModelProperty(value = "不缓存页面：1是，0否")
    private Integer noCache;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sortNo;
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
    @ApiModelProperty(value = "上级菜单名称")
    private String parentTitle;


}
