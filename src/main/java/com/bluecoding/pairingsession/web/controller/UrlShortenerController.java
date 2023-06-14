package com.bluecoding.pairingsession.web.controller;

import com.bluecoding.pairingsession.business.UrlShortenerBusiness;
import com.bluecoding.pairingsession.database.domain.UrlShortenerEntity;
import com.bluecoding.pairingsession.web.resources.UrlShortenerRequest;
import com.bluecoding.pairingsession.web.resources.UrlShortenerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/shortener")
public class UrlShortenerController {

    private final UrlShortenerBusiness business;

    public UrlShortenerController(UrlShortenerBusiness business) {
        this.business = business;
    }

    @PostMapping
    public ResponseEntity<UrlShortenerResponse> encodeUrl(@RequestBody UrlShortenerRequest request) throws URISyntaxException {
        return ResponseEntity
                .created(new URI(""))
                .body(business.shortUrl(request.getBaseUrl()));
    }

    @GetMapping("/top100")
    public ResponseEntity<List<UrlShortenerEntity>> getTopHundred() {
        return ResponseEntity.ok().body(business.getTopHundred());
    }

}
