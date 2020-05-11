package net.kuper.tz.system.params;

import lombok.Getter;
import lombok.Setter;
import net.kuper.tz.system.entity.RoleDataUpdateEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UpdateRoleDataEntity {

    @NotBlank(message = "角色ID不能为空")
    @NotNull(message = "角色ID不能为空")
    private String roleId;
    private List<@Valid RoleDataUpdateEntity> list;
}
