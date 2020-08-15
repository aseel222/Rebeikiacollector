package com.example.rebeikiacollector.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.ProfileResponse;
import com.example.rebeikiacollector.utiles.InternetConnection;
import com.example.rebeikiacollector.utiles.Utiles;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public class MenuViewModel extends BaseViewModel {

    public MutableLiveData<ProfileResponse> profileResponse = new MutableLiveData<>();


    public MenuViewModel(@NonNull Application application) {
        super(application);
    }

    public void getProfileData(String token) {
        if (InternetConnection.checkInternetConnection()) {
            setIsLoading(true);
            getRepository().getProfileData(token)
                    .subscribe(new Observer<Response<ProfileResponse>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(Response<ProfileResponse> response) {
                            if (response.code() == 200 ) {
                                setIsLoading(false);
                                profileResponse.setValue(response.body());
                            }else if (response.code() == 401){
                                setIsLoading(false);
                                setMsgError("unthorized");
                                /*ProfileResponse profileResponse1 = new ProfileResponse();
                                profileResponse1.setStatus(401);
                                profileResponse.setValue(profileResponse1);*/
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            setIsLoading(false);
                            setMsgRes(Utiles.getMessageErrorRes(e));
                        }

                        @Override
                        public void onComplete() {
                            setIsLoading(false);
                        }
                    });
        } else {
            setMsgRes(R.string.internet_not_connected);
        }
    }



}
