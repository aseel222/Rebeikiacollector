package com.example.rebeikiacollector.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.rebeikiacollector.model.LoginResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public class LoginViewModel extends BaseViewModel {
    public MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);

    }
    public void login(String email, String password) {
        getRepository().login(email,password).subscribe(new Observer<Response<LoginResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<LoginResponse> loginResponseResponse) {
                if (loginResponseResponse.code() == 200) {
                    loginResponse.setValue(loginResponseResponse.body());
                }
                 else if (loginResponseResponse.code() == 400) {
                    setMsgError("user name or password is incorrcet");
                }


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
