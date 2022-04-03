package io.renren.modules.weather.dao;

import io.renren.modules.weather.entity.ForecastEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 天气预报管理
 * 
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-21 22:38:17
 */
@Mapper
public interface ForecastDao extends BaseMapper<ForecastEntity> {
	
}
