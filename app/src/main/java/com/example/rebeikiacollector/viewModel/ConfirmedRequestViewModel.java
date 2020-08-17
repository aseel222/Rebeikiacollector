package com.example.rebeikiacollector.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.rebeikiacollector.model.ConfirmedRequestResponse;
import com.example.rebeikiacollector.model.ProfileResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public class ConfirmedRequestViewModel extends BaseViewModel {
    public MutableLiveData<ConfirmedRequestResponse> confirmedrequest = new MutableLiveData<>();

    public ConfirmedRequestViewModel(@NonNull Application application) {
        super(application);
    }
    public void getconfirmedrequest(String token){
        getRepository().confirmedrequest(token).subscribe(new Observer<Response<ConfirmedRequestResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<ConfirmedRequestResponse> confirmedRequestResponseResponse) {
                if(confirmedRequestResponseResponse.code()==200){
                    confirmedrequest.setValue(confirmedRequestResponseResponse.body());
                }
                else if(confirmedRequestResponseResponse.code()==401){
                    setMsgError("unusrized");
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
