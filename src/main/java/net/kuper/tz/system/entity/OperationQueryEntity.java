package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * 分页查询操作（接口）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "分页查询操作（接口）")
@Data
public class OperationQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限名称
     */
    @Length(max = 64, message = "权限名称不能超过64个字符")
    @ApiModelProperty(value = "权限名称，最大长度：64", required = true, position = 1)
    private String name;
    /**
     * 权限代码，如：sys:user:delete
     */
    @Length(max = 64, message = "权限代码，如：sys:user:delete不能超过64个字符")
    @ApiModelProperty(value = "权限代码，如：sys:user:delete，最大长度：64", required = true, position = 2)
    private String code;
    /**
     * 控制器
     */
    @ApiModelProperty(value = "控制器", required = true, position = 3)
    private String controllerId;

    @ApiModelProperty(value = "功能模块", required = true, position = 1)
    private String module;


}
