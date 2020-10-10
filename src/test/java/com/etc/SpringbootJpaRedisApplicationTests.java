package com.etc;

import com.etc.Service.ArticleService;
import com.etc.dao.ArticleDao;
import com.etc.entity.Article;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@EnableCaching
public class SpringbootJpaRedisApplicationTests {
	@Resource
	ArticleService articleService;
	Logger logger= LoggerFactory.getLogger(SpringbootJpaRedisApplicationTests.class);
//	@Test
//	void getAllArticle(){
//		List<Article> list=articleService.getAllArticle();
//		for (Article a:list
//			 ) {
//			System.out.println("标题:"+a.getArticleTitle()+"内容:"+a.getArticleContent());
//		}
//
//	}
//	@Test
//	@PerfTest(invocations = 10000,threads = 200)
//	public void context(){
//		List<Article> list=articleService.getAllArticle();
//		list.forEach(System.out::println);
//	}
	@Test
	public void context1(){
		Integer articleId=1;
		Article article=articleService.findById(articleId);
		logger.info("查询对象:"+article);
		logger.info("存放到缓存中");
		boolean flag=articleService.deleteArticle(articleId);
		logger.info("数据库删除"+flag);
		article=articleService.findById(articleId);
		logger.info("删除后查询对象"+article);


	}
}
