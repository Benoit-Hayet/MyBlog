package org.Myblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.Myblog.blog.model.Article;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
    List<Article> findByCreatedAt(LocalDateTime createdAt);
}
