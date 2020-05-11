package net.kuper.tz.system.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginEntity implements Serializable {

    /**
     * key
     */
    @ApiModelProperty(value = "获取验证码时的KEY")
    private String key;
    @ApiModelProperty(value = "验证码")
    private String code;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;

}
