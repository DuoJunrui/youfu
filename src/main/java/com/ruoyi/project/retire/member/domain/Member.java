package com.ruoyi.project.retire.member.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 家庭成员信息对象 app_member
 * 
 * @author Duojunrui
 * @date 2019-08-26
 */
public class Member extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 家庭成员表id */
    private Long id;

    /** 成员姓名 */
    @Excel(name = "成员姓名")
    private String name;

    /** 职业 */
    @Excel(name = "职业")
    private String profession;

    /** 关系 */
    @Excel(name = "关系")
    private String relation;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String telephone;

    /** 工作地点 */
    @Excel(name = "工作地点")
    private String workAddress;

    /** 关联军人信息表ID */
    private Long armyInfoId;

    private Date birth;

    private String IdCard;

    private String nation;

    private String education;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setProfession(String profession) 
    {
        this.profession = profession;
    }

    public String getProfession() 
    {
        return profession;
    }
    public void setRelation(String relation) 
    {
        this.relation = relation;
    }

    public String getRelation() 
    {
        return relation;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setWorkAddress(String workAddress) 
    {
        this.workAddress = workAddress;
    }

    public String getWorkAddress() 
    {
        return workAddress;
    }
    public void setArmyInfoId(Long armyInfoId) 
    {
        this.armyInfoId = armyInfoId;
    }

    public Long getArmyInfoId() 
    {
        return armyInfoId;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", relation='" + relation + '\'' +
                ", sex=" + sex +
                ", telephone='" + telephone + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", armyInfoId=" + armyInfoId +
                ", birth=" + birth +
                ", IdCard='" + IdCard + '\'' +
                ", nation='" + nation + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
