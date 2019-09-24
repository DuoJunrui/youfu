package com.ruoyi.project.retire.consult.controller;

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
import com.ruoyi.project.retire.consult.domain.Consult;
import com.ruoyi.project.retire.consult.service.IConsultService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 问题咨询Controller
 *
 * @author Duojunrui
 * @date 2019-08-26
 */
@Controller
@RequestMapping("/retire/consult")
public class ConsultController extends BaseController {
    private String prefix = "retire/consult";

    @Autowired
    private IConsultService consultService;

    @RequiresPermissions("retire:consult:view")
    @GetMapping()
    public String consult() {
        return prefix + "/consult";
    }

    /**
     * 查询问题咨询列表
     */
    @RequiresPermissions("retire:consult:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Consult consult) {
        startPage();
        List<Consult> list = consultService.selectConsultList(consult);
        return getDataTable(list);
    }

    /**
     * 导出问题咨询列表
     */
    @RequiresPermissions("retire:consult:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Consult consult) {
        List<Consult> list = consultService.selectConsultList(consult);
        ExcelUtil<Consult> util = new ExcelUtil<Consult>(Consult.class);
        return util.exportExcel(list, "consult");
    }

    /**
     * 新增问题咨询
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存问题咨询
     */
    @RequiresPermissions("retire:consult:add")
    @Log(title = "问题咨询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Consult consult) {
        return toAjax(consultService.insertConsult(consult));
    }

    /**
     * 修改问题咨询
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Consult consult = consultService.selectConsultById(id);
        mmap.put("consult", consult);
        return prefix + "/edit";
    }

    /**
     * 修改保存问题咨询
     */
    @RequiresPermissions("retire:consult:edit")
    @Log(title = "问题咨询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Consult consult) {
        return toAjax(consultService.updateConsult(consult));
    }

    /**
     * 删除问题咨询
     */
    @RequiresPermissions("retire:consult:remove")
    @Log(title = "问题咨询", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(consultService.deleteConsultByIds(ids));
    }
}
