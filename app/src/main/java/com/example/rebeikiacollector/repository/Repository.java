package com.example.rebeikiacollector.repository;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.MimeTypeMap;


import com.example.rebeikiacollector.repository.remote.ApiManager;
import com.example.rebeikiacollector.repository.remote.ApiService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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



}