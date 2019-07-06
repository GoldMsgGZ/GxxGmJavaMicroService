package com.baggio.myservice1.config;

import com.ning.http.client.AsyncHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsyncHttpClientConfig {
    @Bean
    public AsyncHttpClient asyncHttpClient() {
        return new AsyncHttpClient();
    }
}
