package net.kuper.tz.system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;

import java.io.Serializable;

/**
 * 分页查询管理员Token
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2019-04-25 12:33:55
 */
@ApiModel(value = "分页查询管理员Token")
@Data
public class UserTokenQueryEntity extends PaginationQuery implements Serializable {



}
