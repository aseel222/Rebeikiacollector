package com.example.rebeikiacollector.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	@SerializedName("error")
	private String error;

	@SerializedName("status_code")
	private int statusCode;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}