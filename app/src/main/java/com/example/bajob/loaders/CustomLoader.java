package com.example.bajob.loaders;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;

public class CustomLoader extends AsyncTaskLoader<IpResponse> {
    private ApiEndpoint apiEndpoint;
    private IpResponse ipResponse;
    private Throwable retrofitError;
    @Nullable
    private BroadcastReceiver networkStateReceiver;

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public CustomLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public IpResponse loadInBackground() {
        Call<IpResponse> response = apiEndpoint.getUsers();
        try {
            Response<IpResponse> execute = response.execute();
            if (execute.isSuccessful()) {
                return execute.body();
            } else {
                retrofitError = new HttpException(execute);
                return null;
            }
        } catch (IOException e) {
            retrofitError = e;
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (ipResponse != null) {
            deliverResult(ipResponse);
        } else {
            if (apiEndpoint == null) {
                apiEndpoint = RetrofitHelper.getService();
            }
            if (networkStateReceiver == null) {
                networkStateReceiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(@NonNull Context context, Intent intent) {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                            forceLoad();
                        } else {
                            Toast.makeText(context, "Please,check your network connection", Toast.LENGTH_LONG).show();
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
                getContext().registerReceiver(networkStateReceiver, intentFilter);
            }
        }

    }

    @Override
    protected void onStopLoading() {
        if (networkStateReceiver != null) {
            getContext().unregisterReceiver(networkStateReceiver);
            networkStateReceiver = null;
        }
        super.onStopLoading();
    }

    public Throwable getRetrofitError() {
        return retrofitError;
    }

    @Override
    public void deliverResult(IpResponse data) {
        ipResponse = data;
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        if (networkStateReceiver != null) {
            getContext().unregisterReceiver(networkStateReceiver);
            networkStateReceiver = null;
        }
        super.onReset();
    }
}
/**
 * Created by bajob on 3/22/2017.
 * <p>
 * Stores away the application context associated with context.
 * Since Loaders can be used across multiple activities it's dangerous to
 * store the context directly; always use {@link #getContext()} to retrieve
 * the Loader's Context, don't use the constructor argument directly.
 * The Context returned by {@link #getContext} is safe to use across
 * Activity instances.
 *
 * @param context used to retrieve the application context.
 * <p>
 * Stores away the application context associated with context.
 * Since Loaders can be used across multiple activities it's dangerous to
 * store the context directly; always use {@link #getContext()} to retrieve
 * the Loader's Context, don't use the constructor argument directly.
 * The Context returned by {@link #getContext} is safe to use across
 * Activity instances.
 * @param context used to retrieve the application context.
 * <p>
 * Stores away the application context associated with context.
 * Since Loaders can be used across multiple activities it's dangerous to
 * store the context directly; always use {@link #getContext()} to retrieve
 * the Loader's Context, don't use the constructor argument directly.
 * The Context returned by {@link #getContext} is safe to use across
 * Activity instances.
 * @param context used to retrieve the application context.
 * <p>
 * Stores away the application context associated with context.
 * Since Loaders can be used across multiple activities it's dangerous to
 * store the context directly; always use {@link #getContext()} to retrieve
 * the Loader's Context, don't use the constructor argument directly.
 * The Context returned by {@link #getContext} is safe to use across
 * Activity instances.
 * @param context used to retrieve the application context.
 * <p>
 * Stores away the application context associated with context.
 * Since Loaders can be used across multiple activities it's dangerous to
 * store the context directly; always use {@link #getContext()} to retrieve
 * the Loader's Context, don't use the constructor argument directly.
 * The Context returned by {@link #getContext} is safe to use across
 * Activity instances.
 * @param context used to retrieve the application context.
 */

/*
public class CustomLoader extends AsyncTaskLoader<List<String>> {
    private List<String> mDataList;
    */
/**
 * Stores away the application context associated with context.
 * Since Loaders can be used across multiple activities it's dangerous to
 * store the context directly; always use {@link #getContext()} to retrieve
 * the Loader's Context, don't use the constructor argument directly.
 * The Context returned by {@link #getContext} is safe to use across
 * Activity instances.
 *
 * @param context used to retrieve the application context.
 *//*

    public CustomLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mDataList != null) {
            deliverResult(mDataList);
        } else {
            //Force an ASYNCHRONOUS load
            forceLoad();//this internaly first call loadInBackground and then
            // call deliverResult that get return value from loadInBackground as parameter
        }
    }

    @Override
    public List<String> loadInBackground() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fillList(5);//this result is automaticaly passed to deliverResult() as parameter
    }

    @Override
    public void deliverResult(List<String> data) {
        mDataList = data;
        super.deliverResult(mDataList);
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    private List<String> fillList(int count) {
        Random rn = new Random();
        List<String> data = new ArrayList<>();
        while (count > 0) {
            String field = String.valueOf(rn.nextInt(1000));
            data.add(field);
            count--;
        }
        return data;
    }
}
*/
