package io.renren.modules.weather.dao;

import io.renren.modules.weather.entity.UserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户身份表
 * 
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-22 14:07:03
 */
@Mapper
public interface UserRoleDao extends BaseMapper<UserRoleEntity> {
	
}
