package com.example.bajob.loaders;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by bajob on 3/23/2017.
 */

public interface ApiEndpoint {
    public static final String BASE_URL = " http://geo.groupkt.com/";

    @NonNull
    @GET("ip/109.245.135.162/json/")
    Call<IpResponse> getUsers();
}
