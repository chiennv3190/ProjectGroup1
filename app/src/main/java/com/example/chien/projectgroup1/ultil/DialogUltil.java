package com.example.chien.projectgroup1.ultil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import com.example.chien.projectgroup1.common.Common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by chien on 8/20/2016.
 */
public class DialogUltil {
    private ProgressDialog pDialog;

    public void progressDialog(Activity activity, String message) {
        Common.checkButtonClick = true;
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage(message);
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public void dismissProgressDialog() {
        pDialog.dismiss();
        Common.checkButtonClick = false;
    }

    //dialog show GPS setting
    public void showGPSDisabledAlertToUser(final Activity activity) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setMessage("GPS hiện đang tắt. Bạn có muốn bật lên không?");
        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        });

        alertDialogBuilder.setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    //dialog show GPS setting
    public void showDialogCheckNetwork(final Activity activity) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Hiện không có kết nối mạng. Bạn phải bật wifi hoặc dữ liệu mạng di động lên!");
        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });

        alertDialogBuilder.setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    //dialog gui canh bao thanh cong
    public void showDialogCheckSendWarningSuccess(Activity activity) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Bạn đã gửi cảnh báo thành công. Thanks!");
        alertDialogBuilder.setNegativeButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Common.isCheckDialogSuccess = false;
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    //dialog check thoi gian gui canh bao
    public void showDialogCheckSendWarningFail(Activity activity) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Mỗi cảnh báo cùng loại phải cách nhau 10ph. Hiện tại bạn chưa thể sử dụng chức năng này!");
        alertDialogBuilder.setNegativeButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
