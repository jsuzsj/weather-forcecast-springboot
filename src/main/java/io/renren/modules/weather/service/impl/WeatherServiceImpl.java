package io.renren.modules.weather.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.weather.dao.WeatherDao;
import io.renren.modules.weather.entity.WeatherEntity;
import io.renren.modules.weather.service.WeatherService;


@Service("weatherService")
public class WeatherServiceImpl extends ServiceImpl<WeatherDao, WeatherEntity> implements WeatherService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WeatherEntity> page = this.page(
                new Query<WeatherEntity>().getPage(params),
                new QueryWrapper<WeatherEntity>()
        );

        return new PageUtils(page);
    }

}