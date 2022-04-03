package io.renren.modules.weather.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.weather.entity.CityEntity;
import io.renren.modules.weather.service.CityService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 城市管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-28 17:25:35
 */
@RestController
@RequestMapping("weather/city")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weather:city:list")
    public R list(@RequestParam Map<String, Object> params){
        String city = (String) params.get("key");
        Integer page1 = Integer.valueOf((String) params.get("page")) ;
        Integer limit = Integer.valueOf((String) params.get("limit"));
        QueryWrapper<CityEntity> wapper = new QueryWrapper<>();
        wapper.like("county",city);
        Page<CityEntity> page = new Page<>(page1-1,limit);
        Page<CityEntity> page2 = cityService.page(page, wapper);
        PageUtils page3 = new PageUtils(page2);
        return R.ok().put("page", page3);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cityid}")
    @RequiresPermissions("weather:city:info")
    public R info(@PathVariable("cityid") Integer cityid){
		CityEntity city = cityService.getById(cityid);

        return R.ok().put("city", city);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weather:city:save")
    public R save(@RequestBody CityEntity city){
		cityService.save(city);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weather:city:update")
    public R update(@RequestBody CityEntity city){
		cityService.updateById(city);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weather:city:delete")
    public R delete(@RequestBody Integer[] cityids){
		cityService.removeByIds(Arrays.asList(cityids));

        return R.ok();
    }

}
