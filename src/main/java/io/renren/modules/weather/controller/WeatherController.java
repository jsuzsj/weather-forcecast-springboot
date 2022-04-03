package io.renren.modules.weather.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.weather.entity.WeatherEntity;
import io.renren.modules.weather.service.WeatherService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 天气管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-21 22:38:17
 */
@RestController
@RequestMapping("weather/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weather:weather:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = weatherService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weather:weather:info")
    public R info(@PathVariable("id") Integer id){
		WeatherEntity weather = weatherService.getById(id);

        return R.ok().put("weather", weather);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weather:weather:save")
    public R save(@RequestBody WeatherEntity weather){
		weatherService.save(weather);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weather:weather:update")
    public R update(@RequestBody WeatherEntity weather){
		weatherService.updateById(weather);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weather:weather:delete")
    public R delete(@RequestBody Integer[] ids){
		weatherService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
