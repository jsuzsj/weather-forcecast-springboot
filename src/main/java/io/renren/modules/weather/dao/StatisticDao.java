package io.renren.modules.weather.dao;

import io.renren.modules.weather.entity.StatisticEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticDao {
    public StatisticEntity selectSta();

    public List<Integer> selectWeatherSta();
}
