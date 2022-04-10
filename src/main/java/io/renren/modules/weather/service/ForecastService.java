package io.renren.modules.weather.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.weather.entity.ForecastEntity;

import java.util.Map;

/**
 * 天气预报管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-21 22:38:17
 */
public interface ForecastService extends IService<ForecastEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils apiqueryPage(Map<String, Object> params);
}

