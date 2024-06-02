package com.assignment.userpostservice.configuration.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfiguration {
    @Value("${external.api.base.url}")
    private String externalAPIBaseUrl;

    @Bean
    public RestClient restClient(RestClient.Builder restClientBuilder) {
        return restClientBuilder.baseUrl(externalAPIBaseUrl).build();
    }

}
