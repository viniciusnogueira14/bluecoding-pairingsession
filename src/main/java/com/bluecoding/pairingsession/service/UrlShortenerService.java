package com.bluecoding.pairingsession.service;

import com.bluecoding.pairingsession.database.domain.UrlShortenerEntity;
import com.bluecoding.pairingsession.database.repository.UrlShortenerRepository;
import com.bluecoding.pairingsession.web.resources.UrlShortenerResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlShortenerService {

    private final UrlShortenerRepository repository;

    public UrlShortenerService(UrlShortenerRepository repository) {
        this.repository = repository;
    }

    public UrlShortenerEntity save(UrlShortenerEntity entity) {
        return this.repository.save(entity);
    }

    public List<UrlShortenerEntity> getAll() {
        return this.repository.findAll();
    }

    public List<UrlShortenerEntity> getTopHundred() {
        return repository.findFirst100ByOrderByUrlHitsDesc();
    }

    public List<UrlShortenerEntity> findByWebsiteNameIsNull() {
        return repository.findByWebsiteNameIsNull();
    }

    public void saveAll(List<UrlShortenerEntity> entities) {
        repository.saveAllAndFlush(entities);
    }

    public Optional<UrlShortenerEntity> findByBaseUrl(String baseUrl) {
        return repository.findByBaseUrlIgnoreCase(baseUrl);
    }
}
