package com.cofradias.android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.cofradias.android.model.Recorrido;
import com.cofradias.android.model.help.Constants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Recorrido recorrido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent intent = getIntent();

        recorrido = (Recorrido) intent.getSerializableExtra(Constants.REFERENCE.RECORRIDO);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //LatLng bilbao = new LatLng(43.262980, -2.935000);
        LatLng bilbao = new LatLng(43.257660, -2.922303);
        mMap.addMarker(new MarkerOptions().position(bilbao).title("Iglesia Santos Juanes"));
        mMap.setMapType(4);
        float mxZoom = mMap.getMaxZoomLevel();
        Log.v("ZOOM MAX", String.valueOf(mxZoom));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bilbao, 16.0f));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(bilbao));

//        Polyline line = mMap.addPolyline(new PolylineOptions()
//                .add(new LatLng(43.263190, -2.935676), new LatLng(43.265174, -2.944828))
//                .width(5)
//                .color(Color.RED));

        Polygon polygon = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(43.257660, -2.922303), new LatLng(43.257762, -2.922562), new LatLng(43.256986, -2.923427), new LatLng(43.255697, -2.924188), new LatLng(43.255495, -2.923472), new LatLng(43.255427, -2.922875), new LatLng(43.256639, -2.922299), new LatLng(43.257525, -2.922025), new LatLng(43.257660, -2.922303))
                .strokeColor(Color.RED));
                //.fillColor(Color.BLUE));
    }
}
