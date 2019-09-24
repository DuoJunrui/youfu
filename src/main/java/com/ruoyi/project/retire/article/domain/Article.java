package com.ruoyi.project.retire.article.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 文章内容对象 app_article
 * 
 * @author Duojunrui
 * @date 2019-08-26
 */
public class Article extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章表ID */
    private String id;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 内容类型(通知公告、社保政策) */
    @Excel(name = "内容类型(通知公告、社保政策)")
    private String type;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 发布状态 */
    @Excel(name = "发布状态")
    private String published;

    /** 附件路径 */
    @Excel(name = "附件路径")
    private String accessory;

    // 首图地址
    private String imgUrl;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPublished(String published)
    {
        this.published = published;
    }

    public String getPublished()
    {
        return published;
    }
    public void setAccessory(String accessory) 
    {
        this.accessory = accessory;
    }

    public String getAccessory() 
    {
        return accessory;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", published='" + published + '\'' +
                ", accessory='" + accessory + '\'' +
                '}';
    }
}
