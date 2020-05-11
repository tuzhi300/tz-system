package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 11:02:55
 */
@ApiModel(value = "")
@Data
public class ElementOperationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    private String elementId;
    @ApiModelProperty(value = "")
    private String operationId;
    @ApiModelProperty(value = "")
    private String operationName;
    @ApiModelProperty(value = "")
    private String controllerName;
    @ApiModelProperty(value = "")
    private Integer editable;
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
