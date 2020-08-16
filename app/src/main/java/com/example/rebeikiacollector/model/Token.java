package com.example.rebeikiacollector.model;

import com.google.gson.annotations.SerializedName;

public class Token{

	@SerializedName("token")
	private String token;

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"Token{" + 
			"token = '" + token + '\'' + 
			"}";
		}
}