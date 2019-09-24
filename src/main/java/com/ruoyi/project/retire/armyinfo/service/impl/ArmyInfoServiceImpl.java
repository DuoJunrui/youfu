package com.ruoyi.project.retire.armyinfo.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.config.service.IConfigService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.retire.armyinfo.mapper.ArmyInfoMapper;
import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;
import com.ruoyi.project.retire.armyinfo.service.IArmyInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 军人信息Service业务层处理
 *
 * @author Duojunrui
 * @date 2019-08-28
 */
@Service
public class ArmyInfoServiceImpl implements IArmyInfoService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ArmyInfoMapper armyInfoMapper;

    @Autowired
    private IConfigService configService;

    @Override
    public String importArmyInfo(List<ArmyInfo> armyInfoList, Boolean isUpdateSupport) {

            if (StringUtils.isNull(armyInfoList) || armyInfoList.size() == 0) {
                throw new BusinessException("导入用户数据不能为空！");
            }
            int successNum = 0;
            int failureNum = 0;
            StringBuilder successMsg = new StringBuilder();
            StringBuilder failureMsg = new StringBuilder();
            String operName = ShiroUtils.getLoginName();
            String password = configService.selectConfigByKey("sys.user.initPassword");
            for (ArmyInfo armyInfo : armyInfoList) {
                try {
                    // 验证是否存在这个用户
                    ArmyInfo army = armyInfoMapper.selectUserByAccount(armyInfo.getAccount());
                    if (StringUtils.isNull(army)) {
                        armyInfo.setPassword(password);
                        armyInfo.setCreateTime(DateUtils.getNowDate());
                        this.insertArmyInfo(armyInfo);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、账号 " + armyInfo.getAccount() + " 导入成功");
                    } else if (isUpdateSupport) {
                        armyInfo.setUpdateTime(DateUtils.getNowDate());
                        this.updateArmyInfo(armyInfo);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、账号 " + armyInfo.getAccount() + " 更新成功");
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、账号 " + armyInfo.getAccount() + " 已存在");
                    }
                } catch (Exception e) {
                    failureNum++;
                    String msg = "<br/>" + failureNum + "、账号 " + armyInfo.getAccount() + " 导入失败：";
                    failureMsg.append(msg + e.getMessage());
                    log.error(msg, e);
                }
            }
            if (failureNum > 0) {
                failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
                throw new BusinessException(failureMsg.toString());
            } else {
                successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
            }
            return successMsg.toString();

    }

    /**
     * 查询军人信息
     *
     * @param id 军人信息ID
     * @return 军人信息
     */
    @Override
    public ArmyInfo selectArmyInfoById(String id) {
        return armyInfoMapper.selectArmyInfoById(id);
    }

    /**
     * 查询军人信息列表
     *
     * @param armyInfo 军人信息
     * @return 军人信息
     */
    @Override
    public List<ArmyInfo> selectArmyInfoList(ArmyInfo armyInfo) {
        return armyInfoMapper.selectArmyInfoList(armyInfo);
    }

    /**
     * 新增军人信息
     *
     * @param armyInfo 军人信息
     * @return 结果
     */
    @Override
    public int insertArmyInfo(ArmyInfo armyInfo) {
        armyInfo.setCreateTime(DateUtils.getNowDate());
        return armyInfoMapper.insertArmyInfo(armyInfo);
    }

    /**
     * 修改军人信息
     *
     * @param armyInfo 军人信息
     * @return 结果
     */
    @Override
    public int updateArmyInfo(ArmyInfo armyInfo) {
        armyInfo.setUpdateTime(DateUtils.getNowDate());
        return armyInfoMapper.updateArmyInfo(armyInfo);
    }

    /**
     * 删除军人信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteArmyInfoByIds(String ids) {
        return armyInfoMapper.deleteArmyInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除军人信息信息
     *
     * @param id 军人信息ID
     * @return 结果
     */
    @Override
    public int deleteArmyInfoById(String id) {
        return armyInfoMapper.deleteArmyInfoById(id);
    }

    @Override
    public ArmyInfo appLogin(String tel, String password) {
        return armyInfoMapper.appLogin(tel, password);
    }

    @Override
    public List<ArmyInfo> getAllUserInfo() {
        return armyInfoMapper.getAllUserInfo();
    }

    @Override
    public int selectRetireCount(Integer year) {
        String startYear = year+ "-01-01";
        String endYear = year+ "-12-31";

        return armyInfoMapper.selectRetireCount(startYear,endYear);
    }

    @Override
    public int selectJoinCount(Integer year) {
        String startYear = year+ "-01-01";
        String endYear = year+ "-12-31";

        return armyInfoMapper.selectJoinCount(startYear,endYear);
    }

    @Override
    public int selectUserCount(ArmyInfo armyInfo){
        return armyInfoMapper.selectUserCount(armyInfo);
    }
}
