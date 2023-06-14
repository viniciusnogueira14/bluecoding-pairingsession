package com.bluecoding.pairingsession.web.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UrlShortenerRequest {

    private String baseUrl;
}
