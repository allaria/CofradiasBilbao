package com.cofradias.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cofradias.android.model.Cofradia;
import com.cofradias.android.model.help.Constants;
import com.squareup.picasso.Picasso;

/**
 * Created by alaria on 21/04/2016.
 */
public class DetailActivity extends AppCompatActivity {

    private ImageView mVerMapa;
    private TextView mName, mFundacion, mSede, mPasos, mTexto, mHernamoAbad, mTunica;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Cofradia cofradia = (Cofradia) intent.getSerializableExtra(Constants.REFERENCE.COFRADIA);

        configViews();

        mVerMapa = (ImageView) findViewById(R.id.accessMap);
        Picasso.with(getApplicationContext()).load(Constants.VerMapa.IMG_URL).into(mVerMapa);
        mVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this,
                        "The favorite list would appear on clicking this icon",
                        Toast.LENGTH_LONG).show();
            }
        });

        mName.setText(cofradia.getNombreCofradia());
        mFundacion.setText(String.valueOf(cofradia.getFundacion()));
        mSede.setText(cofradia.getSede());
        mPasos.setText(String.valueOf(cofradia.getNumeroPasos()));
        mTexto.setText(cofradia.getTexto());
        mHernamoAbad.setText(cofradia.getHermanoAbad());
        mTunica.setText(cofradia.getTunica());

        //Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/" + cofradia.getPhoto()).into(mPhoto);
        
    }

    private void configViews() {
        mName = (TextView) findViewById(R.id.cofradiaName);
        mFundacion = (TextView) findViewById(R.id.cofradiaFundacion);
        mSede = (TextView) findViewById(R.id.cofradiaSede);
        mPasos = (TextView) findViewById(R.id.cofradiaPasos);
        mTexto = (TextView) findViewById(R.id.cofradiaTexto);
        mHernamoAbad = (TextView) findViewById(R.id.cofradiaHermanoAbad);
        mTunica = (TextView) findViewById(R.id.cofradiaTunica);

        //mPhoto = (ImageView) findViewById(R.id.CofradiaPhoto);
    }
}
