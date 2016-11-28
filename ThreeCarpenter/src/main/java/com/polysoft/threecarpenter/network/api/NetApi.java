package com.polysoft.threecarpenter.network.api;

import com.polysoft.threecarpenter.entity.LoginBean;
import com.polysoft.threecarpenter.entity.ZhuangbiImage;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xu on 2016/11/15.
 * <p/>
 * 自定义接口 提供各种请求方法
 */
public interface NetApi {

    //指明get请求，value与指定的BaseUrl拼接成要请求的url  返回值是Call
    @GET("courseList.jsp")
    Call<ArrayList> getCourseList();//请求课程列表

    //使用Rxjava 返回的不是Call对象 而是Observable
    @GET("search")
    Observable<ArrayList<ZhuangbiImage>> getImageList(@Query("q") String query);

    @GET("login")
    Observable<LoginBean> login(@Query("workerCode") String workerCode, @Query("password") String pwd);
    
}
