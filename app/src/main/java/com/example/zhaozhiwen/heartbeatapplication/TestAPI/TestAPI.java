package com.example.zhaozhiwen.heartbeatapplication.TestAPI;


import com.example.zhaozhiwen.heartbeatapplication.TestModel.MovieData;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by zhaozhiwen on 2016/4/21.
 */
public interface TestAPI {
      /*
      数据用的是themovie.db中的数据，接口地址：https://api.themoviedb.org/3/movie/550?api_key=1d1cd40875197d9e76c870167c8aa3c9
      把接口进行分割，https://api.themoviedb.org是baseURL，/3/movie/550是访问方法中的URL，api_key是参数。
       */
     @GET("/3/movie/550")
     Call<MovieData> getDapplicationData(
             @Query("api_key") String api_key);
}
