package com.example.rebeikiacollector.model;

import com.google.gson.annotations.SerializedName;

public class ReceivedOrdersItem{

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("type")
	private String type;

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}