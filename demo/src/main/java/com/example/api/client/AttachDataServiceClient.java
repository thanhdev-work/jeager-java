package com.example.api.client;

import com.example.api.response.AttachDataResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AttachDataServiceClient {
    public final RestTemplate restTemplate;

    private static final String DATA_SERVICE_URL = "localhost:8081/";

    public AttachDataServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public AttachDataResponse getAttachData(Long id) {
        final String url = DATA_SERVICE_URL + "data/" + id;
        return restTemplate.getForObject(url, AttachDataResponse.class);
    }
}
