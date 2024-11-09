package com.example.springapp.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class MockServerClient {

    @Value("${MOCK_ENDPOINT:http://localhost:10180}")
    private String mockEndpoint;

    private RestTemplate restTemplate;

    public MockServerClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callMockService(Object requestData) {
        log.info("Processing request");
        return  restTemplate.postForObject(mockEndpoint, requestData, String.class);
    }
}
