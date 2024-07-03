package org.Myblog.blog.repository;

import org.Myblog.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
    List<Article> findByContentContaining(String keyword);
    List<Article> findByCreatedAt(LocalDateTime createdAt);
    List<Article> findByCreatedAtAfter(LocalDateTime createdAt);
    List<Article> findTop5ByOrderByCreatedAtDesc();
}
