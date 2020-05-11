package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 变更菜单
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "变更菜单")
@Data
public class MenuUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0 )
    private String id;
    /**
     * 父菜单ID，一级菜单为0
     */
    @ApiModelProperty(value = "父菜单ID，一级菜单为0", position = 1 )
    private String parentId;
    /**
     * 类型   0：目录   1：菜单
     */
    @ApiModelProperty(value = "类型   0：目录   1：菜单", position = 2 )
    private Integer type;
    /**
     * 菜单显示名称
     */
    @Length(max = 50 ,message = "菜单显示名称不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "菜单显示名称，最大长度：50", position = 3 )
    private String title;
    /**
     * 组件或链接
     */
    @Length(max = 100 ,message = "组件或链接不能超过100个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "组件或链接，最大长度：100", position = 4 )
    private String component;
    /**
     * 访问地址（路由文件地址）
     */
    @NotNull(message = "访问地址为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "访问地址不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "访问地址不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "访问地址（路由文件地址），最大长度：50", required = true, position = 5 )
    private String routePath;
    /**
     * 路由名称(英文与数字)
     */
    @NotNull(message = "路由名称(英文与数字)为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "路由名称(英文与数字)不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "路由名称(英文与数字)不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "路由名称(英文与数字)，最大长度：50", required = true, position = 6 )
    private String routeName;
    /**
     * 菜单显示图标
     */
    @Length(max = 50 ,message = "菜单显示图标不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "菜单显示图标，最大长度：50", position = 7 )
    private String icon;
    /**
     * 固定页签：1是，0否
     */
    @NotNull(message = "固定页签为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "固定页签：1是，0否，默认值：0", required = true, position = 8 )
    private Integer affix;
    /**
     * 菜单隐藏：1是，0否
     */
    @NotNull(message = "隐藏状态为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "菜单隐藏：1是，0否，默认值：0", required = true, position = 9 )
    private Integer hidden;
    /**
     * 显示面包屑：1是，0否
     */
    @NotNull(message = "显示面包屑为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "显示面包屑：1是，0否，默认值：1", required = true, position = 10 )
    private Integer breadcrumb;
    /**
     * 打开方式：1浏览器Tab，0自带Tag，2隐藏Tag
     */
    @NotNull(message = "打开方式：1浏览器Tab，0自带Tag，2隐藏Tag为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "打开方式：1浏览器Tab，0自带Tag，2隐藏Tag，默认值：0", required = true, position = 11 )
    private Integer openIn;
    /**
     * 激活菜单
     */
    @Length(max = 50 ,message = "激活菜单不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "激活菜单，最大长度：50", position = 12 )
    private String activeMenu;
    /**
     * 非组件：1是，0否
     */
    @NotNull(message = "非组件为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "非组件：1是，0否，默认值：0", required = true, position = 13 )
    private Integer noComponent;
    /**
     * 不缓存页面：1是，0否
     */
    @NotNull(message = "不缓存页面为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "不缓存页面：1是，0否，默认值：0", required = true, position = 14 )
    private Integer noCache;
    /**
     * 排序
     */
//    @NotNull(message = "排序为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "排序，默认值：1", required = true, position = 15 )
    private Integer sortNo;
    /**
     * 状态  1：正常  0：禁用
     */
//    @NotNull(message = "状态  1：正常  0：禁用为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "状态  1：正常  0：禁用，默认值：1", required = true, position = 16 )
    private Integer status;

}
