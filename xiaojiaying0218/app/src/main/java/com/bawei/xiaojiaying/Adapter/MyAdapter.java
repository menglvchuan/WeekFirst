package com.bawei.xiaojiaying.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.xiaojiaying.Bean.JsonBean;
import com.bawei.xiaojiaying.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Time:2019/2/18
 * <p>
 * Author:肖佳莹
 * <p>
 * Description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    List<JsonBean.DataBeanX.ExtrasBean.SliderBean> list;
    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;

    public MyAdapter(Context context, List<JsonBean.DataBeanX.ExtrasBean.SliderBean> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
                //自定义ViewHolder
                ViewHolder viewHolder = new ViewHolder(view);
                return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
            viewHolder.tv1.setText(list.get(i).getTitle());
        Glide.with(context).load("http://365jia.cn/uploads/appletrecommend/201804/5ad6ba6c6bb8b.jpg").into(viewHolder.img1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv1;
        private final ImageView img1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //找控件
            tv1 = itemView.findViewById(R.id.tv1);
            img1 = itemView.findViewById(R.id.img1);
        }
    }
  /* public class ViewHolder2 extends RecyclerView.ViewHolder{

        private final TextView tv2;
        private final ImageView img2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            //找控件
            tv2 = itemView.findViewById(R.id.tv2);
            img2 = itemView.findViewById(R.id.img2);
        }
    }*/
}
