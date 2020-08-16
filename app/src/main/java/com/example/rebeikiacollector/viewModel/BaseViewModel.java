package com.example.rebeikiacollector.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rebeikiacollector.repository.Repository;


public abstract class BaseViewModel extends AndroidViewModel {

    private Repository repository;
    private final MutableLiveData<Boolean> mIsLoading = new MutableLiveData<>();
    private final MutableLiveData<String> msgError = new MutableLiveData<>();
    private final MutableLiveData<Integer> msgRes = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(/*application*/);
    }


    public  Repository getRepository() {
        return repository;
    }

    public LiveData<Boolean> isLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.setValue(isLoading);
    }

    public LiveData<String> getMsgError(){ return msgError;}

    public void setMsgError(String msg) {msgError.setValue(msg);}

    public LiveData<Integer> getMsgRes(){ return msgRes;}

    public void setMsgRes(int msg) {msgRes.setValue(msg);}
}
