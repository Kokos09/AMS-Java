package com.AMS.servicearticles.controller;

import com.AMS.servicearticles.model.Articles;
import com.AMS.servicearticles.service.ArticleService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArticleController {
    @Autowired
    private ArticleService service;
    /*
    @GetMapping("/list")
    public ResponseEntity<String> getAllArticles() {
        JSONObject resp = service.findAll();
        return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
    }*/
    @GetMapping("/list")
    public ResponseEntity<List<Articles>> getAllUsers() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find-article/{articleId}")
    public ResponseEntity<Articles> getArticleById(@PathVariable Long articleId) {
        return service.getArticleById(articleId)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Articles> createArticle(@RequestBody Articles articleData) {
        Articles createdArticle = service.createArticle(articleData);
        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    @PutMapping("/update/{articleId}")
    public ResponseEntity<Articles> updateArticle(@PathVariable Long articleId, @RequestBody Articles updatedArticleData) {
        Articles updatedArticle = service.updateArticle(articleId, updatedArticleData);
        if (updatedArticle != null) {
            return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        service.deleteArticle(articleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
