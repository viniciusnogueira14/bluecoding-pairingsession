package com.bluecoding.pairingsession.web.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UrlShortenerResponse {

    private Long id;
    private String baseUrl;
    private String shortUrl;
    private String websiteName;

}
