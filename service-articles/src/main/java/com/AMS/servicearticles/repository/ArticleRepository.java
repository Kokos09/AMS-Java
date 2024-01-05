package com.AMS.servicearticles.repository;

import com.AMS.servicearticles.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Articles,Long> {
}
