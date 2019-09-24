package com.ruoyi.project.retire.consult.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.retire.armyinfo.service.IArmyInfoService;
import com.ruoyi.project.retire.consult.domain.Consult;
import com.ruoyi.project.retire.consult.service.IConsultService;
import jdk.nashorn.api.scripting.AbstractJSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/26 16:22
 */
@RestController
@RequestMapping("/api/consult")
public class ApiConsultController extends BaseController {

    @Autowired
    private IConsultService consultService;

    @Autowired
    private IArmyInfoService armyInfoService;

    /**
     * app端用户添加咨询问题
     *
     * @param userId
     * @param title
     * @param content
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addConsult(String userId, String title, String content) {
        Consult consult = new Consult();
        consult.setConsultTitle(title);
        consult.setConsultContent(content);
        consult.setConsultTime(DateUtils.getNowDate());
        consult.setConsultUserId(userId);
        consult.setConsultName(armyInfoService.selectArmyInfoById(userId).getUsername());
        consult.setReplayCheck("0");
        return AjaxResult.success(consultService.insertConsult(consult));
    }

    /**
     * 根据用户id获取咨询列表
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public AjaxResult showConsultByUserId(@PathVariable String userId) {
        return AjaxResult.success(consultService.selectConsultListByUserId(userId));
    }


    /**
     * 根据信息id回复咨询信息
     *  id, replay_content, replay_name
     * @return
     */
    @PostMapping("/update")
    public AjaxResult updateConsult(Consult consult){
        return AjaxResult.success(consultService.updateConsult(consult));
    }

    /**
     * 根据信息id获取咨询详情
     *
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public AjaxResult selectConsultByID(@PathVariable String id){
        return AjaxResult.success(consultService.selectConsultById(id));
    }

    /**
     * 获取所有咨询信息
     * @param consult
     * @return
     */
    @GetMapping()
    public AjaxResult getConsultAll(Consult consult){
        return AjaxResult.success(consultService.selectConsultList(consult));
    }



}
