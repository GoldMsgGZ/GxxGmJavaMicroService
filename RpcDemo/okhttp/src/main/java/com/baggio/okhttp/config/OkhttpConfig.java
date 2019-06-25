package com.baggio.okhttp.config;


import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class OkhttpConfig {
    @Bean
    public OkHttpClient okHttpClient() {
        // 这里OkHttp3的超时设置是这样的，不知道为什么会报错
        OkHttpClient okHttpClient = new OkHttpClient();

        okHttpClient.setConnectTimeout(2000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(3000, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(3000, TimeUnit.MILLISECONDS);

        return okHttpClient;
    }
}
