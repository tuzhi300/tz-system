package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 变更部门
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "变更部门")
@Data
public class DeptUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0 )
    private String id;
    /**
     * 上级部门
     */
    @ApiModelProperty(value = "上级部门", position = 1 )
    private String parentId;
    /**
     * 部门代码：最高级3位，按次序依次递增2位
     */
    @NotNull(message = "部门代码为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "部门代码不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 32 ,message = "部门代码不能超过32个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "部门代码：最高级3位，按次序依次递增2位，最大长度：32", required = true, position = 2 )
    private String code;
    /**
     * 部门名称
     */
    @NotNull(message = "部门名称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "部门名称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "部门名称不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "部门名称，最大长度：50", required = true, position = 3 )
    private String name;
    /**
     * 排序
     */
//    @NotNull(message = "排序为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "排序", required = true, position = 4 )
    private Integer orderNum;
    /**
     * 状态：1启用，0禁用
     */
//    @NotNull(message = "禁用状态为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "状态：1启用，0禁用，默认值：1", required = true, position = 5 )
    private Integer status;


}
