package com.example.administrator.demo.api;

import com.example.administrator.demo.data.FeatureData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/9/4.
 */

public interface FeaturedApi {





@GET("top250")
Call<FeatureData> getPhotos(@Query("start") int start,
                                  @Query("count") int count

                                  );




}
