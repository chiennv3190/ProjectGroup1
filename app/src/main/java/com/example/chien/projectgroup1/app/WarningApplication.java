package com.example.chien.projectgroup1.app;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.chien.projectgroup1.network.WarningAPIService;
import com.facebook.FacebookSdk;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chien on 8/20/2016.
 */
public class WarningApplication extends MultiDexApplication{
    public static Retrofit mRetrofit;
    public static final String BASE_API = "http://warninggroup1.jelastic.skali.net/";
    public static WarningAPIService warningAPIService;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        FacebookSdk.sdkInitialize(getApplicationContext());

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        warningAPIService = mRetrofit.create(WarningAPIService.class);
    }
}
