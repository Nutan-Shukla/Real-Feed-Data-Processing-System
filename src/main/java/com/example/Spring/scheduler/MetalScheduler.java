package com.example.Spring.scheduler;

import com.example.Spring.protos.MetalPrice;
import com.example.Spring.service.MetalsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
@EnableScheduling
public class MetalScheduler {


    private MetalsService metalsService;
    private RestTemplate restTemplate;


    public MetalScheduler(RestTemplate restTemplate, MetalsService metalsService)
    {
        this.restTemplate = restTemplate;
        this.metalsService = metalsService;
    }


    @Scheduled(fixedRateString = "PT5M")
    public void scheduledTask()
    {
        List<String> List = new ArrayList<String>();
        List.add("XAU");
        List.add("XAG");
        List.add("XPD");
        List.add("XPT");

        for(String element : List) {
                String uri = "https://goldbroker.com/api/spot-price?metal=" + element + "&currency=INR" + "&weight_unit=g";
                MetalPrice metalPrice = restTemplate.getForObject(uri, MetalPrice.class);
                metalsService.addMetalSpotPrice(metalPrice, element);
        }

    }
}
