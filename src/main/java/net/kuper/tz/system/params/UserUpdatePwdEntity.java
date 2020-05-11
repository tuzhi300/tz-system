package net.kuper.tz.system.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

@ApiModel(value = "修改密码")
@Data
public class UserUpdatePwdEntity {

    @ApiModelProperty(value = "用户Id", hidden = true)
    private String id;

    @Length(max = 16, message = "旧密码不能超过16个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "旧密码，最大长度：16", position = 2)
    private String oldPwd;
    @Length(max = 16, message = "密码不能超过16个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "密码，最大长度：16", position = 2)
    private String password;
}
