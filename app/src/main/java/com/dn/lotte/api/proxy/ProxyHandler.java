///*
// * Copyright (C) 2016 david.wei (lighters)
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *       http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.dn.lotte.api.proxy;
//
//import android.text.TextUtils;
//import android.util.Log;
//
//import com.dn.lotte.api.Api;
//import com.dn.lotte.api.ApiService;
//import com.dn.lotte.api.exception.TokenInvalidException;
//import com.dn.lotte.api.exception.TokenNotExistException;
//import com.easy.common.baserx.RxSubscriber;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import retrofit2.http.FieldMap;
//import rx.Observable;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.functions.Func1;
//import rx.schedulers.Schedulers;
//
///**
// * Created by david on 16/8/21.
// * GitHub: https://github.com/alighters
// * <p>
// * 用于刷新token 包装了网络请求
// */
//public class ProxyHandler implements InvocationHandler {
//
//    private final static String TAG = "Token_Proxy";
//
//    private final static String TOKEN = "access_token";
//
//    private final static int REFRESH_TOKEN_VALID_TIME = 30;
//    private static long tokenChangedTime = 0;
//    private Throwable mRefreshTokenError = null;
//    private boolean mIsTokenNeedRefresh;
//
//    private Object mProxyObject;
//
//    public ProxyHandler(Object proxyObject) {
//        mProxyObject = proxyObject;
//    }
//
//    @Override
//    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
//        return Observable.just(null).flatMap(new Func1<Object, Observable<?>>() {
//            @Override
//            public Observable<?> call(Object o) {
//                try {
//                    try {
//                        if (mIsTokenNeedRefresh) {
//                            updateMethodToken(method, args);
//                        }
//                        return (Observable<?>) method.invoke(mProxyObject, args);
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        }).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
//            @Override
//            public Observable<?> call(Observable<? extends Throwable> observable) {
//                return observable.flatMap(new Func1<Throwable, Observable<?>>() {
//                    @Override
//                    public Observable<?> call(Throwable throwable) {
//                        if (throwable instanceof TokenInvalidException) {
//                            return refreshTokenWhenTokenInvalid();
//                        } else if (throwable instanceof TokenNotExistException) {
//                            // Token 不存在，执行退出登录的操作。（为了防止多个请求，都出现 Token 不存在的问题，
//                            // 这里需要取消当前所有的网络请求）
////                            mGlobalManager.exitLogin();
//                            return Observable.error(throwable);
//                        }
//                        return Observable.error(throwable);
//                    }
//                });
//            }
//        });
//    }
//
//    /**
//     * Refresh the token when the current token is invalid.
//     *
//     * @return Observable
//     */
//    private Observable<?> refreshTokenWhenTokenInvalid() {
//        synchronized (ProxyHandler.class) {
//            // Have refreshed the token successfully in the valid time.
//            if (new Date().getTime() - tokenChangedTime < REFRESH_TOKEN_VALID_TIME) {
//                mIsTokenNeedRefresh = true;
//                return Observable.just(true);
//            } else {
//                String token = GlobalApplication.getInstance().getRefreshToken();
//                // call the refresh token api.
//
//                Api.getInstance().get(ApiService.class)
//                        .refreshToken(Api.getCacheControl(), GlobalApplication.getInstance().getRefreshToken())
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new RxSubscriber<TokenBean>(GlobalApplication.getInstance().getApplicationContext(), false) {
//                            @Override
//                            protected void _onNext(TokenBean tokenBean) {
//                                mIsTokenNeedRefresh = true;
//                                tokenChangedTime = new Date().getTime();
//                                GlobalApplication.getInstance().setAccessToken(tokenBean.getAccess_token());
//                                GlobalApplication.getInstance().setRefreshToken(tokenBean.getRefresh_token());
//                                Log.d("DNLog", "Refresh token success, time = " + "");
//                            }
//
//                            @Override
//                            protected void _onError(String message) {
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                mRefreshTokenError = e;
//
//                            }
//                        });
//                if (mRefreshTokenError != null) {
//                    return Observable.error(mRefreshTokenError);
//                } else {
//                    return Observable.just(true);
//                }
//            }
//        }
//    }
//
//    /**
//     * Update the token of the args in the method.
//     * <p>
//     * PS： 因为这里使用的是 PSOT 请求，所以这里就需要对 FielMap 的参数名称为 access_token 的方法。
//     */
//    private void updateMethodToken(Method method, Object[] args) {
//        if (mIsTokenNeedRefresh && !TextUtils.isEmpty(GlobalApplication.getInstance().getAccessToken())) {
//            Annotation[][] annotationsArray = method.getParameterAnnotations();
//            Annotation[] annotations;
//            if (annotationsArray != null && annotationsArray.length > 0) {
//                for (int i = 0; i < annotationsArray.length; i++) {
//                    annotations = annotationsArray[i];
//                    for (Annotation annotation : annotations) {
//                        if (annotation instanceof FieldMap) {
//                            Map<String, String> map = (HashMap) args[i];
//                            if (map.get("access_token") != null) {
//                                map.put("access_token", GlobalApplication.getInstance().getAccessToken());
//                            }
//                        }
//                    }
//                }
//            }
//            mIsTokenNeedRefresh = false;
//        }
//    }
//}
