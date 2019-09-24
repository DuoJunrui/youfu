package com.ruoyi.project.retire.armyinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 军人信息对象 app_army_info
 *
 * @author Duojunrui
 * @date 2019-08-28
 */
public class ArmyInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 军人信息表ID
     */
    private String id;

    /**
     * 账号
     */
    @Excel(name = "账号")
    private String account;

    /**
     * 账号密码
     */
    private String password;

    /**
     * 用户姓名
     */
    @Excel(name = "用户姓名")
    private String username;

    /**
     * 用户角色
     */
    @Excel(name = "用户角色")
    private String role;

    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;

    /**
     * 民族
     */
    @Excel(name = "民族")
    private String nation;

    /**
     * 出生日期
     */
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String idCard;

    /**
     * 户籍地
     */
    @Excel(name = "户籍地")
    private String nativePlace;

    /**
     * 人员类别
     */
    @Excel(name = "人员类别")
    private String userType;

    /**
     * 政治面貌
     */
    @Excel(name = "政治面貌")
    private String politicsStatus;

    /**
     * 文化程度
     */
    @Excel(name = "文化程度")
    private String degreeOfEducation;

    /**
     * 家庭住址
     */
    @Excel(name = "家庭住址")
    private String address;

    /**
     * 户籍类别
     */
    @Excel(name = "户籍类别")
    private String householdType;

    /**
     * 婚姻状况
     */
    @Excel(name = "婚姻状况")
    private String maritalStatus;

    /**
     * 固定电话
     */
    @Excel(name = "固定电话")
    private String phone;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    private String telephone;

    /**
     * QQ号码
     */
    @Excel(name = "QQ号码")
    private String qqNum;

    /**
     * 就业状态
     */
    @Excel(name = "就业状态")
    private String workStatus;

    /**
     * 是否悬挂光荣牌
     */
    @Excel(name = "是否悬挂光荣牌")
    private String slavaStatus;

    /**
     * 申请悬挂光荣牌时间
     */
    @Excel(name = "申请悬挂光荣牌时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applySlavaTime;

    /**
     * 悬挂光荣牌时间
     */
    @Excel(name = "悬挂光荣牌时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hangSlavaTime;

    /**
     * 个人年收入
     */
    @Excel(name = "个人年收入")
    private String userIncome;

    /**
     * 现工作单位
     */
    @Excel(name = "现工作单位")
    private String workDept;

    /**
     * 现单位性质
     */
    @Excel(name = "现单位性质")
    private String deprType;

    /**
     * 医疗保险
     */
    @Excel(name = "医疗保险")
    private String medicare;

    /**
     * 养老保险
     */
    @Excel(name = "养老保险")
    private String annuity;

    /**
     * 住房公积金
     */
    @Excel(name = "住房公积金")
    private String accumulation;

    /**
     * 国家抚恤补助金
     */
    @Excel(name = "国家抚恤补助金")
    private String grant;

    /**
     * 残疾人两项补贴
     */
    @Excel(name = "残疾人两项补贴")
    private String disabled;

    /**
     * 住房状况
     */
    @Excel(name = "住房状况")
    private String houseStatus;

    /**
     * 社会救助状况
     */
    @Excel(name = "社会救助状况")
    private String assistance;

    /**
     * 信息采集单位
     */
    @Excel(name = "信息采集单位")
    private String gatherDept;

    /**
     * 信息采集人员
     */
    @Excel(name = "信息采集人员")
    private String gatherUser;

    /**
     * 入伍时间
     */
    @Excel(name = "入伍时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date militaryTime;

    /**
     * 退役或离退休时间
     */
    @Excel(name = "退役或离退休时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date retiredTime;

    /**
     * 服役集团军/部队代号
     */
    @Excel(name = "服役集团军/部队代号")
    private String troopsName;

    /**
     * 入伍时户籍性质
     */
    @Excel(name = "入伍时户籍性质")
    private String militaryNation;

    /**
     * 退役(退休或复员)证件号
     */
    @Excel(name = "退役(退休或复员)证件号")
    private String certificateNumber;

    /**
     * 照片
     */
    @Excel(name = "照片")
    private String photo;

    /**
     * 照片
     */
    @Excel(name = "行政区划")
    private String area;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public String getDegreeOfEducation() {
        return degreeOfEducation;
    }

    public void setDegreeOfEducation(String degreeOfEducation) {
        this.degreeOfEducation = degreeOfEducation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getSlavaStatus() {
        return slavaStatus;
    }

    public void setSlavaStatus(String slavaStatus) {
        this.slavaStatus = slavaStatus;
    }

    public Date getApplySlavaTime() {
        return applySlavaTime;
    }

    public void setApplySlavaTime(Date applySlavaTime) {
        this.applySlavaTime = applySlavaTime;
    }

    public Date getHangSlavaTime() {
        return hangSlavaTime;
    }

    public void setHangSlavaTime(Date hangSlavaTime) {
        this.hangSlavaTime = hangSlavaTime;
    }

    public String getUserIncome() {
        return userIncome;
    }

    public void setUserIncome(String userIncome) {
        this.userIncome = userIncome;
    }

    public String getWorkDept() {
        return workDept;
    }

    public void setWorkDept(String workDept) {
        this.workDept = workDept;
    }

    public String getDeprType() {
        return deprType;
    }

    public void setDeprType(String deprType) {
        this.deprType = deprType;
    }

    public String getMedicare() {
        return medicare;
    }

    public void setMedicare(String medicare) {
        this.medicare = medicare;
    }

    public String getAnnuity() {
        return annuity;
    }

    public void setAnnuity(String annuity) {
        this.annuity = annuity;
    }

    public String getAccumulation() {
        return accumulation;
    }

    public void setAccumulation(String accumulation) {
        this.accumulation = accumulation;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getAssistance() {
        return assistance;
    }

    public void setAssistance(String assistance) {
        this.assistance = assistance;
    }

    public String getGatherDept() {
        return gatherDept;
    }

    public void setGatherDept(String gatherDept) {
        this.gatherDept = gatherDept;
    }

    public String getGatherUser() {
        return gatherUser;
    }

    public void setGatherUser(String gatherUser) {
        this.gatherUser = gatherUser;
    }

    public Date getMilitaryTime() {
        return militaryTime;
    }

    public void setMilitaryTime(Date militaryTime) {
        this.militaryTime = militaryTime;
    }

    public Date getRetiredTime() {
        return retiredTime;
    }

    public void setRetiredTime(Date retiredTime) {
        this.retiredTime = retiredTime;
    }

    public String getTroopsName() {
        return troopsName;
    }

    public void setTroopsName(String troopsName) {
        this.troopsName = troopsName;
    }

    public String getMilitaryNation() {
        return militaryNation;
    }

    public void setMilitaryNation(String militaryNation) {
        this.militaryNation = militaryNation;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ArmyInfo{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", userType='" + userType + '\'' +
                ", politicsStatus='" + politicsStatus + '\'' +
                ", degreeOfEducation='" + degreeOfEducation + '\'' +
                ", address='" + address + '\'' +
                ", householdType='" + householdType + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", phone='" + phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", qqNum='" + qqNum + '\'' +
                ", workStatus='" + workStatus + '\'' +
                ", slavaStatus='" + slavaStatus + '\'' +
                ", applySlavaTime=" + applySlavaTime +
                ", hangSlavaTime=" + hangSlavaTime +
                ", userIncome='" + userIncome + '\'' +
                ", workDept='" + workDept + '\'' +
                ", deprType='" + deprType + '\'' +
                ", medicare='" + medicare + '\'' +
                ", annuity='" + annuity + '\'' +
                ", accumulation='" + accumulation + '\'' +
                ", grant='" + grant + '\'' +
                ", disabled='" + disabled + '\'' +
                ", houseStatus='" + houseStatus + '\'' +
                ", assistance='" + assistance + '\'' +
                ", gatherDept='" + gatherDept + '\'' +
                ", gatherUser='" + gatherUser + '\'' +
                ", militaryTime=" + militaryTime +
                ", retiredTime=" + retiredTime +
                ", troopsName='" + troopsName + '\'' +
                ", militaryNation='" + militaryNation + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", photo='" + photo + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
