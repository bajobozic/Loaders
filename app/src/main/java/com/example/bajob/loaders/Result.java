package com.example.bajob.loaders;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("continent")
	@Expose
	private String continent;

	@SerializedName("stateAbbr")
	@Expose
	private String stateAbbr;

	@SerializedName("country")
	@Expose
	private String country;

	@SerializedName("city")
	@Expose
	private String city;

	@SerializedName("latitude")
	@Expose
	private double latitude;

	@SerializedName("ip")
	@Expose
	private String ip;

	@SerializedName("countryIso2")
	@Expose
	private String countryIso2;

	@SerializedName("postal")
	@Expose
	private String postal;

	@SerializedName("state")
	@Expose
	private String state;

	@SerializedName("longitude")
	@Expose
	private double longitude;

	@SerializedName("ds")
	@Expose
	private String ds;

	public void setContinent(String continent){
		this.continent = continent;
	}

	public String getContinent(){
		return continent;
	}

	public void setStateAbbr(String stateAbbr){
		this.stateAbbr = stateAbbr;
	}

	public String getStateAbbr(){
		return stateAbbr;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setIp(String ip){
		this.ip = ip;
	}

	public String getIp(){
		return ip;
	}

	public void setCountryIso2(String countryIso2){
		this.countryIso2 = countryIso2;
	}

	public String getCountryIso2(){
		return countryIso2;
	}

	public void setPostal(String postal){
		this.postal = postal;
	}

	public String getPostal(){
		return postal;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public void setDs(String ds){
		this.ds = ds;
	}

	public String getDs(){
		return ds;
	}

	@NonNull
    @Override
 	public String toString(){
		return 
			"Result{" + 
			"continent = '" + continent + '\'' + 
			",stateAbbr = '" + stateAbbr + '\'' + 
			",country = '" + country + '\'' + 
			",city = '" + city + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",ip = '" + ip + '\'' + 
			",countryIso2 = '" + countryIso2 + '\'' + 
			",postal = '" + postal + '\'' + 
			",state = '" + state + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",ds = '" + ds + '\'' + 
			"}";
		}
}