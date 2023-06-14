package com.bluecoding.pairingsession.job;

import com.bluecoding.pairingsession.business.UrlShortenerBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenerJob {

    @Autowired
    private UrlShortenerBusiness business;

    @Scheduled(cron = "${bluecoding.job.cron}")
    public void getWebSiteNames() {
        System.out.println("Getting WebSite names!");
        business.getWebSiteNames();
    }

}
