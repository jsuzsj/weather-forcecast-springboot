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

import io.renren.modules.weather.entity.UserEntity;
import io.renren.modules.weather.service.UserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户信息管理
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-22 14:07:03
 */
@RestController
@RequestMapping("weather/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weather:user:list")
    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = userService.queryPage(params);
        String username = (String) params.get("key");
        Integer page1 = Integer.valueOf((String) params.get("page")) ;
        Integer limit = Integer.valueOf((String) params.get("limit"));
        QueryWrapper<UserEntity> wapper = new QueryWrapper<>();
        wapper.like("nickname",username);
        Page<UserEntity> page = new Page<>(page1-1,limit);
        Page<UserEntity> page2 = userService.page(page,wapper);
        PageUtils page3 = new PageUtils(page2);
        return R.ok().put("page", page3);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("weather:user:info")
    public R info(@PathVariable("id") Long id){
		UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weather:user:save")
    public R save(@RequestBody UserEntity user){
		userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weather:user:update")
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weather:user:delete")
    public R delete(@RequestBody Long[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
