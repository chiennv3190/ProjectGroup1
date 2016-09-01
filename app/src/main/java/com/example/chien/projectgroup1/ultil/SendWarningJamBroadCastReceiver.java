package com.example.chien.projectgroup1.ultil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.chien.projectgroup1.common.Common;

/**
 * Created by chien on 8/24/2016.
 */
public class SendWarningJamBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Common.isCheckSendWardningJam = true;
    }
}
