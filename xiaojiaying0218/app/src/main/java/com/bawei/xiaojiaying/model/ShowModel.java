package com.bawei.xiaojiaying.model;

import android.os.Handler;
import android.os.Message;

import com.bawei.xiaojiaying.utils.OkHttpUtils;

import org.json.JSONArray;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Time:2019/2/18
 * <p>
 * Author:肖佳莹
 * <p>
 * Description:
 */
public class ShowModel {
    String url = "http://365jia.cn/news/api3/365jia/news/headline?page=1";
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                String json = (String) msg.obj;
                showListener.onResult(json);
            }
        }
    };
    public void getHttpData(){
        OkHttpUtils.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message = new Message();
                message.obj=json;
                message.what=0;
                handler.sendMessage(message);
            }
        });
    }
    //接口回调
    //定义一个接口
    public interface onShowListener{
        void onResult(String json);
    }
    public onShowListener showListener;

    public void setOnShowListener(onShowListener showListener) {
        this.showListener = showListener;
    }
}
