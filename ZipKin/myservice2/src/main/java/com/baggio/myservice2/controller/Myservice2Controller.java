package com.baggio.myservice2.controller;

import com.github.kristofa.brave.Brave;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.RequestBuilder;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        }
    }
}
