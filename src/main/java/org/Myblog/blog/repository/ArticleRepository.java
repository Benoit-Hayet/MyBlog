package org.Myblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.Myblog.blog.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
