package io.renren.modules.weather.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 城市管理
 * 
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-28 17:25:35
 */
@Data
@TableName("city")
public class CityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 城市名称
	 */
	private String cityname;
	/**
	 * 城市拼音
	 */
	private String citycode;
	/**
	 * 所属市
	 */
	private String province;
	/**
	 * 城市代码
	 */
	@TableId
	private Integer cityid;
	/**
	 * 
	 */
	private String county;

}
