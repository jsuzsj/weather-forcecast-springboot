package io.renren.modules.weather.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.weather.entity.WeatherEntity;

import java.util.Map;

/**
 * 天气管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-21 22:38:17
 */
public interface WeatherService extends IService<WeatherEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

