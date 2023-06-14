package com.bluecoding.pairingsession.database.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "shortener")
public class UrlShortenerEntity {

    @Id
    @GeneratedValue(generator = "seq_shortener", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_shortener", sequenceName = "sq_shortener", allocationSize = 1)
    @Column(name = "ID_URL", unique = true, nullable = false, precision = 18)
    private Long id;

    @Column(name = "BASE_URL", unique = true, nullable = false)
    private String baseUrl;

    @Column(name = "SHORT_URL", unique = true, nullable = false)
    private String shortUrl;

    @Column(name = "WEBSITE_NAME", length = 100)
    private String websiteName;

    @Column(name = "URL_HITS", precision = 18)
    private Long urlHits;

}
