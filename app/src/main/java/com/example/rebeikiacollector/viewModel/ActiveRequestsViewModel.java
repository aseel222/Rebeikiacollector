package com.example.rebeikiacollector.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.model.ActiveRequestsResponse;
import com.example.rebeikiacollector.model.BaseResponse;
import com.example.rebeikiacollector.model.ConfirmOrderRequest;
import com.example.rebeikiacollector.utiles.InternetConnection;
import com.example.rebeikiacollector.utiles.Utiles;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public class ActiveRequestsViewModel extends BaseViewModel {

    public MutableLiveData<ActiveRequestsResponse> activeRequestResponse = new MutableLiveData<>();
    public MutableLiveData<BaseResponse> confirmRequestResponse = new MutableLiveData<>();

    public ActiveRequestsViewModel(@NonNull Application application) {
        super(application);
    }

    public void getActiveRequests(String token) {
        if (InternetConnection.checkInternetConnection()) {
            setIsLoading(true);
            getRepository().getActiveRequests(token)
                    .subscribe(new Observer<Response<ActiveRequestsResponse>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(Response<ActiveRequestsResponse> response) {
                            if (response.code() == 200) {
                                setIsLoading(false);
                                activeRequestResponse.setValue(response.body());
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

    public void confirmRequest(String token , ConfirmOrderRequest request) {
        if (InternetConnection.checkInternetConnection()) {
            setIsLoading(true);
            getRepository().confirmRequest(token , request)
                    .subscribe(new Observer<Response<BaseResponse>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(Response<BaseResponse> response) {
                            if (response.code() == 200) {
                                setIsLoading(false);
                                confirmRequestResponse.setValue(response.body());
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
