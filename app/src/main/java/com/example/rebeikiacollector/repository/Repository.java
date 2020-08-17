package com.example.rebeikiacollector.repository;


import com.example.rebeikiacollector.model.ActiveRequestsResponse;
import com.example.rebeikiacollector.model.BaseResponse;
import com.example.rebeikiacollector.model.ConfirmedRequestResponse;
import com.example.rebeikiacollector.model.LoginResponse;
import com.example.rebeikiacollector.model.ProfileResponse;
import com.example.rebeikiacollector.repository.remote.ApiManager;
import com.example.rebeikiacollector.repository.remote.ApiService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public final class Repository {

    private static Repository instance;
    private static ApiService service;
    //private Context context;

    private Repository(/*Context context*/) {
        // this.context = context;
        service = ApiManager.getInstance().getApi();
    }

    public static Repository getInstance(/*Context context*/) {
        if (instance == null)
            instance = new Repository(/*context*/);
        return instance;
    }


    public Observable<Response<ProfileResponse>> getProfileData(String token) {
        return service.getProfileData(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response<BaseResponse>> logout(String token) {
        return service.logout(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


    }
    public Observable<Response<LoginResponse>> login(String email, String password) {
        return service.login(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());}


    public Observable<Response<ConfirmedRequestResponse>> confirmedrequest(String token) {
        return service.confirmedrequest(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());}
}
