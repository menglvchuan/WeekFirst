package com.bawei.xiaojiaying.utils;

import android.util.Log;


import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Time:2019/2/18
 * <p>
 * Author:肖佳莹
 * <p>
 * Description:
 */
public class OkHttpUtils {

    private static HttpLoggingInterceptor loggingInterceptor;

    //私有构造方法
    private OkHttpUtils(){}
    private static OkHttpUtils okHttpUtils = null;
    //静态工厂
    public static OkHttpUtils getInstance(){
        if(okHttpUtils==null){
            okHttpUtils = new OkHttpUtils();
        }
        return okHttpUtils;
    }
    private static Interceptor myIntercepter(){
        loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lanjie",message);
            }
        });
        return loggingInterceptor;
    }
    //执行get方法
    public static void doGet(String url, Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(myIntercepter())
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //执行post方法
    public static void doPost(String url, Map<String,String> params,Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(myIntercepter())
                .build();
        //请求体
        FormBody.Builder builder = new FormBody.Builder();
        //遍历Map集合
        for (String key:params.keySet()) {
            builder.add(key,params.get(key));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        okHttpClient.newCall(request).enqueue(callback);

    }
}
