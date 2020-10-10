package com.etc.Service.impl;

import com.etc.Service.ArticleService;
import com.etc.dao.ArticleDao;
import com.etc.entity.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleDao articleDao;
    Logger logger= LoggerFactory.getLogger(ArticleServiceImpl.class);
    @Override
    @Cacheable(value = "getAllArticle")
    public List<Article> getAllArticle() {
        logger.info("第一次实现,将值存入缓存");
        return articleDao.findAll();
    }

    @Override
    @Cacheable(value = "findById",key = "#articleId")
    public Article findById(Integer articleId) {
         Article article=null;
        Optional<Article> option=articleDao.findById(articleId);
         if (option.isPresent()){
             article=option.get();
         }
        return article;
    }

    @Override
    @CacheEvict(value = "findById",key = "#articleId")
    public boolean deleteArticle(Integer articleId) {
        boolean flag=false;
        Optional<Article> option=articleDao.findById(articleId);
        Article article=null;
        if(option.isPresent()){
            articleDao.deleteById(articleId);
            flag=true;
            flag=true;
        }
        return flag;
    }
}
