package com.example.rebeikiacollector.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ConfirmOrderRequest{

	@SerializedName("received_orders")
	private List<ReceivedOrdersItem> receivedOrders;

	@SerializedName("_id")
	private String id;

	public void setReceivedOrders(List<ReceivedOrdersItem> receivedOrders){
		this.receivedOrders = receivedOrders;
	}

	public List<ReceivedOrdersItem> getReceivedOrders(){
		return receivedOrders;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}