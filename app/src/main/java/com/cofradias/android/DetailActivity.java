package com.cofradias.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cofradias.android.model.Cofradia;
import com.cofradias.android.model.Coordenadas;
import com.cofradias.android.model.Recorrido;
import com.cofradias.android.model.adapter.RecorridoAdapter;
import com.cofradias.android.model.help.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by alaria on 21/04/2016.
 */
public class DetailActivity extends AppCompatActivity implements RecorridoAdapter.RecorridoClickListener{

    private RecyclerView mRecyclerView;
    private RecorridoAdapter mRecorridoAdapter;

    private ImageView mVerMapa, mDetailPhoto;
    private TextView mName, mFundacion, mSede, mPasos, mTexto, mHernamoAbad, mTunica, mRecorrido;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Cofradia cofradia = (Cofradia) intent.getSerializableExtra(Constants.REFERENCE.COFRADIA);

        configViews();

        String detailImg = cofradia.getImgagenDetalle();
        int idDrawable = getResources().getIdentifier(detailImg, "drawable", getApplicationContext().getPackageName());

        mDetailPhoto = (ImageView) findViewById(R.id.detailPhoto);
        Picasso.with(getApplicationContext()).load(idDrawable).into(mDetailPhoto);

        List<Recorrido> recorridosList = cofradia.getRecorridos();
        List<Coordenadas> coordenadasList;
        for (int i=0; i<recorridosList.size(); i++){
            Recorrido recorrido = recorridosList.get(i);

            //Recogemos las coordenadas
            coordenadasList = recorrido.getCoordenadas();
            for (int x=0; x<coordenadasList.size(); x++){
                Coordenadas coordenadas = coordenadasList.get(x);
            }

            mRecorridoAdapter.addRecorrido(recorrido);
        }

//        for (int i=0; i<recorridosList.size(); i++){
//            Recorrido recorrido = recorridosList.get(i);
//            mRecorridoAdapter.addRecorrido(recorrido);
//        }

/*        mVerMapa = (ImageView) findViewById(R.id.accessMap);
        Picasso.with(getApplicationContext()).load(R.drawable.ver_mapa).into(mVerMapa);

        mVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MapsActivity.class);
                //intent.putExtra(Constants.REFERENCE.FLOWER, selectedRecorrido);
                startActivity(intent);
            }
        });*/

        mName.setText(cofradia.getNombreCofradia());
        mFundacion.setText(String.valueOf(cofradia.getFundacion()));
        mSede.setText(cofradia.getSede());
        mPasos.setText(String.valueOf(cofradia.getNumeroPasos()));
        mTexto.setText(cofradia.getTexto());
        mHernamoAbad.setText(cofradia.getHermanoAbad());
        mTunica.setText(cofradia.getTunica());
    }

    private void configViews() {
        mName = (TextView) findViewById(R.id.cofradiaName);
        mFundacion = (TextView) findViewById(R.id.cofradiaFundacion);
        mSede = (TextView) findViewById(R.id.cofradiaSede);
        mPasos = (TextView) findViewById(R.id.cofradiaPasos);
        mTexto = (TextView) findViewById(R.id.cofradiaTexto);
        mHernamoAbad = (TextView) findViewById(R.id.cofradiaHermanoAbad);
        mTunica = (TextView) findViewById(R.id.cofradiaTunica);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewDetail);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecorridoAdapter = new RecorridoAdapter(this);

        mRecyclerView.setAdapter(mRecorridoAdapter);
    }

    @Override
    public void onClick(int position) {
        Recorrido selectedRecorrido = mRecorridoAdapter.getSelectedRecorrido(position);

        Intent intent = new Intent(DetailActivity.this, MapsActivity.class);
        intent.putExtra(Constants.REFERENCE.RECORRIDO, selectedRecorrido);
        startActivity(intent);
    }
}