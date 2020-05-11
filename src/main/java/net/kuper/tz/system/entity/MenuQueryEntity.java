package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
/**
 * 分页查询菜单
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "分页查询菜单")
@Data
public class MenuQueryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

//    /**
//    * 父菜单ID，一级菜单为0
//    */
//    @ApiModelProperty(value = "父菜单ID，一级菜单为0", position = 1 )
//    private Long parentId;
//    /**
//    * 类型   0：目录   1：菜单
//    */
//    @ApiModelProperty(value = "类型   0：目录   1：菜单", position = 2 )
//    private Integer type;
//    /**
//    * 菜单显示名称
//    */
//    @Length(max = 50 ,message = "菜单显示名称不能超过50个字符")
//    @ApiModelProperty(value = "菜单显示名称，最大长度：50", position = 3 )
//    private String title;
//    /**
//    * 组件或链接
//    */
//    @Length(max = 100 ,message = "组件或链接不能超过100个字符")
//    @ApiModelProperty(value = "组件或链接，最大长度：100", position = 4 )
//    private String component;
//    /**
//    * 访问地址（路由文件地址）
//    */
//    @Length(max = 50 ,message = "访问地址（路由文件地址）不能超过50个字符")
//    @ApiModelProperty(value = "访问地址（路由文件地址），最大长度：50", required = true, position = 5 )
//    private String routePath;
//    /**
//    * 路由名称(英文与数字)
//    */
//    @Length(max = 50 ,message = "路由名称(英文与数字)不能超过50个字符")
//    @ApiModelProperty(value = "路由名称(英文与数字)，最大长度：50", required = true, position = 6 )
//    private String routeName;
//    /**
//    * 菜单显示图标
//    */
//    @Length(max = 50 ,message = "菜单显示图标不能超过50个字符")
//    @ApiModelProperty(value = "菜单显示图标，最大长度：50", position = 7 )
//    private String icon;
//    /**
//    * 固定页签：1是，0否
//    */
//    @ApiModelProperty(value = "固定页签：1是，0否，默认值：0", required = true, position = 8 )
//    private Integer affix;
//    /**
//    * 菜单隐藏：1是，0否
//    */
//    @ApiModelProperty(value = "菜单隐藏：1是，0否，默认值：0", required = true, position = 9 )
//    private Integer hidden;
//    /**
//    * 显示面包屑：1是，0否
//    */
//    @ApiModelProperty(value = "显示面包屑：1是，0否，默认值：1", required = true, position = 10 )
//    private Integer breadcrumb;
//    /**
//    * 打开方式：1浏览器Tab，0自带Tag，2隐藏Tag
//    */
//    @ApiModelProperty(value = "打开方式：1浏览器Tab，0自带Tag，2隐藏Tag，默认值：0", required = true, position = 11 )
//    private Integer openIn;
//    /**
//    * 激活菜单
//    */
//    @Length(max = 50 ,message = "激活菜单不能超过50个字符")
//    @ApiModelProperty(value = "激活菜单，最大长度：50", position = 12 )
//    private String activeMenu;
//    /**
//    * 非组件：1是，0否
//    */
//    @ApiModelProperty(value = "非组件：1是，0否，默认值：0", required = true, position = 13 )
//    private Integer noComponent;
//    /**
//    * 不缓存页面：1是，0否
//    */
//    @ApiModelProperty(value = "不缓存页面：1是，0否，默认值：0", required = true, position = 14 )
//    private Integer noCache;
//    /**
//    * 排序
//    */
//    @ApiModelProperty(value = "排序，默认值：1", required = true, position = 15 )
//    private Integer sortNo;
//    /**
//    * 状态  1：正常  0：禁用
//    */
//    @ApiModelProperty(value = "状态  1：正常  0：禁用，默认值：1", required = true, position = 16 )
//    private Integer status;
//    /**
//    * 变更时间
//    */
//    @ApiModelProperty(value = "变更时间", position = 17 )
//    private Date updateTime;
//    /**
//    * 创建时间
//    */
//    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 18 )
//    private Date createTime;
//    /**
//    * 删除： >=1:是 ，0:否
//    */
//    @ApiModelProperty(value = "删除： >=1:是 ，0:否，默认值：0", required = true, position = 19 )
//    private Date deleteTime;


}
