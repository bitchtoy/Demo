package com.example.administrator.demo.tools;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/2.
 */

public class AuthInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request;
        request = chain.request();

        Response response = chain.proceed(request);

        return response;
    }
}
