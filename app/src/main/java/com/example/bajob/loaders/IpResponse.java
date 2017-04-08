package com.example.bajob.loaders;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IpResponse{

	@SerializedName("RestResponse")
	@Expose
	private RestResponse restResponse;

	public void setRestResponse(RestResponse restResponse){
		this.restResponse = restResponse;
	}

	public RestResponse getRestResponse(){
		return restResponse;
	}

	@NonNull
    @Override
 	public String toString(){
		return 
			"IpResponse{" + 
			"restResponse = '" + restResponse + '\'' + 
			"}";
		}
}