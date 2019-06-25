package com.baggio.hystrixservice.config;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixServiceConfig {
    @Bean
    public AsyncHttpClient asyncHttpClient() {
        AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder()
                .setRequestTimeout(50000)
                .setConnectTimeout(20000)
                .setReadTimeout(30000);

        return new AsyncHttpClient(builder.build());
    }

    @Bean
    public HystrixMetricsStreamServlet hystrixMetricsStreamServlet() {
        return new HystrixMetricsStreamServlet();
    }

    @Bean
    public ServletRegistrationBean registration(HystrixMetricsStreamServlet servlet) {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(servlet);
        registrationBean.addUrlMappings("/hystrix.stream");

        return registrationBean;
    }
}
