package io.renren.modules.weather.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.weather.dao.StatisticDao;
import io.renren.modules.weather.entity.StatisticEntity;
import io.renren.modules.weather.entity.UserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("sta")
public class StatisticController {
    @Autowired
    StatisticDao statisticDao;

    /**
     * ап╠М
     */
    @RequestMapping("/info")
    public R list(){
//        PageUtils page = userService.queryPage(params);
        StatisticEntity statisticEntity = statisticDao.selectSta();
        statisticEntity.setWeatherSta(statisticDao.selectWeatherSta());
        return R.ok().put("info", statisticEntity);
    }
}
