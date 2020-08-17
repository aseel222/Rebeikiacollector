package com.example.rebeikiacollector.repository.remote;

import com.example.rebeikiacollector.model.ActiveRequestsResponse;
import com.example.rebeikiacollector.model.BaseResponse;
import com.example.rebeikiacollector.model.ConfirmOrderRequest;
import com.example.rebeikiacollector.model.ConfirmedRequestResponse;
import com.example.rebeikiacollector.model.LoginResponse;
import com.example.rebeikiacollector.model.ProfileResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface ApiService {

    @GET("collector/me")
    Observable<Response<ProfileResponse>> getProfileData(@Header("Authorization") String token);

    @POST("collector/logoutAll")
    Observable<Response<BaseResponse>> logout(@Header("Authorization") String token);

@FormUrlEncoded
    @POST("collector/login")
    Observable<Response<LoginResponse>>login(@Field("email") String email, @Field("password") String password);

@GET("collector/confirmed")
Observable<Response<ConfirmedRequestResponse>> confirmedrequest(@Header("Authorization") String token);
    @GET("collector/requests/active")
    Observable<Response<ActiveRequestsResponse>> getActiveRequest(@Header("Authorization") String token);


    @PATCH("collector/requests/confirm")
    Observable<Response<BaseResponse>> confirmRequest(@Header("Authorization") String token, @Body ConfirmOrderRequest body);


}
