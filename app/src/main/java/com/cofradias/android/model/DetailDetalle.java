package com.cofradias.android.model;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cofradias.android.R;
import com.squareup.picasso.Picasso;

public class DetailDetalle extends Fragment {

    private Cofradia cofradia;

    private ImageView mEscudoDetailPhoto, mDetailPhoto;
    private TextView mName, mPasos, mTexto;

    View contentView;

    public void setCofradia(Cofradia cofradia) {
        this.cofradia = cofradia;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        contentView = inflater.inflate(R.layout.content_detalle_detail,container, false);

        configViews();

        String detailImg = cofradia.getEscudo();
        int idDrawable = getResources().getIdentifier(detailImg, "drawable", getContext().getPackageName());

        mEscudoDetailPhoto = (ImageView) contentView.findViewById(R.id.escudoDetailPhoto);
        Picasso.with(getContext()).load(idDrawable).into(mEscudoDetailPhoto);

        mName.setText(cofradia.getNombreCofradia());
        mPasos.setText(String.valueOf(cofradia.getNumeroPasos()));
        mTexto.setText(cofradia.getTexto());

        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    private void configViews() {

        mName = (TextView) contentView.findViewById(R.id.cofradiaName);
        mPasos = (TextView) contentView.findViewById(R.id.cofradiaPasos);
        mTexto = (TextView) contentView.findViewById(R.id.cofradiaTexto);
    }
}
