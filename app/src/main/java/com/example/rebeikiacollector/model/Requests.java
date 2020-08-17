package com.example.rebeikiacollector.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Requests{

	@SerializedName("received_orders")
	private List<Object> receivedOrders;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("expected_date")
	private String expectedDate;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("__v")
	private int V;

	@SerializedName("collector_id")
	private String collectorId;

	@SerializedName("location")
	private Location location;

	@SerializedName("_id")
	private String id;

	@SerializedName("order")
	private List<OrderItem> order;

	@SerializedName("status")
	private String status;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setReceivedOrders(List<Object> receivedOrders){
		this.receivedOrders = receivedOrders;
	}

	public List<Object> getReceivedOrders(){
		return receivedOrders;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setExpectedDate(String expectedDate){
		this.expectedDate = expectedDate;
	}

	public String getExpectedDate(){
		return expectedDate;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setCollectorId(String collectorId){
		this.collectorId = collectorId;
	}

	public String getCollectorId(){
		return collectorId;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setOrder(List<OrderItem> order){
		this.order = order;
	}

	public List<OrderItem> getOrder(){
		return order;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}