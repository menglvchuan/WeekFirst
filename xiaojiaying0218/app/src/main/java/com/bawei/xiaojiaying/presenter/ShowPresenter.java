package com.bawei.xiaojiaying.presenter;

import com.bawei.xiaojiaying.model.ShowModel;
import com.bawei.xiaojiaying.view.ShowView;

/**
 * Time:2019/2/18
 * <p>
 * Author:肖佳莹
 * <p>
 * Description:
 */
public class ShowPresenter {

    private final ShowModel showModel;
    private final ShowView showView;

    public ShowPresenter(ShowView view){
        showModel = new ShowModel();
        showView = view;
    }
    public void onDeated() {
        showModel.getHttpData();
        //获取m值
        showModel.setOnShowListener(new ShowModel.onShowListener() {
            @Override
            public void onResult(String json) {
                showView.getViewData(json);
            }
        });
    }

}
