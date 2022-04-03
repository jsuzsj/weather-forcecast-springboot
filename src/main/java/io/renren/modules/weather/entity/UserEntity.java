package io.renren.modules.weather.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-22 14:07:03
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 联合id，oauth2唯一id
	 */
	@TableId
	private Long id;
	/**
	 * 呢称
	 */
	private String nickname;
	/**
	 * 地区
	 */
	private Integer mobileareaid;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 其他信息
	 */
	private String jdata;
	/**
	 * 身份证号码
	 */
	private String pin;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 最后更新时间
	 */
	private Date updatetime;
	/**
	 * 类别
	 */
	private String type;

}
