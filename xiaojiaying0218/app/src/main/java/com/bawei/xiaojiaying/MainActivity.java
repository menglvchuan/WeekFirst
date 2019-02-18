package com.bawei.xiaojiaying;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bawei.xiaojiaying.Adapter.MyAdapter;
import com.bawei.xiaojiaying.Bean.JsonBean;
import com.bawei.xiaojiaying.presenter.ShowPresenter;
import com.bawei.xiaojiaying.view.ShowView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ShowView {

    private RecyclerView rlv;
    private ShowPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        rlv = findViewById(R.id.rlv);
        //实例化Presenter
        presenter = new ShowPresenter(this);
        //创建布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rlv.setLayoutManager(linearLayoutManager);
        presenter.onDeated();
    }

    @Override
    public void getViewData(String json) {
        //Toast.makeText(MainActivity.this,json.toString(),Toast.LENGTH_SHORT).show();
       if(json!=null) {
           Gson gson = new Gson();
           JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
          // Toast.makeText(MainActivity.this,jsonBean.toString(),Toast.LENGTH_SHORT).show();
           List<JsonBean.DataBeanX.ExtrasBean.SliderBean> list = jsonBean.getData().getExtras().getSlider();
           rlv.setAdapter(new MyAdapter(MainActivity.this, list));
       }
    }
}
