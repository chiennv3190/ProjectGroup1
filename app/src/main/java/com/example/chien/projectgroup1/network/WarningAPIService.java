package com.example.chien.projectgroup1.network;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by chien on 8/20/2016.
 */
public interface WarningAPIService {
    @GET("viewAllObjectLocationGas")
    Call<JsonElement> getAllGas();

    @GET("viewAllBank")
    Call<JsonElement> getAllBank();

    @POST("searchATM")
    Call<JsonElement> searchATM(@Query("bankName" ) String bankName);

    @GET("viewAllObjectLocationATM")
    Call<JsonElement> getAllATM();

    @GET("viewAllCoffee")
    Call<JsonElement> getAllCoffee();

    @POST("addWarning")
    Call<JsonObject> addWarning(@Body JsonObject object);

    @POST("checkUser")
    Call<JsonObject> checkUser(@Body JsonObject object);

    @GET("viewAllWarning")
    Call<JsonElement> getAllWarning();


}
