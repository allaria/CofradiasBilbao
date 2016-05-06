package com.cofradias.android.model;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cofradias.android.R;
import com.cofradias.android.model.adapter.RecorridoAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Fragment1 extends Fragment implements RecorridoAdapter.RecorridoClickListener {

    private Cofradia cofradia;

    private RecyclerView mRecyclerView;
    private RecorridoAdapter mRecorridoAdapter;

    private ImageView mVerMapa, mDetailPhoto;
    private TextView mName, mFundacion, mSede, mPasos, mTexto, mHernamoAbad, mTunica, mRecorrido;

    View contentView;
    private interfaceFragment1 listener;

    public void setCofradia(Cofradia cofradia) {
        this.cofradia = cofradia;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //contentView = inflater.inflate(R.layout.fragment1_layout, null);
        contentView = inflater.inflate(R.layout.content_detail,container, false);

        configViews();

        String detailImg = cofradia.getImgagenDetalle();
        //int idDrawable = getResources().getIdentifier(detailImg, "drawable", getApplicationContext().getPackageName());
        int idDrawable = getResources().getIdentifier(detailImg, "drawable", getContext().getPackageName());

        mDetailPhoto = (ImageView) contentView.findViewById(R.id.detailPhoto);
        //Picasso.with(getApplicationContext()).load(idDrawable).into(mDetailPhoto);
        Picasso.with(getContext()).load(idDrawable).into(mDetailPhoto);

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

        mName.setText(cofradia.getNombreCofradia());
        mFundacion.setText(String.valueOf(cofradia.getFundacion()));
        mSede.setText(cofradia.getSede());
        mPasos.setText(String.valueOf(cofradia.getNumeroPasos()));
        mTexto.setText(cofradia.getTexto());
        mHernamoAbad.setText(cofradia.getHermanoAbad());
        mTunica.setText(cofradia.getTunica());

        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    private void configViews() {
        mName = (TextView) contentView.findViewById(R.id.cofradiaName);
        mFundacion = (TextView) contentView.findViewById(R.id.cofradiaFundacion);
        mSede = (TextView) contentView.findViewById(R.id.cofradiaSede);
        mPasos = (TextView) contentView.findViewById(R.id.cofradiaPasos);
        mTexto = (TextView) contentView.findViewById(R.id.cofradiaTexto);
        mHernamoAbad = (TextView) contentView.findViewById(R.id.cofradiaHermanoAbad);
        mTunica = (TextView) contentView.findViewById(R.id.cofradiaTunica);


        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.recyclerViewDetail);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecorridoAdapter = new RecorridoAdapter(this);

        mRecyclerView.setAdapter(mRecorridoAdapter);
    }

    @Override
    public void onClick(int position) {

        listener.onClick(position, mRecorridoAdapter);
    }

    public void setListener(interfaceFragment1 listener) {
        this.listener = listener;
    }

    public interface interfaceFragment1 {

        public void onClick(int position, RecorridoAdapter mRecorridoAdapter);
    }


}
