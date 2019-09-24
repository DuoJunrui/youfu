package com.ruoyi.project.retire.member.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;
import com.ruoyi.project.retire.member.domain.Member;
import com.ruoyi.project.retire.member.service.IMemberService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/26 17:31
 */
@RestController
@RequestMapping("/api/member")
public class ApiMemberController extends BaseController {

    @Autowired
    private IMemberService memberService;

    /**
     * 根据用户id获取家庭成员
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public AjaxResult getMemberListByUserId(@PathVariable String userId) {
        List<Member> members = memberService.selectMemberListByUserId(userId);
        if (members.size() == 0) {
            return success("该用户暂无家庭成员信息");
        }
        return AjaxResult.success(members);
    }

    @PostMapping("/update")
    public AjaxResult updateMemberInfo(Member member) {
        if (StringUtils.isNull(member) || StringUtils.isNull(member.getId())) {
            return AjaxResult.error("家庭成员ID不能为空");
        }
        Member count = memberService.selectMemberById(member.getId());
        if (count == null || !count.getArmyInfoId().equals(member.getArmyInfoId())) {
            return error("无此家庭成员信息/军人ID错误");
        }
        return AjaxResult.success("修改成功", memberService.updateMember(member));
    }

    @GetMapping("/detail/{id}")
    public AjaxResult getMemberListById(@PathVariable Long id) {
        return AjaxResult.success(memberService.selectMemberById(id));
    }

    @PostMapping("/add")
    public AjaxResult addMemberByArmyId(Member member) {
        if (member.getArmyInfoId() == null || "".equals(member.getArmyInfoId())) {
            return AjaxResult.error("请传入绑定军人的armyInfoId");
        }
        if (member.getName() == null || member.getSex() == null || member.getRelation() == null) {
            return AjaxResult.error("家庭成员基础数据不完整，请填写完整！");
        }
        return AjaxResult.success(memberService.insertMember(member));
    }

}
