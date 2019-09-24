package com.ruoyi.project.retire.count;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;
import com.ruoyi.project.retire.armyinfo.service.IArmyInfoService;
import com.ruoyi.project.retire.article.domain.Article;
import com.ruoyi.project.retire.article.service.IArticleService;
import com.ruoyi.project.retire.consult.domain.Consult;
import com.ruoyi.project.retire.consult.service.IConsultService;
import com.ruoyi.project.system.notice.domain.Notice;
import com.ruoyi.project.system.notice.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Duojunrui
 * @Date: 2019/9/8 18:52
 */
@RestController
@RequestMapping("/api/count")
public class AppCountController {

    @Autowired
    private IArmyInfoService armyInfoService;

    @Autowired
    private IArticleService articleService;

    @Autowired
    private IConsultService consultService;

    @Autowired
    private INoticeService noticeService;

    @PostMapping()
    public AjaxResult getRetireCount(String startYear, String endYear) {
        List list = new ArrayList();
        List retire = new ArrayList();
        List join = new ArrayList();
        int num = (Integer.parseInt(endYear)) - (Integer.parseInt(startYear));
        for (int i = 0; i < num + 1; i++) {
            Integer year = Integer.parseInt(startYear) + i;
            // 获取每年退休人数
            retire.add(armyInfoService.selectRetireCount(year));
            // 获取每年入伍人数
            join.add(armyInfoService.selectJoinCount(year));
        }

        ArmyInfo armyInfo = new ArmyInfo();
        armyInfo.setRole("管理员");
        Integer adminCount = armyInfoService.selectUserCount(armyInfo);

        armyInfo.setRole("普通用户");
        Integer armyCount = armyInfoService.selectUserCount(armyInfo);

        // 获取通知公告数据
        Integer noticeCount = noticeService.selectNoticeCount();

        // 获取政策数量
        Integer ruleCount = articleService.selectArticleCount();

        Consult consult = new Consult();
        // 咨询总量
        Integer consultCount = consultService.selectConsultCount(consult);

        // 回复总量
        consult.setReplayCheck("1");
        Integer replayCount = consultService.selectConsultCount(consult);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("joinCount",join);
        map.put("retireCount",retire);
        map.put("adminCount",adminCount);
        map.put("armyCount",armyCount);
        map.put("noticeCount",noticeCount);
        map.put("ruleCount",ruleCount);
        map.put("consultCount",consultCount);
        map.put("replayCount",replayCount);

        list.add(map);
        return AjaxResult.success(list);
    }
}
