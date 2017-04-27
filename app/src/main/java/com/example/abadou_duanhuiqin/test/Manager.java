package com.example.abadou_duanhuiqin.test;

import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.rx.Result;

import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by abadou-xumin on 2017/4/27.
 */

public class Manager {
    public static void net(String url, HttpParams params, final Class<?> z, Subscriber s) {
        new RxVolley.Builder()
                .url("http://120.77.251.141:39080/youe/commons/uploadFile")
                //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
                .httpMethod(RxVolley.Method.POST)
                .cacheTime(6) //default: get 5min, post 0min
                .params(params)
                .contentType(RxVolley.ContentType.FORM)
                .getResult().map(new Func1<Result, Object>() {
            @Override
            public Object call(Result result) {
                return new Gson().fromJson(new String(result.data), z);
            }
        }).subscribe(s);  // 使用getResult()来返回RxJava数据类型
    }
}
