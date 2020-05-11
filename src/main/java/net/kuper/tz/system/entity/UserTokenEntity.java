package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员Token
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2019-04-25 12:33:55
 */
@ApiModel(value = "管理员Token")
@Data
public class UserTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;
    /**
     * 登录TOKEN
     */
    @ApiModelProperty(value = "登录TOKEN")
    private String token;
    /**
     * token过期时间
     */
    @ApiModelProperty(value = "token过期时间")
    private Date expireTime;
    /**
     * 变更时间
     */
    @ApiModelProperty(value = "变更时间")
    private Date updateTime;


}
