package com.datwashurtt.miscroservicesclient.microservicesclient.web.client;

import com.datwashurtt.miscroservicesclient.microservicesclient.web.model.BeerDto;
import com.datwashurtt.miscroservicesclient.microservicesclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "tbroly.customer",ignoreUnknownFields = false)
@Component
public class CustomerClient {
    public final String CUSTOMER_PATH_V1 ="/api/v1/customer";
    private String apiHost;
    public final RestTemplate restTemplate;


    public CustomerClient (RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }
    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apiHost+CUSTOMER_PATH_V1+uuid.toString(),CustomerDto.class);
    }
    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost+CUSTOMER_PATH_V1,customerDto);
    }
    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apiHost+CUSTOMER_PATH_V1+"/"+uuid.toString(),customerDto);
    }
    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiHost+CUSTOMER_PATH_V1+"/"+uuid);
    }
    public void setApiHost(String apihost){
        this.apiHost=apihost;
    }
}
