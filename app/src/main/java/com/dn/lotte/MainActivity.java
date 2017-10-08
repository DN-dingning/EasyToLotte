package com.dn.lotte;

import android.view.View;

import com.dn.lotte.api.Api;
import com.dn.lotte.api.ApiService;
import com.dn.lotte.bean.UserInfoBean;
import com.easy.common.base.BaseActivity;
import com.easy.common.baserx.RxSubscriber;

import java.util.HashMap;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        findViewById(R.id.buttonTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map = new HashMap<>();
                map.put("Name","TestApp2");
                map.put("Pass","111111");
                map.put("token","111111sdf");
                Api.getInstance().get(ApiService.class)
                        .getUserInfo(map)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new RxSubscriber<UserInfoBean>(mContext,false) {
                            @Override
                            protected void _onNext(UserInfoBean userInfoBean) {

                            }

                            @Override
                            protected void _onError(String message) {

                            }
                        });
            }
        });

    }
}
