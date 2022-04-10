package io.renren.modules.weather.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.weather.entity.CityEntity;

import java.util.List;
import java.util.Map;

/**
 * 城市管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-28 17:25:35
 */
public interface CityService extends IService<CityEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CityEntity> cityList();
}

