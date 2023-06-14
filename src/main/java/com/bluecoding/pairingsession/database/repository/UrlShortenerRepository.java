package com.bluecoding.pairingsession.database.repository;

import com.bluecoding.pairingsession.database.domain.UrlShortenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlShortenerRepository extends JpaRepository<UrlShortenerEntity, Long> {

    List<UrlShortenerEntity> findFirst100ByOrderByUrlHitsDesc();

    List<UrlShortenerEntity> findByWebsiteNameIsNull();

    Optional<UrlShortenerEntity> findByBaseUrlIgnoreCase(String baseUrl);
}
