package com.cofradias.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cofradias.android.model.Cofradia;
import com.cofradias.android.model.help.Constants;

/**
 * Created by alaria on 21/04/2016.
 */
public class DetailActivity extends AppCompatActivity {

    //private ImageView mPhoto;
    private TextView mName, mFundacion, mSede, mPasos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Cofradia cofradia = (Cofradia) intent.getSerializableExtra(Constants.REFERENCE.COFRADIA);

        configViews();

        mName.setText(cofradia.getNombreCofradia());
        mFundacion.setText(String.valueOf(cofradia.getFundacion()));
        mSede.setText(cofradia.getSede());
        mPasos.setText(String.valueOf(cofradia.getNumeroPasos()));

        //mPrice.setText(String.format("$%.2f", cofradia.getPrice()));
        //Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/" + cofradia.getPhoto()).into(mPhoto);
        
    }

    private void configViews() {
        mName = (TextView) findViewById(R.id.cofradiaName);
        mFundacion = (TextView) findViewById(R.id.cofradiaFundacion);
        mSede = (TextView) findViewById(R.id.cofradiaSede);
        mPasos = (TextView) findViewById(R.id.cofradiaPasos);
        //mPrice = (TextView) findViewById(R.id.CofradiaPrice);
        //mPhoto = (ImageView) findViewById(R.id.CofradiaPhoto);
    }
}
