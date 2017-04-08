package com.example.bajob.loaders;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bajob on 3/23/2017.
 */

public class RetrofitHelper {
    @NonNull
    private static OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
    @NonNull
    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiEndpoint.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build();
    private static ApiEndpoint apiEndpoint;

    public static ApiEndpoint getService() {
        if (apiEndpoint == null) {
            apiEndpoint = retrofit.create(ApiEndpoint.class);
        }
        return apiEndpoint;
    }

}
