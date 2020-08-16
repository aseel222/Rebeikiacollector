package com.example.rebeikiacollector.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("collector")
	private Collector collector;

	@SerializedName("token")
	private Token token;

	public void setCollector(Collector collector){
		this.collector = collector;
	}

	public Collector getCollector(){
		return collector;
	}

	public void setToken(Token token){
		this.token = token;
	}

	public Token getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponse{" + 
			"collector = '" + collector + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}