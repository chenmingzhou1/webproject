package com.etc.Service;

import com.etc.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();
    public Article findById(Integer id);
    boolean deleteArticle(Integer id);
}
