package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色或用户组[仅实现分组，代码中按组实现批量处理功能]
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@ApiModel(value = "角色或用户组[仅实现分组，代码中按组实现批量处理功能]")
@Data
public class GroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分组信息表
     */
    @ApiModelProperty(value = "分组信息表")
    private String id;
    @ApiModelProperty(value = "")
    private String name;
    /**
     * 变更时间
     */
    @ApiModelProperty(value = "变更时间")
    private Date updateTime;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 删除： >=1:是 ，0:否
     */
    @ApiModelProperty(value = "删除： >=1:是 ，0:否")
    private Date deleteTime;

}
