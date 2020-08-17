package com.example.rebeikiacollector.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SpecialActiveRequestsItem{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("address")
	private Address address;

	@SerializedName("expected_date")
	private String expectedDate;

	@SerializedName("user_image")
	private String userImage;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("order_images")
	private List<String> orderImages;

	@SerializedName("description")
	private String description;

	@SerializedName("location")
	private Location location;

	@SerializedName("_id")
	private String id;

	@SerializedName("status")
	private String status;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setExpectedDate(String expectedDate){
		this.expectedDate = expectedDate;
	}

	public String getExpectedDate(){
		return expectedDate;
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

	public void setOrderImages(List<String> orderImages){
		this.orderImages = orderImages;
	}

	public List<String> getOrderImages(){
		return orderImages;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
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

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}