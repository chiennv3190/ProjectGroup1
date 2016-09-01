package com.example.chien.projectgroup1;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chien.projectgroup1.adapter.BankAdapter;
import com.example.chien.projectgroup1.adapter.NavItemAdapter;
import com.example.chien.projectgroup1.common.Common;
import com.example.chien.projectgroup1.model.Bank;
import com.example.chien.projectgroup1.model.LocationATM;
import com.example.chien.projectgroup1.model.LocationCoffee;
import com.example.chien.projectgroup1.model.LocationGas;
import com.example.chien.projectgroup1.model.NavDrawerItem;
import com.example.chien.projectgroup1.model.Warning;
import com.example.chien.projectgroup1.network.JSONParser;
import com.example.chien.projectgroup1.network.WarningAPI;
import com.example.chien.projectgroup1.ultil.DeviceInformationUltil;
import com.example.chien.projectgroup1.ultil.DialogUltil;
import com.example.chien.projectgroup1.ultil.DirectionsJSONParser;
import com.example.chien.projectgroup1.ultil.LocationProvider;
import com.example.chien.projectgroup1.ultil.SendLocationBroadCastReceiver;
import com.example.chien.projectgroup1.ultil.SendWarningAccidentBroadCastReceiver;
import com.example.chien.projectgroup1.ultil.SendWarningJamBroadCastReceiver;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback, LocationProvider.LocationCallback, AdapterView.OnItemClickListener {

    private SupportMapFragment mapFragment;
    private GoogleMap mMap;
    public static final String TAG = MainActivity.class.getSimpleName();
    private LocationProvider mLocationProvider;
    private ArrayList<LocationGas> listGas;
    private ArrayList<Bank> listBank;
    private ArrayList<LocationATM> listATM;
    private ArrayList<LocationATM> listSearchATM;
    private ArrayList<LocationCoffee> listCoffee;
    private int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    private BankAdapter bankAdapter;
    private Dialog dialogBank;
    private ListView lvBank;
    private double currentLatitude;
    private double currentLongitude;
    private Toolbar toolbar;

    private JSONParser jsonParser = new JSONParser();
    private String address = "";
    private int category_Id;
    private String create_time = "";

    private DialogUltil dialogUltil = new DialogUltil();
    private WarningAPI warningAPI = new WarningAPI();
    private String message;
    private boolean isShowMyLocation = false;
    private SharedPreferences preferences;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private PendingIntent pendingIntentWarningJam;
    private PendingIntent pendingIntentWarningAccident;

    private ListView lvNav;
    private ArrayList<NavDrawerItem> arrayListNav;
    private NavItemAdapter navItemAdapter;
    private DrawerLayout drawerLayout;
    private LinearLayout nav_draw;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav_draw = (LinearLayout) findViewById(R.id.nav_draw);

        lvNav = (ListView) findViewById(R.id.lvNav);
        arrayListNav = new ArrayList<NavDrawerItem>();
        arrayListNav.add(new NavDrawerItem("Cảnh báo", R.mipmap.warning));
        arrayListNav.add(new NavDrawerItem("Cây xăng", R.mipmap.gas_station));
        arrayListNav.add(new NavDrawerItem("Tất cả ATM", R.mipmap.atm));
        arrayListNav.add(new NavDrawerItem("ATM theo ngân hàng", R.mipmap.bank));
        arrayListNav.add(new NavDrawerItem("Coffee", R.mipmap.cafe));
        navItemAdapter = new NavItemAdapter(MainActivity.this, R.layout.item_listview_nav, arrayListNav);
        lvNav.setAdapter(navItemAdapter);
        lvNav.setOnItemClickListener(this);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        if (!DeviceInformationUltil.checkGPSEnable(this)) {
            dialogUltil.showGPSDisabledAlertToUser(MainActivity.this);
        }

        Common.device_id = DeviceInformationUltil.getDeviceUniqueID(MainActivity.this);

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        //send location
        Intent i = new Intent(MainActivity.this, SendLocationBroadCastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, i, 0);
        //send warning jam
        Intent iWarningJam = new Intent(MainActivity.this, SendWarningJamBroadCastReceiver.class);
        pendingIntentWarningJam = PendingIntent.getBroadcast(MainActivity.this, 0, iWarningJam, 0);
        //send warning accident
        Intent iWarningAccident = new Intent(MainActivity.this, SendWarningAccidentBroadCastReceiver.class);
        pendingIntentWarningAccident = PendingIntent.getBroadcast(MainActivity.this, 0, iWarningAccident, 0);
    }


    @Override
    protected void onResume() {
        super.onResume();

        if (!"".equals(preferences) && Common.checkPreference == false) {
            Common.checkPreference = true;
            preferences = getSharedPreferences(Common.FILE_NAME, Activity.MODE_PRIVATE);
            String lat = preferences.getString("LAT", "");
            String lng = preferences.getString("LNG", "");
            String title = preferences.getString("TITLE", "");
            String snippet = preferences.getString("SNIPPET", "");
            LatLng warning = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));

            mMap.addMarker(new MarkerOptions()
                    .position(warning)
                    .title(title)
                    .snippet(snippet)
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(warning, 15));
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.mnSearch) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0 && Common.checkButtonClick == false && DeviceInformationUltil.isNetworkConnected(this)) {
            Common.checkButtonClick = true;
            mMap.clear();
            Intent i = new Intent(MainActivity.this, WarningActivity.class);
            startActivity(i);
            drawerLayout.closeDrawer(nav_draw);
        } else if (position == 1 && Common.checkButtonClick == false && DeviceInformationUltil.isNetworkConnected(this)) {
            String message = "Loading gas. Please wait...";
            dialogUltil.progressDialog(MainActivity.this, message);

            mMap.clear();
            listGas = warningAPI.getGas();
            for (int i = 0; i < listGas.size(); i++) {
                LatLng gas = new LatLng(listGas.get(i).getmLat(), listGas.get(i).getmLng());
                mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_gas)).position(gas).title(listGas.get(i).getTitle()).snippet(listGas.get(i).getSnippet()));
            }

            dialogUltil.dismissProgressDialog();
            drawerLayout.closeDrawer(nav_draw);
        } else if (position == 2 && Common.checkButtonClick == false && DeviceInformationUltil.isNetworkConnected(this)) {
            message = "Loading ATM. Please wait...";
            dialogUltil.progressDialog(MainActivity.this, message);

            mMap.clear();
            listATM = warningAPI.getAllATM();
            for (int i = 0; i < listATM.size(); i++) {
                LatLng atm = new LatLng(listATM.get(i).getmLatATM(), listATM.get(i).getmLngATM());
                mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_atm)).position(atm).title(listATM.get(i).getTitleATM()).snippet(listATM.get(i).getSnippetATM()));
            }
            dialogUltil.dismissProgressDialog();
            drawerLayout.closeDrawer(nav_draw);
        } else if (position == 3 && Common.checkButtonClick == false && DeviceInformationUltil.isNetworkConnected(this)) {
            message = "Loading Bank. Please wait...";
            dialogUltil.progressDialog(MainActivity.this, message);

            listBank = warningAPI.getBank();
            dialogBank = new Dialog(MainActivity.this);
            dialogBank.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialogBank.setContentView(R.layout.item_listview_bank);
            lvBank = (ListView) dialogBank.findViewById(R.id.lvBank);
            bankAdapter = new BankAdapter(dialogBank.getContext(), listBank);
            lvBank.setAdapter(bankAdapter);
            bankAdapter.notifyDataSetChanged();
            lvBank.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    message = "Loading ATM. Please wait...";
                    dialogUltil.progressDialog(MainActivity.this, message);

                    String bankName = listBank.get(i).getBankName();
                    mMap.clear();
                    listSearchATM = warningAPI.getATMBank(bankName);
                    for (LocationATM locationATM : listSearchATM) {
                        LatLng atm = new LatLng(locationATM.getmLatATM(), locationATM.getmLngATM());
                        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_atm)).position(atm).title(locationATM.getTitleATM()).snippet(locationATM.getSnippetATM()));
                    }
                    dialogBank.dismiss();

                    dialogUltil.dismissProgressDialog();
                }
            });
            dialogBank.show();
            dialogUltil.dismissProgressDialog();
            drawerLayout.closeDrawer(nav_draw);
        } else if (position == 4 && Common.checkButtonClick == false && DeviceInformationUltil.isNetworkConnected(this)) {
            String message = "Loading coffee. Please wait...";
            dialogUltil.progressDialog(MainActivity.this, message);
            mMap.clear();

            listCoffee = warningAPI.getCoffee();
            for (int i = 0; i < listCoffee.size(); i++) {
                LatLng coffee = new LatLng(listCoffee.get(i).getmLat(), listCoffee.get(i).getmLng());
                mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_coffee)).position(coffee).title(listCoffee.get(i).getTitle()).snippet(listCoffee.get(i).getSnippet()));
            }

            dialogUltil.dismissProgressDialog();
            drawerLayout.closeDrawer(nav_draw);
        } else {
            dialogUltil.showDialogCheckNetwork(MainActivity.this);
        }
    }

    public void openNav(View view) {
        drawerLayout.openDrawer(nav_draw);
    }

    public void openSearch(View view) {
        try {
            AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                    .setTypeFilter(AutocompleteFilter.TYPE_FILTER_REGIONS).setTypeFilter(AutocompleteFilter.TYPE_FILTER_GEOCODE)
                    .build();
            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(typeFilter)
                            .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }
    }
    //canh bao tac duong

    public void warningJam(View view) {
        if (!DeviceInformationUltil.isNetworkConnected(this)) {
            dialogUltil.showDialogCheckNetwork(MainActivity.this);
        } else if (!DeviceInformationUltil.checkGPSEnable(this)) {
            dialogUltil.showGPSDisabledAlertToUser(this);
        } else if (Common.isCheckSendWardningJam == false) {
            dialogUltil.showDialogCheckSendWarningFail(MainActivity.this);
        } else if (Common.checkButtonClick == false) {
            Common.checkButtonClick = true;
            alarmManager.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(), /*thoi diem thuc hien cong viec*/
                    20000, /*thoi gian thuc hien lai cong viec*/
                    pendingIntentWarningJam /*cong viec muon thuc hien*/
            );
            category_Id = 1;
            mLocationProvider = new LocationProvider(MainActivity.this, this);
            mLocationProvider.connect();
            new getAddress().execute();
            dialogCheckSendWarning();
        }

    }

    //canh bao tai nan
    public void warningAccident(View view) {
        if (!DeviceInformationUltil.isNetworkConnected(this)) {
            dialogUltil.showDialogCheckNetwork(MainActivity.this);
        } else if (!DeviceInformationUltil.checkGPSEnable(this)) {
            dialogUltil.showGPSDisabledAlertToUser(this);
        } else if (Common.isCheckSendWardningAccident == false) {
            dialogUltil.showDialogCheckSendWarningFail(MainActivity.this);
        } else if (Common.checkButtonClick == false) {
            Common.checkButtonClick = true;
            alarmManager.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(), /*thoi diem thuc hien cong viec*/
                    20000, /*thoi gian thuc hien lai cong viec*/
                    pendingIntentWarningAccident /*cong viec muon thuc hien*/
            );
            category_Id = 2;
            mLocationProvider = new LocationProvider(MainActivity.this, this);
            mLocationProvider.connect();
            new getAddress().execute();
            dialogCheckSendWarning();
        }

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mLocationProvider = new LocationProvider(this, this);
        mLocationProvider.connect();

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (DeviceInformationUltil.isNetworkConnected(MainActivity.this)) {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(marker.getPosition()).title(marker.getTitle()).snippet(marker.getSnippet()));
                    LatLng dest = marker.getPosition();
                    LatLng origin = new LatLng(currentLatitude, currentLongitude);
                    String url = getDirectionsUrl(origin, dest);
                    new DownloadTask().execute(url);
                } else {
                    dialogUltil.showDialogCheckNetwork(MainActivity.this);
                }

            }
        });

        alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(), /*thoi diem thuc hien cong viec*/
                10000, /*thoi gian thuc hien lai cong viec*/
                pendingIntent /*cong viec muon thuc hien*/
        );

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        alarmManager.cancel(pendingIntent);
    }

    private void dialogCheckSendWarning() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Bạn có chắc muốn gửi thông tin cảnh báo này không?");
        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if ("".equals(address)) {
                    Toast.makeText(MainActivity.this, "Loi khong lay duoc dia chi hien tai cua ban!", Toast.LENGTH_LONG).show();
                } else {
                    if (category_Id == 1) {
                        Common.isCheckSendWardningJam = false;
                    } else {
                        Common.isCheckSendWardningAccident = false;
                    }
                    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    create_time = df.format(Calendar.getInstance().getTime());
                    Warning warning = new Warning(currentLatitude, currentLongitude, address, category_Id, create_time);
                    warningAPI.addWarning(warning);
                    dialogUltil.showDialogCheckSendWarningSuccess(MainActivity.this);
                    Common.checkButtonClick = false;
                }
            }

        });

        alertDialogBuilder.setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Common.checkButtonClick = false;
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    //lay vi tri va di chuyen camera den vi tri
    @Override
    public void handleNewLocation(Location location) {
        Log.d(TAG, location.toString());

        currentLatitude = location.getLatitude();
        currentLongitude = location.getLongitude();
        LatLng latLng = new LatLng(currentLatitude, currentLongitude);
        if (!isShowMyLocation) {
            isShowMyLocation = true;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                mMap.clear();
                Place place = PlaceAutocomplete.getPlace(this, data);
                mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getName().toString()));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(), 15));
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(place.getLatLng())
                        .zoom(15)
                        .build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                Log.i(TAG, "Place: " + place.getName());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.i(TAG, status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        String sensor = "sensor=false";
        String parameters = str_origin + "&" + str_dest + "&" + sensor;
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;
        return url;
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();

            br.close();

        } catch (Exception e) {

        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.chien.projectgroup1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.chien.projectgroup1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    private class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            new ParserTask().execute(result);
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;
            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();
                List<HashMap<String, String>> path = result.get(i);
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
                    points.add(position);
                }
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.RED);
            }
            mMap.addPolyline(lineOptions);
        }
    }

    class getAddress extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String jsonStr = jsonParser.getLocationInfo(currentLatitude, currentLongitude).toString();
            if (jsonStr != null) {
                JSONObject jsonObj;
                try {
                    jsonObj = new JSONObject(jsonStr);
                    String Status = jsonObj.getString("status");
                    if (Status.equalsIgnoreCase("OK")) {
                        JSONArray Results = jsonObj.getJSONArray("results");
                        JSONObject zero = Results.getJSONObject(0);
                        address = zero.getString("formatted_address");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }


}
