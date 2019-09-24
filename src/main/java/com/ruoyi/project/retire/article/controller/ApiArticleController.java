package com.ruoyi.project.retire.article.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.retire.article.domain.Article;
import com.ruoyi.project.retire.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/26 9:19
 */
@RestController
@RequestMapping("/api/article")
public class ApiArticleController extends BaseController {

    @Autowired
    private IArticleService articleService;

    /**
     * 获取所有文章详细信息
     * @return
     */
    @GetMapping()
    public AjaxResult getArticleAll(){
        return AjaxResult.success(articleService.selectArticleAll());
    }

    @GetMapping("/{id}")
    public AjaxResult getArticleById(@PathVariable String id){
        return AjaxResult.success(articleService.selectArticleById(id));
    }
}
