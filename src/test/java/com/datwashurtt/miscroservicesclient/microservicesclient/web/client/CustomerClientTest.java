package com.datwashurtt.miscroservicesclient.microservicesclient.web.client;

import com.datwashurtt.miscroservicesclient.microservicesclient.web.model.BeerDto;
import com.datwashurtt.miscroservicesclient.microservicesclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {
    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }
    @Test
    void testSaveNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder().customerName("Maxwell").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }
    @Test
    void testUpdateClient(){
        CustomerDto customerDto = CustomerDto.builder().customerName("Xavier").build();
        client.updateCustomer(UUID.randomUUID(),customerDto);
    }
    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}