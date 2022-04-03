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

import io.renren.modules.weather.entity.UserRoleEntity;
import io.renren.modules.weather.service.UserRoleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户身份表
 *
 * @author zhangsj
 * @email 1836635554@gmail.com
 * @date 2022-03-22 14:07:03
 */
@RestController
@RequestMapping("weather/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("weather:userrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uid}")
    @RequiresPermissions("weather:userrole:info")
    public R info(@PathVariable("uid") Long uid){
		UserRoleEntity userRole = userRoleService.getById(uid);

        return R.ok().put("userRole", userRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("weather:userrole:save")
    public R save(@RequestBody UserRoleEntity userRole){
		userRoleService.save(userRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("weather:userrole:update")
    public R update(@RequestBody UserRoleEntity userRole){
		userRoleService.updateById(userRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("weather:userrole:delete")
    public R delete(@RequestBody Long[] uids){
		userRoleService.removeByIds(Arrays.asList(uids));

        return R.ok();
    }

}
