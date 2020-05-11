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
 * 变更用户数据权限
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-11 17:34:14
 */
@ApiModel(value = "变更用户数据权限")
@Data
public class UserDataUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 0 )
    private String id;
    @NotNull(message = "为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 45 ,message = "不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 1 )
    private String userId;
    @NotNull(message = "为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 45 ,message = "不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 2 )
    private String deptId;
    /**
     * 限制角色权限：1是，0否
     */
    @NotNull(message = "限制角色权限：1是，0否为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "限制角色权限：1是，0否，默认值：0", required = true, position = 3 )
    private Integer rightType;


}
