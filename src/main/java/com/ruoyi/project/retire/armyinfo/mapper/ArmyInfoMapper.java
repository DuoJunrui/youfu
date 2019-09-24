package com.ruoyi.project.retire.armyinfo.mapper;

import com.ruoyi.project.retire.armyinfo.domain.ArmyInfo;
import java.util.List;

/**
 * 军人信息Mapper接口
 * 
 * @author Duojunrui
 * @date 2019-08-28
 */
public interface ArmyInfoMapper 
{
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


    public ArmyInfo selectUserByAccount(String account);

    /**
     * 删除军人信息
     * 
     * @param id 军人信息ID
     * @return 结果
     */
    public int deleteArmyInfoById(String id);

    /**
     * 批量删除军人信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteArmyInfoByIds(String[] ids);

    public ArmyInfo appLogin(String tel,String password);

    public  List<ArmyInfo> getAllUserInfo();

    public  int  selectJoinCount(String startYear, String endYear);

    public  int  selectRetireCount(String startYear, String endYear);

    public int selectUserCount(ArmyInfo armyInfo);


}
