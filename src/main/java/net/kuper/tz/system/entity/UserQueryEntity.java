package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
/**
 * 分页查询用户
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "分页查询用户")
@Data
public class UserQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 用户名
    */
    @Length(max = 50 ,message = "用户名不能超过50个字符")
    @ApiModelProperty(value = "用户名，最大长度：50", required = true, position = 1 )
    private String username;
    /**
    * 邮箱
    */
    @Length(max = 100 ,message = "邮箱不能超过100个字符")
    @ApiModelProperty(value = "邮箱，最大长度：100", position = 4 )
    private String email;
    /**
    * 手机号
    */
    @Length(max = 100 ,message = "手机号不能超过100个字符")
    @ApiModelProperty(value = "手机号，最大长度：100", position = 5 )
    private String mobile;
    /**
    * 状态  0：禁用   1：正常
    */
    @ApiModelProperty(value = "状态  0：禁用   1：正常，默认值：1", required = true, position = 6 )
    private Integer status;
    /**
    * 所属部门
    */
    @ApiModelProperty(value = "所属部门", required = true, position = 7 )
    private String deptId;
    /**
    * 变更时间
    */
    @ApiModelProperty(value = "变更时间", position = 8 )
    private Date updateTime;
    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 9 )
    private Date createTime;
    /**
    * 删除： >=1:是 ，0:否
    */
    @ApiModelProperty(value = "删除： >=1:是 ，0:否，默认值：0", required = true, position = 10 )
    private Date deleteTime;


}
