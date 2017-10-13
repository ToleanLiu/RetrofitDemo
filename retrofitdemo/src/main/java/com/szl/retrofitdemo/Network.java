package com.szl.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ explain:
 * @ author：xujun on 2016-8-25 15:19
 * @ email：gdutxiaoxu@163.com
 */
public class Network {

    private static volatile Network mInstance;
    private APi mApi;


    public static Network getInstance(){
        if(mInstance==null){
            synchronized (Network.class){//保证在同一时刻最多只有一个线程执行该段代码。synchronized 关键字，它包括两种用法：synchronized 方法和 synchronized 块。
                if(mInstance==null){
                    mInstance=new Network();
                }
            }
        }
        return mInstance;
    }

    public APi getApi(){
        if(mApi==null){
            synchronized (Network.class){
                if(mApi==null){
                    Retrofit retrofit = new Retrofit.Builder()
                            //使用自定义的mGsonConverterFactory
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl("http://apis.baidu.com/txapi/")
                            .build();
                    mApi = retrofit.create(APi.class);
                }
            }

        }

        return mApi;

    }
}
