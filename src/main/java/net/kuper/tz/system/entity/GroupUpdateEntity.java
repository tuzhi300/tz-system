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
 * 变更角色或用户组[仅实现分组，代码中按组实现批量处理功能]
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "变更角色或用户组[仅实现分组，代码中按组实现批量处理功能]")
@Data
public class GroupUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分组信息表
     */
    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "分组信息表", required = true, position = 0 )
    private String id;
    @NotNull(message = "为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：50", required = true, position = 1 )
    private String name;

}
