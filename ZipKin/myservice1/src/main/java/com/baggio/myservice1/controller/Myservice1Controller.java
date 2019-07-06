package com.baggio.myservice1.controller;

import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.http.*;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Api("Myservice1相关API")
@RestController
@RequestMapping("/myservice1/zipkin")
public class Myservice1Controller {
    @Autowired
    private AsyncHttpClient asyncHttpClient;

    @Autowired
    private Brave brave;

    @ApiOperation("调用指定的HTTP接口")
    @RequestMapping(value = "/sendHttpRequest", method = RequestMethod.GET)
    public String sendHttpRequest() {
        String result = "";

        try {
            RequestBuilder builder = new RequestBuilder();
            String url = "http://localhost:8092/myservice2/zipkin/test";
            builder.setUrl(url);
            Request request = builder.build();

            clientRequestInterceptor(request);
            Future<Response> response = asyncHttpClient.executeRequest(request);
            clientResponseInterceptor(response.get());

            return response.get().getResponseBody();
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
            return "";
        }

    }

    private void clientRequestInterceptor(Request request) {
        brave.clientRequestInterceptor().handle(new HttpClientRequestAdapter(new HttpClientRequest() {
            @Override
            public void addHeader(String s, String s1) {
                request.getHeaders().add(s, s1);
            }

            @Override
            public URI getUri() {
                return URI.create(request.getUrl());
            }

            @Override
            public String getHttpMethod() {
                return request.getMethod();
            }
        }, new DefaultSpanNameProvider()));
    }

    private void clientResponseInterceptor(Response response) {
        brave.clientResponseInterceptor().handle(new HttpClientResponseAdapter(new HttpResponse() {
            @Override
            public int getHttpStatusCode() {
                return response.getStatusCode();
            }
        }));
    }
}
