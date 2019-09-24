package com.ruoyi.project.retire.consult.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.retire.consult.mapper.ConsultMapper;
import com.ruoyi.project.retire.consult.domain.Consult;
import com.ruoyi.project.retire.consult.service.IConsultService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 问题咨询Service业务层处理
 *
 * @author Duojunrui
 * @date 2019-08-26
 */
@Service
public class ConsultServiceImpl implements IConsultService {
    @Autowired
    private ConsultMapper consultMapper;

    /**
     * 查询问题咨询
     *
     * @param id 问题咨询ID
     * @return 问题咨询
     */
    @Override
    public Consult selectConsultById(String id) {
        return consultMapper.selectConsultById(id);
    }

    /**
     * 查询问题咨询列表
     *
     * @param consult 问题咨询
     * @return 问题咨询
     */
    @Override
    public List<Consult> selectConsultList(Consult consult) {
        return consultMapper.selectConsultList(consult);
    }

    /**
     * 新增问题咨询
     *
     * @param consult 问题咨询
     * @return 结果
     */
    @Override
    public int insertConsult(Consult consult) {
        return consultMapper.insertConsult(consult);
    }

    /**
     * 修改问题咨询
     *
     * @param consult 问题咨询
     * @return 结果
     */
    @Override
    public int updateConsult(Consult consult) {
        consult.setReplayTime(DateUtils.getNowDate());
        consult.setReplayCheck("1");
        if (consult.getReplayName()==null){
            consult.setReplayName(ShiroUtils.getSysUser().getUserName());
        }
        return consultMapper.updateConsult(consult);
    }

    /**
     * 删除问题咨询对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteConsultByIds(String ids) {
        return consultMapper.deleteConsultByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除问题咨询信息
     *
     * @param id 问题咨询ID
     * @return 结果
     */
    @Override
    public int deleteConsultById(String id) {
        return consultMapper.deleteConsultById(id);
    }

    @Override
    public List<Consult> selectConsultListByUserId(String userId) {
        return consultMapper.selectConsultListByUserId(userId);
    }

    @Override
    public int selectConsultCount(Consult consult) {
        return consultMapper.selectConsultCount(consult);
    }
}
