package com.example.chien.projectgroup1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.chien.projectgroup1.adapter.WarningAdapter;
import com.example.chien.projectgroup1.common.Common;
import com.example.chien.projectgroup1.model.Warning;
import com.example.chien.projectgroup1.network.WarningAPI;
import com.example.chien.projectgroup1.ultil.DialogUltil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WarningActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private ArrayList<Warning> listWarning;
    private ListView listView;
    private WarningAdapter warningAdapter;
    private DialogUltil dialogUltil = new DialogUltil();
    private WarningAPI warningAPI = new WarningAPI();
    private String message = "Loading Warning. Please wait...";
    private SharedPreferences preferences;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("WARNING");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.warning_layout);
//        runFadeInAnimation();
        swipeRefreshLayout.setOnRefreshListener(this);
        listView = (ListView) findViewById(R.id.lvWarning);
        dialogUltil.progressDialog(WarningActivity.this,message);
        dataListWarning();
        dialogUltil.dismissProgressDialog();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Common.checkPreference = false;
                Warning warning = listWarning.get(i);
                preferences = getSharedPreferences(Common.FILE_NAME, Activity.MODE_PRIVATE);
                preferences.edit().putString("LAT", warning.getmLatWarning() + "").commit();
                preferences.edit().putString("LNG", warning.getmLngWarning() + "").commit();
                preferences.edit().putString("TITLE", warning.getCategoryWarning() + "").commit();
                preferences.edit().putString("SNIPPET", warning.getAddressWarning() + "").commit();

                WarningActivity.this.finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataListWarning();
    }

    private void runFadeInAnimation() {
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        swipeRefreshLayout.clearAnimation();
        swipeRefreshLayout.startAnimation(slide_down);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        for(int i = listWarning.size() - 1; i >= 0; i--){
            listWarning.remove(i);
        }
        dataListWarning();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        for(int i = listWarning.size() - 1; i >= 0; i--){
            listWarning.remove(i);
        }
    }


    public void dataListWarning(){
        listWarning = warningAPI.getWarning();
        Collections.sort(listWarning, new Comparator<Warning>() {

            @Override
            public int compare(Warning warning, Warning t1) {
                if (warning.getId() < t1.getId()) {
                    return 1;
                }

                return -1;
            }
        });

        warningAdapter = new WarningAdapter(WarningActivity.this, R.layout.item_warning, listWarning);
        listView.setAdapter(warningAdapter);
        warningAdapter.notifyDataSetChanged();
    }
}
