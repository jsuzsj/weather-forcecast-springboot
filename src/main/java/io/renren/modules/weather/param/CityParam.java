package io.renren.modules.weather.param;

import lombok.Data;

@Data
public class CityParam {

    private  String key;

    private  Integer page;

    private  Integer limit;
}
