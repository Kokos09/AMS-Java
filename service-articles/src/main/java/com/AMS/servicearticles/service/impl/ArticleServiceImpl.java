package com.AMS.servicearticles.service.impl;

import com.AMS.servicearticles.model.Articles;
import com.AMS.servicearticles.repository.ArticleRepository;
import com.AMS.servicearticles.service.ArticleService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository repository;
    /*
    @Override
    public JSONObject findAll() {
        JSONObject resp=new JSONObject();
        resp.put("data",repository.findAll());
        resp.put("code", HttpStatus.OK);
        return resp;
    }*/
    public List<Articles> findAll() {
        return (List<Articles>) repository.findAll();
    }
    @Override
    public Optional<Articles> getArticleById(Long Id) {
        Optional<Articles> articleOptional = repository.findById(Id);
        return articleOptional;
    }

    @Override
    public Articles createArticle(Articles articleData) {
        Articles newArtircle = new Articles();
        newArtircle.setContent(articleData.getContent());
        newArtircle.setPrice(articleData.getPrice());
        newArtircle.setTitle(articleData.getTitle());
        newArtircle.setQuantity(articleData.getQuantity());
        Articles savedArticle = repository.saveAndFlush(newArtircle);
        return savedArticle;
    }

    @Override
    public Articles updateArticle(Long Id, Articles updatedArticleData) {
        Optional<Articles> existingArticleOptional = repository.findById(Id);
        if (existingArticleOptional.isPresent()) {
            Articles existingArticle = existingArticleOptional.get();
            existingArticle.setContent(updatedArticleData.getContent());
            existingArticle.setPrice(updatedArticleData.getPrice());
            existingArticle.setTitle(updatedArticleData.getTitle());
            existingArticle.setQuantity(updatedArticleData.getQuantity());
            Articles updatedUser = repository.save(existingArticle);
            return updatedUser;
        } else {
            return null;
        }
    }

    @Override
    public void deleteArticle(Long Id) {
        repository.deleteById(Id);
    }
}
