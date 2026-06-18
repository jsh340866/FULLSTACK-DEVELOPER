package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() throws InterruptedException {
        return new RestTemplate();
    }

}
