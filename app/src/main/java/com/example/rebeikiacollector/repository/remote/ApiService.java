package com.example.rebeikiacollector.repository.remote;

import com.example.rebeikiacollector.model.ProfileResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {

    @GET("collector/me")
    Observable<Response<ProfileResponse>> getProfileData(@Header("Authorization") String token);

}
