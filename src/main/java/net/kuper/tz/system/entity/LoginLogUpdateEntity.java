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
import java.util.Date;

/**
 * 变更登录历史
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:33:53
 */
@ApiModel(value = "变更登录历史")
@Data
public class LoginLogUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0 )
    private String id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", position = 1 )
    private String userId;
    /**
     * 登录名
     */
    @NotNull(message = "登录名为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "登录名不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "登录名不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "登录名，最大长度：50", required = true, position = 2 )
    private String loginName;
    /**
     * 密码
     */
    @Length(max = 64 ,message = "密码不能超过64个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "密码，最大长度：64", position = 3 )
    private String password;
    /**
     * 加密串
     */
    @Length(max = 20 ,message = "加密串不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "加密串，最大长度：20", position = 4 )
    private String salt;
    /**
     * 登录成功：1是，0否
     */
    @NotNull(message = "登录成功：1是，0否为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "登录成功：1是，0否，默认值：0", required = true, position = 5 )
    private Integer successed;
    /**
     * 客户端类型
     */
    @Length(max = 20 ,message = "客户端类型不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "客户端类型，最大长度：20", position = 6 )
    private String clientType;
    /**
     * 客户端版本
     */
    @Length(max = 20 ,message = "客户端版本不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "客户端版本，最大长度：20", position = 7 )
    private String clientVersion;
    /**
     * 登录IP
     */
    @Length(max = 20 ,message = "登录IP不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "登录IP，最大长度：20", position = 8 )
    private String ip;
    /**
     * 变更时间
     */
    @ApiModelProperty(value = "变更时间", position = 9 )
    private Date updateTime;
    /**
     * 创建时间
     */
    @NotNull(message = "创建时间为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 10 )
    private Date createTime;

}
