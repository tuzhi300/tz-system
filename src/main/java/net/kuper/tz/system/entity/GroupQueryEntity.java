package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
/**
 * 分页查询角色或用户组[仅实现分组，代码中按组实现批量处理功能]
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "分页查询角色或用户组[仅实现分组，代码中按组实现批量处理功能]")
@Data
public class GroupQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Length(max = 50 ,message = "不能超过50个字符")
    @ApiModelProperty(value = "，最大长度：50", required = true, position = 1 )
    private String name;

}
