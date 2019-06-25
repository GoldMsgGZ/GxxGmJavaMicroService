package com.baggio.hystrixservice.config;

import com.netflix.hystrix.*;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HystrixUtil {
    @Autowired
    private AsyncHttpClient asyncHttpClient;

    public Response execute(String serivceName, String methodName, String url) {
        HystrixCommand.Setter setter = HystrixCommand.Setter.withGroupKey((HystrixCommandGroupKey.Factory.asKey(serivceName)));
        setter.andCommandKey(HystrixCommandKey.Factory.asKey(serivceName + ":" + methodName));
        setter.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(3000));
        setter.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(20));

        return new MyHystrixCommand(setter, url, asyncHttpClient).execute();
    }
}
