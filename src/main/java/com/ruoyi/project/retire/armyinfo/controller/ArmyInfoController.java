package com.ruoyi.project.retire.armyinfo.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
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
import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;
import com.ruoyi.project.retire.armyinfo.service.IArmyInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 军人信息Controller
 *
 * @author Duojunrui
 * @date 2019-08-28
 */
@Controller
@RequestMapping("/retire/armyinfo")
public class ArmyInfoController extends BaseController {
    private String prefix = "retire/armyinfo";

    @Autowired
    private IArmyInfoService armyInfoService;

    @Autowired
    private IUserService userService;

    @RequiresPermissions("retire:armyinfo:view")
    @GetMapping()
    public String armyinfo() {
        return prefix + "/armyinfo";
    }

    /**
     * 查询军人信息列表
     */
    @RequiresPermissions("retire:armyinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ArmyInfo armyInfo) {

        String area = userService.getUserArea(ShiroUtils.getSysUser().getUserId());
        armyInfo.setArea(area);
        startPage();
        List<ArmyInfo> list = armyInfoService.selectArmyInfoList(armyInfo);
        return getDataTable(list);
    }

    /**
     * 导出军人信息列表
     */
    @RequiresPermissions("retire:armyinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ArmyInfo armyInfo) {
        List<ArmyInfo> list = armyInfoService.selectArmyInfoList(armyInfo);
        ExcelUtil<ArmyInfo> util = new ExcelUtil<ArmyInfo>(ArmyInfo.class);
        return util.exportExcel(list, "军人信息数据");
    }

    @Log(title = "军人信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("retire:armyInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ArmyInfo> util = new ExcelUtil<ArmyInfo>(ArmyInfo.class);
        List<ArmyInfo> armyList = util.importExcel(file.getInputStream());
        String message = armyInfoService.importArmyInfo(armyList, updateSupport);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("retire:armyInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<ArmyInfo> util = new ExcelUtil<ArmyInfo>(ArmyInfo.class);
        return util.importTemplateExcel("军人信息数据");
    }

    /**
     * 新增军人信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存军人信息
     */
    @RequiresPermissions("retire:armyinfo:add")
    @Log(title = "军人信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ArmyInfo armyInfo) {
        return toAjax(armyInfoService.insertArmyInfo(armyInfo));
    }

    /**
     * 修改军人信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        ArmyInfo armyInfo = armyInfoService.selectArmyInfoById(id);
        mmap.put("armyInfo", armyInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存军人信息
     */
    @RequiresPermissions("retire:armyinfo:edit")
    @Log(title = "军人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ArmyInfo armyInfo) {
        return toAjax(armyInfoService.updateArmyInfo(armyInfo));
    }

    /**
     * 删除军人信息
     */
    @RequiresPermissions("retire:armyinfo:remove")
    @Log(title = "军人信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(armyInfoService.deleteArmyInfoByIds(ids));
    }


}
