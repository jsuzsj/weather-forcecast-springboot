package io.renren.modules.weather.dao;

import io.renren.modules.weather.entity.CityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 城市管理
 * 
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-28 17:25:35
 */
@Mapper
public interface CityDao extends BaseMapper<CityEntity> {
	
}
