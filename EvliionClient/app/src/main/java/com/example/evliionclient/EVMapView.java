package com.example.evliionclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class EVMapView extends AppCompatActivity implements OnMapReadyCallback {


    private MapView mMapView;

    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

    private String vmake, vtype, vmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        vmodel = intent.getStringExtra("VMODEL");
        vmake = intent.getStringExtra("VMAKE");
        vtype = intent.getStringExtra("VTYPE");
        //String vmessage = String.format("A %s vehicle made by %s of model %s is added!",vtype, vmake, vmodel);
        //Toast.makeText(this, vmessage, Toast.LENGTH_LONG).show();

        setContentView(R.layout.evmapview);

        initGoogleMap(savedInstanceState);
    }

    public void done(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    private void initGoogleMap(Bundle savedInstanceState) {
        // *** IMPORTANT ***
        // MapView requires that the Bundle you pass contain _ONLY_ MapView SDK
        // objects or sub-Bundles.
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(mapViewBundle);

        mMapView.getMapAsync(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(EVMapView.this, StartChargingActivity.class);
                intent.putExtra("stationName", marker.getTitle());
                intent.putExtra("VMODEL", vmodel);
                intent.putExtra("VTYPE",vtype);
                intent.putExtra("VMAKE", vmake);
                startActivity(intent);
            }
        });
        // Preliminary Markers
        map.addMarker(new MarkerOptions().position(new LatLng(34.2493596, -118.3847136)).title("Marker1"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.2493596, -111.3837136)).title("Marker2"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.249996, -112.3871436)).title("Marker3"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.2496696, -113.3873136)).title("Marker4"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.2495596, -114.3874136)).title("Marker5"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.249996, -115.3871336)).title("Marker6"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.249896, -116.3871336)).title("Marker7"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.249796, -117.3871336)).title("Marker8"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.249696, -117.3871336)).title("Marker9"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.249596, -117.3871336)).title("Marker10"));
        map.addMarker(new MarkerOptions().position(new LatLng(35.249496, -116.3871336)).title("Marker11"));
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        map.setMyLocationEnabled(true);

    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
