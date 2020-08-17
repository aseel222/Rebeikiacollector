package com.example.rebeikiacollector.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CompletedRequestsItem{

	@SerializedName("received_order")
	private List<ReceivedOrderItem> receivedOrder;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("user_image")
	private String userImage;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("request_point")
	private int requestPoint;

	@SerializedName("_id")
	private String id;

	@SerializedName("status")
	private String status;

	public void setReceivedOrder(List<ReceivedOrderItem> receivedOrder){
		this.receivedOrder = receivedOrder;
	}

	public List<ReceivedOrderItem> getReceivedOrder(){
		return receivedOrder;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setUserImage(String userImage){
		this.userImage = userImage;
	}

	public String getUserImage(){
		return userImage;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setRequestPoint(int requestPoint){
		this.requestPoint = requestPoint;
	}

	public int getRequestPoint(){
		return requestPoint;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"CompletedRequestsItem{" + 
			"received_order = '" + receivedOrder + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			",user_image = '" + userImage + '\'' + 
			",user_name = '" + userName + '\'' + 
			",request_point = '" + requestPoint + '\'' + 
			",_id = '" + id + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}