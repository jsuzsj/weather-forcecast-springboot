package io.renren.modules.weather.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.weather.dao.CityDao;
import io.renren.modules.weather.entity.CityEntity;
import io.renren.modules.weather.service.CityService;


@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {
@Autowired
StringRedisTemplate stringRedisTemplate ;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CityEntity> page = this.page(
                new Query<CityEntity>().getPage(params),
                new QueryWrapper<CityEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CityEntity> cityList() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ObjectMapper mapper = new ObjectMapper();
        List<CityEntity> mp = null;
        if(ops.getOperations().hasKey("cityList")) {
            String jsonString = ops.get("cityList");
            try {
                mp = mapper.readValue(jsonString, new TypeReference<List<CityEntity>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else{
            mp = this.list();
        }
        return mp;
    }

}
