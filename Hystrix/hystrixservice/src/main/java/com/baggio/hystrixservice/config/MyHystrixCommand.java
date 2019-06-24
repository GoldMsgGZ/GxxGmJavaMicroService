package com.baggio.hystrixservice.config;

import com.netflix.hystrix.HystrixCommand;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 为了实现服务降级容错功能，需要使用HystrixCommand实现类来包裹服务通信框架的调用行为
 */
public class MyHystrixCommand extends HystrixCommand<Response> {
    private String          url;
    private AsyncHttpClient asyncHttpClient;

    public MyHystrixCommand(Setter setter, String url, AsyncHttpClient asyncHttpClient) {
        super(setter);
        this.url = url;
        this.asyncHttpClient = asyncHttpClient;
    }

    @Override
    protected Response run() throws Exception {
        Response response = null;
        Request request = new RequestBuilder().setUrl(url).build();

        Future<Response> responseFuture = asyncHttpClient.executeRequest(request);
        try {
            response = responseFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Response getFallback() {
        // 实现快速失败
        throw new RuntimeException("active hystrix getFallback");
    }
}
