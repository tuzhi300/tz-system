package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.SortQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
/**
 * 分页查询
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 11:02:55
 */
@ApiModel(value = "分页查询")
@Data
public class ElementOperationQueryEntity extends SortQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Length(max = 45 ,message = "不能超过45个字符")
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 1 )
    private String elementId;

}
