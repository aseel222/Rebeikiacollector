package com.example.rebeikiacollector.model;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse{

	@SerializedName("national_id")
	private long nationalId;

	@SerializedName("image")
	private String image;

	@SerializedName("role")
	private String role;

	@SerializedName("completed_special_requests")
	private int completedSpecialRequests;

	@SerializedName("car_type")
	private String carType;

	@SerializedName("driving_license")
	private int drivingLicense;

	@SerializedName("completed_requests")
	private int completedRequests;

	@SerializedName("phone")
	private String phone;

	@SerializedName("car_number")
	private String carNumber;

	@SerializedName("__v")
	private int V;

	@SerializedName("name")
	private String name;

	@SerializedName("_id")
	private String id;

	@SerializedName("email")
	private String email;

	public void setNationalId(long nationalId){
		this.nationalId = nationalId;
	}

	public long getNationalId(){
		return nationalId;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setCompletedSpecialRequests(int completedSpecialRequests){
		this.completedSpecialRequests = completedSpecialRequests;
	}

	public int getCompletedSpecialRequests(){
		return completedSpecialRequests;
	}

	public void setCarType(String carType){
		this.carType = carType;
	}

	public String getCarType(){
		return carType;
	}

	public void setDrivingLicense(int drivingLicense){
		this.drivingLicense = drivingLicense;
	}

	public int getDrivingLicense(){
		return drivingLicense;
	}

	public void setCompletedRequests(int completedRequests){
		this.completedRequests = completedRequests;
	}

	public int getCompletedRequests(){
		return completedRequests;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setCarNumber(String carNumber){
		this.carNumber = carNumber;
	}

	public String getCarNumber(){
		return carNumber;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}