package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录历史
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:33:53
 */
@ApiModel(value = "登录历史")
@Data
public class LoginLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;
    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名")
    private String loginName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 加密串
     */
    @ApiModelProperty(value = "加密串")
    private String salt;
    /**
     * 登录成功：1是，0否
     */
    @ApiModelProperty(value = "登录成功：1是，0否")
    private Integer successed;
    /**
     * 客户端类型
     */
    @ApiModelProperty(value = "客户端类型")
    private String clientType;
    /**
     * 客户端版本
     */
    @ApiModelProperty(value = "客户端版本")
    private String clientVersion;
    /**
     * 登录IP
     */
    @ApiModelProperty(value = "登录IP")
    private String ip;
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
