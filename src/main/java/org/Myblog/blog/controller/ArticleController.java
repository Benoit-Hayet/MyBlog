package org.Myblog.blog.controller;

import org.Myblog.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.Myblog.blog.repository.ArticleRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(articles);
    }
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());
        Article savedArticle = articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article == null) {
            return ResponseEntity.notFound().build();
        } else {
            article.setTitle(articleDetails.getTitle());
            article.setContent(articleDetails.getContent());
            article.setUpdatedAt(LocalDateTime.now());
            Article updatedArticle = articleRepository.save(article);
            return ResponseEntity.ok(updatedArticle);
        }
    }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
            Article article = articleRepository.findById(id).orElse(null);
            if (article == null) {
                return ResponseEntity.notFound().build();
            }
            articleRepository.delete(article);
            return ResponseEntity.noContent().build();
        }
}