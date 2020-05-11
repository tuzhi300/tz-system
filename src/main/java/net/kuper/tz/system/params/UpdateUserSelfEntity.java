package net.kuper.tz.system.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

@ApiModel
@Data
public class UpdateUserSelfEntity {

    /**
     * 邮箱
     */
    @Length(max = 100, message = "邮箱不能超过100个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "邮箱，最大长度：100", position = 4)
    private String email;
    /**
     * 手机号
     */
    @Length(max = 100, message = "手机号不能超过100个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "手机号，最大长度：100", position = 5)
    private String mobile;
}
