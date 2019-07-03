package com.baggio.myservice2.controller;

import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.http.*;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Api("Myservice2相关API")
@RestController
@RequestMapping("/myservice2/zipkin")
public class Myservice2Controller {
    @Autowired
    private AsyncHttpClient asyncHttpClient;

    @Autowired
    private Brave brave;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        try {
            /******************************** service3 ************************************/
            RequestBuilder builder3 = new RequestBuilder();
            String url3 = "http://localhost:8083/myservice3/zipkin/test";
            builder3.setUrl(url3);
            Request request3 = builder3.build();

            clientRequestInterceptor(request3);
            Future<Response> response3 = asyncHttpClient.executeRequest(request3);
            clientResponseInterceptor(response3.get());

            /******************************** service4 ************************************/
            RequestBuilder builder4 = new RequestBuilder();
            String url4 = "http://localhost:8084/myservice4/zipkin/test";
            builder4.setUrl(url4);
            Request request4 = builder4.build();

            clientRequestInterceptor(request4);
            Future<Response> response4 = asyncHttpClient.executeRequest(request4);
            clientResponseInterceptor(response4.get());

            return response3.get().getResponseBody() + "=================" + response4.get().getResponseBody();
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
