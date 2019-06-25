package com.baggio.okhttp.service;

import com.alibaba.fastjson.JSON;
import com.baggio.okhttp.model.User;
//import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyOkHttpService {
    @Autowired
    private OkHttpClient okHttpClient;

    public User getUserByOkhttp(String username) {
        User user = null;
        Response response = null;

        String url = "http://localhost:8080/User/getUser?username=" + username;

        try {
            Request request = new Request.Builder().url(url).build();
            response = okHttpClient.newCall(request).execute();
            String userStr = response.body().string();
            user = JSON.parseObject(userStr, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null && response.body() != null) {
                try {
                    // 关闭以释放资源
                    response.body().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return user;
    }
}
