package com.datwashurtt.miscroservicesclient.microservicesclient.web.client;

import com.datwashurtt.miscroservicesclient.microservicesclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;


@ConfigurationProperties(prefix = "tbroly.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {
    public final String BEER_PATH_V1 = "/api/v1/beer";
    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost+BEER_PATH_V1+uuid.toString(),BeerDto.class);
    }
    public URI saveNewBeer (BeerDto beerDto){
        return restTemplate.postForLocation(apiHost+BEER_PATH_V1,beerDto);
    }
    public void updateBeer (UUID uuid,BeerDto beerDto){
        restTemplate.put(apiHost+BEER_PATH_V1+"/"+uuid.toString(),beerDto);
    }
    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost+BEER_PATH_V1+"/"+uuid);
    }
    public void setApiHost(String apihost){
        this.apiHost=apihost;
    }
}
