package net.kuper.tz.system.params;

import lombok.Getter;
import lombok.Setter;
import net.kuper.tz.system.entity.RoleMenuUpdateEntity;

import java.util.List;

@Getter
@Setter
public class UpdateRoleMenuEntity {
    private String roleId;
    private List<RoleMenuUpdateEntity> list;
}
