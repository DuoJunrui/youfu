package com.ruoyi.project.retire.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.retire.member.mapper.MemberMapper;
import com.ruoyi.project.retire.member.domain.Member;
import com.ruoyi.project.retire.member.service.IMemberService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 家庭成员信息Service业务层处理
 * 
 * @author Duojunrui
 * @date 2019-08-26
 */
@Service
public class MemberServiceImpl implements IMemberService 
{
    @Autowired
    private MemberMapper memberMapper;

    /**
     * 查询家庭成员信息
     * 
     * @param id 家庭成员信息ID
     * @return 家庭成员信息
     */
    @Override
    public Member selectMemberById(Long id)
    {
        return memberMapper.selectMemberById(id);
    }

    /**
     * 查询家庭成员信息列表
     * 
     * @param member 家庭成员信息
     * @return 家庭成员信息
     */
    @Override
    public List<Member> selectMemberList(Member member)
    {
        return memberMapper.selectMemberList(member);
    }

    /**
     * 新增家庭成员信息
     * 
     * @param member 家庭成员信息
     * @return 结果
     */
    @Override
    public int insertMember(Member member)
    {
        return memberMapper.insertMember(member);
    }

    /**
     * 修改家庭成员信息
     * 
     * @param member 家庭成员信息
     * @return 结果
     */
    @Override
    public int updateMember(Member member)
    {
        return memberMapper.updateMember(member);
    }

    /**
     * 删除家庭成员信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMemberByIds(String ids)
    {
        return memberMapper.deleteMemberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除家庭成员信息信息
     * 
     * @param id 家庭成员信息ID
     * @return 结果
     */
    @Override
    public int deleteMemberById(Long id)
    {
        return memberMapper.deleteMemberById(id);
    }

    @Override
    public List<Member> selectMemberListByUserId(String userId) {
        return memberMapper.selectMemberListByUserId(userId);
    }
}
