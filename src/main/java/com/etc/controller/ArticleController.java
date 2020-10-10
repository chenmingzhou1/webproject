package com.etc.controller;

import com.etc.Service.ArticleService;
import com.etc.entity.Article;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ArticleController {
    @Resource
    ArticleService articleService;
    @RequestMapping("/getArticle")
    public Article getArticle(Integer id){

        return articleService.findById(id);
    }
}
