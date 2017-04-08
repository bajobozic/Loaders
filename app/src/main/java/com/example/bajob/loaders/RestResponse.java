package com.example.bajob.loaders;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestResponse{

	@SerializedName("result")
	@Expose
	private Result result;

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
		return result;
	}

	@NonNull
    @Override
 	public String toString(){
		return 
			"RestResponse{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}