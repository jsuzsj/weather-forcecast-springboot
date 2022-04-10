package io.renren.modules.weather.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.weather.dao.ForecastDao;
import io.renren.modules.weather.entity.ForecastEntity;
import io.renren.modules.weather.service.ForecastService;


@Service("forecastService")
public class ForecastServiceImpl extends ServiceImpl<ForecastDao, ForecastEntity> implements ForecastService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ForecastEntity> page = this.page(
                new Query<ForecastEntity>().getPage(params),
                new QueryWrapper<ForecastEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils apiqueryPage(Map<String, Object> params) {
        String cityname = (String)params.get("cityname");
        String cityid = (String)params.get("cityid");
        String day = (String) params.get("day");
        QueryWrapper<ForecastEntity> wrapper = new QueryWrapper<>();
        if(cityname!=null){
            wrapper.like("cityname",cityname);
        }else{
            wrapper.like(
                    "cityid",cityid
            );
        }
        if(day!=null){
            params.put("page","1");
            params.put("limit",day);
        }
        IPage<ForecastEntity> page = this.page(
                new Query<ForecastEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

}
