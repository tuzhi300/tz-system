package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
/**
 * 分页查询页面元素（功能按钮）
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-06 17:07:58
 */
@ApiModel(value = "分页查询页面元素（功能按钮）")
@Data
public class ElementQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 菜单页面元素
    */
    @ApiModelProperty(value = "菜单页面元素", required = true, position = 1 )
    private String categoryId;
    /**
    * 元素名称
    */
    @Length(max = 45 ,message = "元素名称不能超过45个字符")
    @ApiModelProperty(value = "元素名称，最大长度：45", required = true, position = 2 )
    private String name;
    /**
    * 状态  1：正常  0：禁用
    */
    @ApiModelProperty(value = "状态  1：正常  0：禁用，默认值：1", required = true, position = 3 )
    private Integer status;
    @ApiModelProperty(value = "权限编码，前端验证编码")
    private String code;

}
