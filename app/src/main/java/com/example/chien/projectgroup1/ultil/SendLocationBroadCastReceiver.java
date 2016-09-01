package com.example.chien.projectgroup1.ultil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;

import com.example.chien.projectgroup1.common.Common;
import com.example.chien.projectgroup1.model.User;
import com.example.chien.projectgroup1.network.WarningAPI;
import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by chien on 8/21/2016.
 */
public class SendLocationBroadCastReceiver extends BroadcastReceiver implements LocationProvider.LocationCallback {
    private WarningAPI warningAPI = new WarningAPI();
    private double currentLatitude = 0.0;
    private double currentLongitude = 0.0;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(DeviceInformationUltil.checkGPSEnable(context) && DeviceInformationUltil.isNetworkConnected(context)){
            LocationProvider mLocationProvider = new LocationProvider(context, this);
            mLocationProvider.connect();
        }
    }

    @Override
    public void handleNewLocation(Location location) {
        currentLatitude = location.getLatitude();
        currentLongitude = location.getLongitude();

        if(currentLatitude != 0.0 && currentLongitude != 0.0){
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            User user = new User(Common.device_id, currentLatitude, currentLongitude, refreshedToken);
            warningAPI.checkUser(user);
        }
    }
}
