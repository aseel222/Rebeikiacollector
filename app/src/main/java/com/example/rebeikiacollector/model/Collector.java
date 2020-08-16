package com.example.rebeikiacollector.model;

import com.google.gson.annotations.SerializedName;

public class Collector{

	@SerializedName("national_id")
	private long nationalId;

	@SerializedName("image")
	private String image;

	@SerializedName("role")
	private String role;

	@SerializedName("driving_license")
	private int drivingLicense;

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

	@SerializedName("car_type")
	private String carType;

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

	public void setDrivingLicense(int drivingLicense){
		this.drivingLicense = drivingLicense;
	}

	public int getDrivingLicense(){
		return drivingLicense;
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

	public void setCarType(String carType){
		this.carType = carType;
	}

	public String getCarType(){
		return carType;
	}

	@Override
 	public String toString(){
		return 
			"Collector{" + 
			"national_id = '" + nationalId + '\'' + 
			",image = '" + image + '\'' + 
			",role = '" + role + '\'' + 
			",driving_license = '" + drivingLicense + '\'' + 
			",phone = '" + phone + '\'' + 
			",car_number = '" + carNumber + '\'' + 
			",__v = '" + V + '\'' + 
			",name = '" + name + '\'' + 
			",_id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",car_type = '" + carType + '\'' + 
			"}";
		}
}