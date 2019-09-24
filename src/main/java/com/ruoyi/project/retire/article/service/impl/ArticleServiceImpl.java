package com.ruoyi.project.retire.article.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IpUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import com.ruoyi.project.retire.article.mapper.ArticleMapper;
import com.ruoyi.project.retire.article.domain.Article;
import com.ruoyi.project.retire.article.service.IArticleService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 文章内容Service业务层处理
 *
 * @author Duojunrui
 * @date 2019-08-26
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    // 应用对外访问地址及端口
    String serverUrl = "http://200.98.201.121:1419";

    /**
     * 查询文章内容
     *
     * @param id 文章内容ID
     * @return 文章内容
     */
    @Override
    public Article selectArticleById(String id) {
        return articleMapper.selectArticleById(id);
    }

    /**
     * 查询文章内容列表
     *
     * @param article 文章内容
     * @return 文章内容
     */
    @Override
    public List<Article> selectArticleList(Article article) {
        return articleMapper.selectArticleList(article);
    }

    /**
     * 新增文章内容
     *
     * @param article 文章内容
     * @return 结果
     */
    @Override
    public int insertArticle(Article article) {

        switch (article.getType()) {
            case "1":
                article.setImgUrl(serverUrl + "/img/gongzuo.png");
                break;
            case "2":
                article.setImgUrl(serverUrl + "/img/butie.png");
                break;
            case "3":
                article.setImgUrl(serverUrl + "/img/jiuye.png");
                break;
            case "4":
                article.setImgUrl(serverUrl + "/img/chuangye.png");
                break;
            case "5":
                article.setImgUrl(serverUrl + "/img/shebao.png");
                break;
            default:
                article.setImgUrl(serverUrl + "/img/qita.png");
                break;
        }

        article.setCreateTime(DateUtils.getNowDate());

        return articleMapper.insertArticle(article);
    }

    /**
     * 修改文章内容
     *
     * @param article 文章内容
     * @return 结果
     */
    @Override
    public int updateArticle(Article article) {

        switch (article.getType()) {
            case "1":
                article.setImgUrl(serverUrl + "/img/gongzuo.png");
                break;
            case "2":
                article.setImgUrl(serverUrl + "/img/butie.png");
                break;
            case "3":
                article.setImgUrl(serverUrl + "/img/jiuye.png");
                break;
            case "4":
                article.setImgUrl(serverUrl + "/img/chuangye.png");
                break;
            case "5":
                article.setImgUrl(serverUrl + "/img/shebao.png");
                break;
            default:
                article.setImgUrl(serverUrl + "/img/qita.png");
                break;
        }

        article.setUpdateTime(DateUtils.getNowDate());

        return articleMapper.updateArticle(article);
    }

    /**
     * 删除文章内容对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteArticleByIds(String ids) {
        return articleMapper.deleteArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章内容信息
     *
     * @param id 文章内容ID
     * @return 结果
     */
    @Override
    public int deleteArticleById(String id) {
        return articleMapper.deleteArticleById(id);
    }

    @Override
    public List<Article> selectArticleAll() {
        return articleMapper.selectArticleAll();
    }

    @Override
    public int selectArticleCount() {
        return articleMapper.selectArticleCount();
    }
}
