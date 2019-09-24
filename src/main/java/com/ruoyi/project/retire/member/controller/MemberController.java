package com.ruoyi.project.retire.member.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.retire.member.domain.Member;
import com.ruoyi.project.retire.member.service.IMemberService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 家庭成员信息Controller
 * 
 * @author Duojunrui
 * @date 2019-08-26
 */
@Controller
@RequestMapping("/retire/member")
public class MemberController extends BaseController
{
    private String prefix = "retire/member";

    @Autowired
    private IMemberService memberService;

    @RequiresPermissions("retire:member:view")
    @GetMapping()
    public String member()
    {
        return prefix + "/member";
    }

    /**
     * 查询家庭成员信息列表
     */
    @RequiresPermissions("retire:member:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Member member)
    {
        startPage();
        List<Member> list = memberService.selectMemberList(member);
        return getDataTable(list);
    }

    /**
     * 导出家庭成员信息列表
     */
    @RequiresPermissions("retire:member:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Member member)
    {
        List<Member> list = memberService.selectMemberList(member);
        ExcelUtil<Member> util = new ExcelUtil<Member>(Member.class);
        return util.exportExcel(list, "member");
    }

    /**
     * 新增家庭成员信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存家庭成员信息
     */
    @RequiresPermissions("retire:member:add")
    @Log(title = "家庭成员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Member member)
    {
        return toAjax(memberService.insertMember(member));
    }

    /**
     * 修改家庭成员信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Member member = memberService.selectMemberById(id);
        mmap.put("member", member);
        return prefix + "/edit";
    }

    /**
     * 修改保存家庭成员信息
     */
    @RequiresPermissions("retire:member:edit")
    @Log(title = "家庭成员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Member member)
    {
        return toAjax(memberService.updateMember(member));
    }

    /**
     * 删除家庭成员信息
     */
    @RequiresPermissions("retire:member:remove")
    @Log(title = "家庭成员信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(memberService.deleteMemberByIds(ids));
    }
}
