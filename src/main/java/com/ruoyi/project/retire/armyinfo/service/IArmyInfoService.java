package com.ruoyi.project.retire.armyinfo.service;

import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;

import java.util.List;

/**
 * 军人信息Service接口
 *
 * @author Duojunrui
 * @date 2019-08-28
 */
public interface IArmyInfoService {

    /**
     * 导入用户数据
     *
     * @param armyInfoList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     * */
    public String importArmyInfo(List<ArmyInfo> armyInfoList, Boolean isUpdateSupport);


    /**
     * 查询军人信息
     *
     * @param id 军人信息ID
     * @return 军人信息
     */
    public ArmyInfo selectArmyInfoById(String id);

    /**
     * 查询军人信息列表
     *
     * @param armyInfo 军人信息
     * @return 军人信息集合
     */
    public List<ArmyInfo> selectArmyInfoList(ArmyInfo armyInfo);

    /**
     * 新增军人信息
     *
     * @param armyInfo 军人信息
     * @return 结果
     */
    public int insertArmyInfo(ArmyInfo armyInfo);

    /**
     * 修改军人信息
     *
     * @param armyInfo 军人信息
     * @return 结果
     */
    public int updateArmyInfo(ArmyInfo armyInfo);

    /**
     * 批量删除军人信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteArmyInfoByIds(String ids);

    /**
     * 删除军人信息信息
     *
     * @param id 军人信息ID
     * @return 结果
     */
    public int deleteArmyInfoById(String id);

    public ArmyInfo appLogin(String tel, String password);

    public List<ArmyInfo> getAllUserInfo();

    public int selectRetireCount(Integer year);

    public int selectJoinCount(Integer year);

    public int selectUserCount(ArmyInfo armyInfo);

}
