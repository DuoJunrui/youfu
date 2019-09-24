package com.ruoyi.project.retire.armyinfo.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
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
    @Autowired
    private ArmyInfoMapper armyInfoMapper;

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
