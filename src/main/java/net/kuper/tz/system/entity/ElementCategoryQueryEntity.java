package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * 分页查询元素分类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-08 21:00:14
 */
@ApiModel(value = "分页查询元素分类")
@Data
public class ElementCategoryQueryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Length(max = 45, message = "不能超过45个字符")
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 1)
    private String name;


}
