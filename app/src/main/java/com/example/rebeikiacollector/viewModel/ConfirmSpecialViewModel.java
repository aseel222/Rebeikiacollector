package com.example.rebeikiacollector.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.rebeikiacollector.model.ConfirmSpecialResponse;
import com.example.rebeikiacollector.model.ConfirmedRequestResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public class ConfirmSpecialViewModel extends  BaseViewModel {
    public MutableLiveData<ConfirmSpecialResponse> confirmspecial = new MutableLiveData<>();




    public ConfirmSpecialViewModel(@NonNull Application application) {
        super(application);
    }
    public void confirmspecialrequest(String token){
        getRepository().confirmspecial(token).subscribe(new Observer<Response<ConfirmSpecialResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<ConfirmSpecialResponse> confirmSpecialResponseResponse) {
                if(confirmSpecialResponseResponse.code()==200){
                    confirmspecial.setValue(confirmSpecialResponseResponse.body());
                }
                else if(confirmSpecialResponseResponse.code()==401){
                    setMsgError("Error");
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
