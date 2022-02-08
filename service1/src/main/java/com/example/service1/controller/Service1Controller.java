package com.example.service1.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/service1")
public class Service1Controller {

	 @Autowired
	 private DiscoveryClient discoveryClient;

	 private static final String GATEWAY_NAME = "GATEWAY-SERVICE";

	 @GetMapping("/test")
	    public String callServiceA() throws UnsupportedOperationException, IOException {
	        String url = "";
		 	String apiPath = "/service2/statuscheck";

	        List<ServiceInstance> instance = discoveryClient.getInstances(GATEWAY_NAME);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<String> response=null;

	        url = instance.get(0).getUri().toString();
	        url += apiPath;

	        try{
	            response=restTemplate.exchange(url,HttpMethod.GET, getHeaders(),String.class);
	        }catch (Exception ex)
	        {
	            System.out.println(ex);
	        }
	        System.out.println(response.getBody());

	        return "Service-A: inst001 È£Ãâ" + " > " + response.getBody().toString();
	    }

	    private static HttpEntity<?> getHeaders() throws IOException {
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	        return new HttpEntity<>(headers);
	    }

}
