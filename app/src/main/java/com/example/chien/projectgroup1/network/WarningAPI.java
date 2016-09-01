package com.example.chien.projectgroup1.network;

import android.util.Log;

import com.example.chien.projectgroup1.app.WarningApplication;
import com.example.chien.projectgroup1.model.Bank;
import com.example.chien.projectgroup1.model.LocationATM;
import com.example.chien.projectgroup1.model.LocationCoffee;
import com.example.chien.projectgroup1.model.LocationGas;
import com.example.chien.projectgroup1.model.User;
import com.example.chien.projectgroup1.model.Warning;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by chien on 8/20/2016.
 */
public class WarningAPI {
    //get all gas
    public ArrayList<LocationGas> getGas() {

        ArrayList<LocationGas> listGas = new ArrayList<>();
        //gui request
        Call<JsonElement> callGetAllGas = WarningApplication.warningAPIService.getAllGas();
        //nhan response
        try {
            JsonElement element = (JsonElement) callGetAllGas.execute().body();

            JsonArray jsonArray = element.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();
                LocationGas locationGas = new LocationGas(obj.get("mLat").getAsDouble(), obj.get("mLng").getAsDouble(), obj.get("title").getAsString(), obj.get("snippet").getAsString());
                listGas.add(locationGas);

            }

        } catch (Exception e) {
            Log.e("ERROR", "Loi");
        }

        return listGas;
    }

    //get all atm
    public ArrayList<LocationATM> getAllATM() {

        ArrayList<LocationATM> listATM = new ArrayList<>();
        //gui request
        Call<JsonElement> callGetAllATM = WarningApplication.warningAPIService.getAllATM();
        //nhan response
        try {
            JsonElement element = (JsonElement) callGetAllATM.execute().body();

            JsonArray jsonArray = element.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();
                LocationATM locationATM = new LocationATM(obj.get("mLatATM").getAsDouble(), obj.get("mLngATM").getAsDouble(), obj.get("titleATM").getAsString(), obj.get("snippetATM").getAsString());
                listATM.add(locationATM);
            }

        } catch (Exception e) {
            Log.e("ERROR", "Loi");
        }

        return listATM;
    }

    //get all coffee
    public ArrayList<LocationCoffee> getCoffee() {

        ArrayList<LocationCoffee> listCoffee = new ArrayList<>();
        //gui request
        Call<JsonElement> callGetCoffee = WarningApplication.warningAPIService.getAllCoffee();
        //nhan response
        try {
            JsonElement element = (JsonElement) callGetCoffee.execute().body();

            JsonArray jsonArray = element.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();
                LocationCoffee locationCoffee = new LocationCoffee(obj.get("mLatCoffee").getAsDouble(), obj.get("mLngCoffee").getAsDouble(), obj.get("titleCoffee").getAsString(), obj.get("snippetCoffee").getAsString());
                listCoffee.add(locationCoffee);
            }

        } catch (Exception e) {
            Log.e("ERROR", "Loi");
        }

        return listCoffee;
    }

    //get all warning
    public ArrayList<Warning> getWarning() {

        ArrayList<Warning> listWarning = new ArrayList<>();
        //gui request
        Call<JsonElement> callGetWarning = WarningApplication.warningAPIService.getAllWarning();
        //nhan response
        try {
            JsonElement element = (JsonElement) callGetWarning.execute().body();

            JsonArray jsonArray = element.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();
                Warning warning = new Warning(obj.get("warning_Id").getAsInt(), obj.get("warning_lat").getAsDouble(), obj.get("warning_lng").getAsDouble(), obj.get("warning_address").getAsString(), obj.get("warning_name").getAsString(), obj.get("warning_category").getAsInt(), obj.get("create_time").getAsString());
                listWarning.add(warning);
            }

        } catch (Exception e) {
            Log.e("ERROR", "Loi");
        }

        return listWarning;
    }

    //get all bank
    public ArrayList<Bank> getBank() {

        ArrayList<Bank> listBank = new ArrayList<>();
        //gui request
        Call<JsonElement> callGetBank = WarningApplication.warningAPIService.getAllBank();
        //nhan response
        try {
            JsonElement element = (JsonElement) callGetBank.execute().body();

            JsonArray jsonArray = element.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();
                Bank bank = new Bank(obj.get("bankName").getAsString());
                listBank.add(bank);
            }

        } catch (Exception e) {
            Log.e("ERROR", "Loi");
        }

        return listBank;
    }

    //search atm
    public ArrayList<LocationATM> getATMBank(String bankName) {

        ArrayList<LocationATM> listATM = new ArrayList<>();
        //gui request
        Call<JsonElement> callGetATM = WarningApplication.warningAPIService.searchATM(bankName);
        //nhan response
        try {
            JsonElement element = (JsonElement) callGetATM.execute().body();

            JsonArray jsonArray = element.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();
                LocationATM locationATM = new LocationATM(obj.get("mLatATM").getAsDouble(), obj.get("mLngATM").getAsDouble(), obj.get("titleATM").getAsString(), obj.get("snippetATM").getAsString());
                listATM.add(locationATM);
            }

        } catch (Exception e) {
            Log.e("ERROR", "Loi");
        }

        return listATM;
    }

    //check User
    public void checkUser(User user) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("user_device_ui_id", user.getDevice_ui_id());
            jsonObject.addProperty("user_lat", user.getUser_lat());
            jsonObject.addProperty("user_lng", user.getUser_lng());
            jsonObject.addProperty("token", user.getToken());

            //gui request
            Call<JsonObject> callCheckUser = WarningApplication.warningAPIService.checkUser(jsonObject);
            callCheckUser.execute();
        } catch (Exception e) {
            Log.e("ERROR", "Loi send");
        }
    }

    //add warning
    public void addWarning(Warning warning) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("warning_lat", warning.getmLatWarning());
            jsonObject.addProperty("warning_lng", warning.getmLngWarning());
            jsonObject.addProperty("warning_address", warning.getAddressWarning());
            jsonObject.addProperty("warning_category", warning.getCategory_Id());
            jsonObject.addProperty("create_time", warning.getCreate_time());

            //gui request
            Call<JsonObject> callAddWarning = WarningApplication.warningAPIService.addWarning(jsonObject);
            callAddWarning.execute();
        } catch (Exception e) {
            Log.e("ERROR", "Loi");
        }
    }
}
