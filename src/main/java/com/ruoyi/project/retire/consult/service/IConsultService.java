package com.ruoyi.project.retire.consult.service;

import com.ruoyi.project.retire.consult.domain.Consult;
import java.util.List;

/**
 * 问题咨询Service接口
 * 
 * @author Duojunrui
 * @date 2019-08-26
 */
public interface IConsultService 
{
    /**
     * 查询问题咨询
     * 
     * @param id 问题咨询ID
     * @return 问题咨询
     */
    public Consult selectConsultById(String id);

    /**
     * 查询问题咨询列表
     * 
     * @param consult 问题咨询
     * @return 问题咨询集合
     */
    public List<Consult> selectConsultList(Consult consult);

    /**
     * 新增问题咨询
     * 
     * @param consult 问题咨询
     * @return 结果
     */
    public int insertConsult(Consult consult);

    /**
     * 修改问题咨询
     * 
     * @param consult 问题咨询
     * @return 结果
     */
    public int updateConsult(Consult consult);

    /**
     * 批量删除问题咨询
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteConsultByIds(String ids);

    /**
     * 删除问题咨询信息
     * 
     * @param id 问题咨询ID
     * @return 结果
     */
    public int deleteConsultById(String id);

    /**
     * 根据用户id搜索咨询列表
     * @param userId
     * @return
     */
    public List<Consult> selectConsultListByUserId(String userId);

    public int selectConsultCount(Consult consult);
}
