package com.ruoyi.project.system.notice.controller;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.notice.domain.Notice;
import com.ruoyi.project.system.notice.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Duojunrui
 * @Date: 2019/9/21 10:19
 */

@RestController
@RequestMapping("/api/notice")
public class ApiNoticeController {

    @Autowired
    private INoticeService noticeService;

    @GetMapping
    private AjaxResult getNoticeAll(){
        return AjaxResult.success(noticeService.selectNoticeAll());
    }

    @GetMapping("/{id}")
    private AjaxResult getNoticeById(@PathVariable Long id){
        return AjaxResult.success(noticeService.selectNoticeById(id));
    }
}
