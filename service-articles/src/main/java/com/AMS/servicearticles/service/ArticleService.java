package com.AMS.servicearticles.service;

import com.AMS.servicearticles.model.Articles;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.util.List;
import java.util.Optional;

@Service
public interface ArticleService {
    //public JSONObject findAll();
    public List<Articles> findAll();
    public Optional<Articles> getArticleById(Long Id);
    public Articles createArticle(Articles articleData);
    public Articles updateArticle(Long Id, Articles updatedArticleData);
    public void deleteArticle(Long Id);
}
