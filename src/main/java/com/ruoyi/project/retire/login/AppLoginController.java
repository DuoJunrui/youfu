package com.ruoyi.project.retire.login;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;
import com.ruoyi.project.retire.armyinfo.service.IArmyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/25 14:49
 */
@RestController
@RequestMapping("/api/appLogin")
public class AppLoginController {

    @Autowired
    private IArmyInfoService armyInfoService;

    @PostMapping()
    public AjaxResult AppLogin(String telephone, String password) {

        ArmyInfo info = armyInfoService.appLogin(telephone, password);
        if (info == null) {
            return AjaxResult.error("电话号码或密码错误");
        }

        return AjaxResult.success(info);
    }

    @PostMapping("/autoLogin")
    public AjaxResult checkUserId(String id) {
        ArmyInfo info = armyInfoService.selectArmyInfoById(id);
        if (info == null) {
            return AjaxResult.error("当前用户不存在");
        }
        return AjaxResult.success("该用户已登录");
    }
}
