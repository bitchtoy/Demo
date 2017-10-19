package com.example.administrator.demo.inter.featured;

import com.example.administrator.demo.data.FeatureData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/9/1.
 */

public interface OnRequestPhotoListen {
    void onRequestPhotoSuccess(Call<FeatureData> call, Response<FeatureData> response);
    void onRequestPhotoFailed(Call<FeatureData> call,Throwable throwable);
}
