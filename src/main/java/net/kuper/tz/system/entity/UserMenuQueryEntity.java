package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.SortQuery;

import java.io.Serializable;

/**
 * 分页查询
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@ApiModel(value = "分页查询")
@Data
public class UserMenuQueryEntity extends SortQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID", required = true, position = 1)
    private String userId;
    @ApiModelProperty(value = "", hidden = true)
    private String menuId;
    @ApiModelProperty(value = "", hidden = true)
    private Integer rightType;

}
