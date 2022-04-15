package io.renren.modules.weather.entity;

import lombok.Data;

import java.util.List;

@Data
public class StatisticEntity {
    public int commentCount;
    public int weatherCount;
    public int forecastCount;

    public List<Integer> weatherSta;
    public List<Integer> commentSta;
    public List<Integer> registeSta;

}
