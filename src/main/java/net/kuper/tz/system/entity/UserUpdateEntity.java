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
 * 变更用户
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "变更用户")
@Data
public class UserUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0)
    private String id;
    /**
     * 用户名
     */
    @NotNull(message = "用户名为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "用户名不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50, message = "用户名不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "用户名，最大长度：50", required = true, position = 1)
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码，最大长度：200", position = 2, hidden = true)
    private String password;
    /**
     * 盐
     */
    @ApiModelProperty(value = "盐，最大长度：20", position = 3, hidden = true)
    private String salt;
    /**
     * 邮箱
     */
    @Length(max = 100, message = "邮箱不能超过100个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "邮箱，最大长度：100", position = 4)
    private String email;
    /**
     * 手机号
     */
    @Length(max = 100, message = "手机号不能超过100个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "手机号，最大长度：100", position = 5)
    private String mobile;
    /**
     * 状态  0：禁用   1：正常
     */
    @NotNull(message = "状态  0：禁用   1：正常为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "状态  0：禁用   1：正常，默认值：1", required = true, position = 6)
    private Integer status;
    /**
     * 所属部门
     */
    @NotNull(message = "所属部门为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "所属部门", required = true, position = 7)
    private String deptId;

}
