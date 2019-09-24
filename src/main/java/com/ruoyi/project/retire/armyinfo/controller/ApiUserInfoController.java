package com.ruoyi.project.retire.armyinfo.controller;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;
import com.ruoyi.project.retire.armyinfo.service.IArmyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Duojunrui
 * @Date: 2019/9/7 23:34
 */

@RestController
@RequestMapping("/api/userInfo")
public class ApiUserInfoController {

    @Autowired
    private IArmyInfoService armyInfoService;

    /**
     * 动态筛选，获取特定条件用户的所有信息
     * @return
     */
    @PostMapping()
    public AjaxResult getAllUserInfo(ArmyInfo userInfo, int pageNum, int pageSize) {
        List<ArmyInfo> result = armyInfoService.selectArmyInfoList(userInfo);

        if (pageNum<=0 || pageSize<=0 || pageNum > result.size()/pageSize){
            if (result.size()<pageSize){
                return AjaxResult.success(result);
            }
            return AjaxResult.error("输入的页数或每页显示的个数有误");
        }
        int startNum = pageSize*pageNum-pageSize;
        int endNum = pageSize*pageNum;

        result = result.subList(startNum,endNum);
        return AjaxResult.success(result);
    }
}
