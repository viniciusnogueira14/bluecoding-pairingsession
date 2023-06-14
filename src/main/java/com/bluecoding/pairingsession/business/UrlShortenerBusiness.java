package com.bluecoding.pairingsession.business;

import com.bluecoding.pairingsession.database.domain.UrlShortenerEntity;
import com.bluecoding.pairingsession.service.UrlShortenerService;
import com.bluecoding.pairingsession.web.resources.UrlShortenerResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UrlShortenerBusiness {

    private final UrlShortenerService service;

    public UrlShortenerBusiness(UrlShortenerService service) {
        this.service = service;
    }

    public UrlShortenerResponse shortUrl(String baseUrl) {
        UrlShortenerEntity newEntity = new UrlShortenerEntity();
        Optional<UrlShortenerEntity> entity = service.findByBaseUrl(baseUrl);

        if (entity.isPresent()) {
            newEntity = entity.get();
            newEntity.setUrlHits(entity.get().getUrlHits() + 1);
        } else {
            newEntity.setBaseUrl(baseUrl);
            newEntity.setShortUrl(baseUrl);
            newEntity.setUrlHits(1L);
        }

        UrlShortenerEntity persisted = service.save(newEntity);

        return this.convertToResponse(persisted);
    }

    private UrlShortenerResponse convertToResponse(UrlShortenerEntity entity) {
        UrlShortenerResponse response = new UrlShortenerResponse();
        response.setId(entity.getId());
        response.setShortUrl(entity.getShortUrl());
        response.setBaseUrl(entity.getBaseUrl());
        response.setWebsiteName(entity.getWebsiteName());

        return response;
    }

    public List<UrlShortenerEntity> getTopHundred() {
        return service.getTopHundred();
    }

    public void getWebSiteNames() {
        List<UrlShortenerEntity> entities = service.findByWebsiteNameIsNull();

        entities.stream()
                .forEach(website -> website.setWebsiteName("WebSiteName"));

        service.saveAll(entities);
    }

}
