package com.ruoyi.project.retire.armyinfo.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;
import com.ruoyi.project.retire.armyinfo.service.IArmyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/26 15:08
 */
@RestController
@RequestMapping("/api/armyInfo")
public class ApiArmyInfoController extends BaseController {

    @Autowired
    private IArmyInfoService armyInfoService;

    /**
     * 根据id获取军人信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public AjaxResult getArmyInfoById(@PathVariable String id){
        return AjaxResult.success(armyInfoService.selectArmyInfoById(id));
    }

    /**
     * 根据id修改军人信息
     * @param armyInfo
     * @return
     */
    @PostMapping("/update")
    public AjaxResult updateArmyInfoById(ArmyInfo armyInfo){
        if (StringUtils.isNull(armyInfo) || StringUtils.isNull(armyInfo.getId())) {
            return error("用户ID不能为空");
        }
        ArmyInfo count = armyInfoService.selectArmyInfoById(armyInfo.getId());
        if (count==null){
            return error("无此用户信息，修改失败");
        }
        return AjaxResult.success("修改成功",armyInfoService.updateArmyInfo(armyInfo));
    }

}
