package com.cofradias.android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.cofradias.android.model.Coordenadas;
import com.cofradias.android.model.Recorrido;
import com.cofradias.android.model.help.Constants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

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

        List<Coordenadas> coordenadasList = recorrido.getCoordenadas();
        List<LatLng> coordenadasMapa = new ArrayList<LatLng>();
        for (int i=0; i<coordenadasList.size(); i++){
            Coordenadas coordenadas = coordenadasList.get(i);

            //Log.v("Longitud - Latitud", coordenadas.getLongitud() + " - " + coordenadas.getLatitud());

            coordenadasMapa.add(new LatLng(
                            Double.parseDouble(coordenadas.getLongitud()),
                            Double.parseDouble(coordenadas.getLatitud()))
            );
        }

        LatLng inicioRecorrido = coordenadasMapa.get(0);
        mMap.setMapType(4);
        Marker miMarker = mMap.addMarker(new MarkerOptions()
                        .position(inicioRecorrido)
                        .title(recorrido.getNombreProcesion())
        );
        miMarker.showInfoWindow();

        float mxZoom = mMap.getMaxZoomLevel();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(inicioRecorrido, 16.0f));

        Polyline polyline = mMap.addPolyline(new PolylineOptions()
                .addAll(coordenadasMapa)
                .color(Color.RED)
        );

//        Polygon polygon = mMap.addPolygon(new PolygonOptions()
//                .addAll(coordenadasMapa)
//                .add(new LatLng(43.257660, -2.922303), new LatLng(43.257762, -2.922562), new LatLng(43.256986, -2.923427), new LatLng(43.255697, -2.924188), new LatLng(43.255495, -2.923472), new LatLng(43.255427, -2.922875), new LatLng(43.256639, -2.922299), new LatLng(43.257525, -2.922025), new LatLng(43.257660, -2.922303))
//                .strokeColor(Color.RED));
                //.fillColor(Color.BLUE));
    }
}
