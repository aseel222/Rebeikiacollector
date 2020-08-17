package com.example.rebeikiacollector.model;

import com.google.gson.annotations.SerializedName;

public class ConfirmOrderResponse{

	@SerializedName("requests")
	private Requests requests;

	@SerializedName("status")
	private int status;

	public void setRequests(Requests requests){
		this.requests = requests;
	}

	public Requests getRequests(){
		return requests;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}