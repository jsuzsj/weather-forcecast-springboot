package io.renren.modules.weather.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户身份表
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-22 14:07:03
 */
@Data
@TableName("user_role")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId
	private Long uid;
	/**
	 * 用户角色
	 */
	private String role;
	/**
	 * 创建日期
	 */
	private Date createtime;
	/**
	 * 操作员
	 */
	private Long createrid;
	/**
	 * 操作IP
	 */
	private String createrip;
	/**
	 * 其他信息
	 */
	private String jdata;
	/**
	 * 主键
	 */
	private Integer id;

}
