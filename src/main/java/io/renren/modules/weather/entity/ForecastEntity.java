package io.renren.modules.weather.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 天气预报管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-21 22:38:17
 */
@Data
@TableName("forecast")
public class ForecastEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 预报id
	 */
	@TableId
	private Integer id;
	/**
	 * 对应的城市信息
	 */
	private Integer cityid;
	/**
	 * 时间
	 */
	private String date;
	/**
	 * 最高温度
	 */
	private Integer high;
	/**
	 * 最低温度
	 */
	private Integer low;
	/**
	 * 风力等级
	 */
	private Integer fengli;
	/**
	 * 风向
	 */
	private String fengxiang;
	/**
	 * 天气类型
	 */
	private String type;

}
