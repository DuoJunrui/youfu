package com.ruoyi.project.retire.member.mapper;

import com.ruoyi.project.retire.member.domain.Member;
import java.util.List;

/**
 * 家庭成员信息Mapper接口
 * 
 * @author Duojunrui
 * @date 2019-08-26
 */
public interface MemberMapper 
{
    /**
     * 查询家庭成员信息
     * 
     * @param id 家庭成员信息ID
     * @return 家庭成员信息
     */
    public Member selectMemberById(Long id);

    /**
     * 查询家庭成员信息列表
     * 
     * @param member 家庭成员信息
     * @return 家庭成员信息集合
     */
    public List<Member> selectMemberList(Member member);

    /**
     * 新增家庭成员信息
     * 
     * @param member 家庭成员信息
     * @return 结果
     */
    public int insertMember(Member member);

    /**
     * 修改家庭成员信息
     * 
     * @param member 家庭成员信息
     * @return 结果
     */
    public int updateMember(Member member);

    /**
     * 删除家庭成员信息
     * 
     * @param id 家庭成员信息ID
     * @return 结果
     */
    public int deleteMemberById(Long id);

    /**
     * 批量删除家庭成员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMemberByIds(String[] ids);

    public List<Member> selectMemberListByUserId(String userId);
}
