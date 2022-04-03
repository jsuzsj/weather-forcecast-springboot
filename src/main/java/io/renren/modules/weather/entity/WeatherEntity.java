package io.renren.modules.weather.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 天气管理
 * 
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-21 22:38:17
 */
@Data
@TableName("weather")
public class WeatherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 当天天气id
	 */
	@TableId
	private Integer id;
	/**
	 * 对应城市信息
	 */
	private Integer cityid;
	/**
	 * 预防感冒小提示
	 */
	private String ganmao;
	/**
	 * 当天天气温度
	 */
	private Integer wendu;

}
