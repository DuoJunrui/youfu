package com.ruoyi.project.retire.consult.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 问题咨询对象 app_consult
 *
 * @author Duojunrui
 * @date 2019-08-26
 */
public class Consult extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 咨询信息表ID
     */
    private String id;

    /**
     * 咨询内容
     */
    @Excel(name = "咨询内容")
    private String consultContent;

    /**
     * 咨询者ID
     */
    private String consultUserId;

    /**
     * 咨询者姓名
     */
    @Excel(name = "咨询者姓名")
    private String consultName;

    /**
     * 咨询时间
     */
    @Excel(name = "咨询时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date consultTime;

    /**
     * 咨询标题
     */
    @Excel(name = "咨询标题")
    private String consultTitle;

    /**
     * 是否回复
     */
    @Excel(name = "是否回复")
    private String replayCheck;

    /**
     * 回复内容
     */
    @Excel(name = "回复内容")
    private String replayContent;

    /**
     * 回复者姓名
     */
    @Excel(name = "回复者姓名")
    private String replayName;

    /**
     * 回复时间
     */
    @Excel(name = "回复时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date replayTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setConsultContent(String consultContent) {
        this.consultContent = consultContent;
    }

    public String getConsultContent() {
        return consultContent;
    }

    public void setConsultUserId(String consultUserId) {
        this.consultUserId = consultUserId;
    }

    public String getConsultUserId() {
        return consultUserId;
    }

    public void setConsultName(String consultName) {
        this.consultName = consultName;
    }

    public String getConsultName() {
        return consultName;
    }

    public void setConsultTime(Date consultTime) {
        this.consultTime = consultTime;
    }

    public Date getConsultTime() {
        return consultTime;
    }

    public void setConsultTitle(String consultTitle) {
        this.consultTitle = consultTitle;
    }

    public String getConsultTitle() {
        return consultTitle;
    }

    public void setReplayCheck(String replayCheck) {
        this.replayCheck = replayCheck;
    }

    public String getReplayCheck() {
        return replayCheck;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayName(String replayName) {
        this.replayName = replayName;
    }

    public String getReplayName() {
        return replayName;
    }

    public void setReplayTime(Date replayTime) {
        this.replayTime = replayTime;
    }

    public Date getReplayTime() {
        return replayTime;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "id=" + id +
                ", consultContent='" + consultContent + '\'' +
                ", consultUserId='" + consultUserId + '\'' +
                ", consultName='" + consultName + '\'' +
                ", consultTime=" + consultTime +
                ", consultTitle='" + consultTitle + '\'' +
                ", replayCheck='" + replayCheck + '\'' +
                ", replayContent='" + replayContent + '\'' +
                ", replayName='" + replayName + '\'' +
                ", replayTime=" + replayTime +
                '}';
    }
}
