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

import io.renren.modules.weather.entity.ForecastEntity;
import io.renren.modules.weather.service.ForecastService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 天气预报管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-21 22:38:17
 */
@RestController
@RequestMapping("weather/forecast")
public class ForecastController {
    @Autowired
    private ForecastService forecastService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weather:forecast:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forecastService.queryPage(params);

        return R.ok().put("page", page);
    }
    /**
     * 列表
     */
    @RequestMapping("/api")
    @RequiresPermissions("weather:forecast:list")
    public R apilist(@RequestParam Map<String, Object> params){
        PageUtils page = forecastService.apiqueryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weather:forecast:info")
    public R info(@PathVariable("id") Integer id){
		ForecastEntity forecast = forecastService.getById(id);

        return R.ok().put("forecast", forecast);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weather:forecast:save")
    public R save(@RequestBody ForecastEntity forecast){
		forecastService.save(forecast);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weather:forecast:update")
    public R update(@RequestBody ForecastEntity forecast){
		forecastService.updateById(forecast);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weather:forecast:delete")
    public R delete(@RequestBody Integer[] ids){
		forecastService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
