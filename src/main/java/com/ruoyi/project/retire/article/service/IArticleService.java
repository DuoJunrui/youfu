package com.ruoyi.project.retire.article.service;

import com.ruoyi.project.retire.article.domain.Article;
import java.util.List;

/**
 * 文章内容Service接口
 * 
 * @author Duojunrui
 * @date 2019-08-26
 */
public interface IArticleService 
{
    /**
     * 查询文章内容
     * 
     * @param id 文章内容ID
     * @return 文章内容
     */
    public Article selectArticleById(String id);

    /**
     * 查询文章内容列表
     * 
     * @param article 文章内容
     * @return 文章内容集合
     */
    public List<Article> selectArticleList(Article article);

    /**
     * 新增文章内容
     * 
     * @param article 文章内容
     * @return 结果
     */
    public int insertArticle(Article article);

    /**
     * 修改文章内容
     * 
     * @param article 文章内容
     * @return 结果
     */
    public int updateArticle(Article article);

    /**
     * 批量删除文章内容
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteArticleByIds(String ids);

    /**
     * 删除文章内容信息
     * 
     * @param id 文章内容ID
     * @return 结果
     */
    public int deleteArticleById(String id);

    /**
     * 查询所有文章
     * @return
     */
    public List<Article> selectArticleAll();

    public int selectArticleCount();
}
