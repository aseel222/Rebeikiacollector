package com.example.rebeikiacollector.repository.remote;

import com.example.rebeikiacollector.model.BaseResponse;
import com.example.rebeikiacollector.model.ProfileResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @GET("collector/me")
    Observable<Response<ProfileResponse>> getProfileData(@Header("Authorization") String token);

    @POST("collector/logoutAll")
    Observable<Response<BaseResponse>> logout(@Header("Authorization") String token);

}
