package com.cofradias.android.controller;

import com.cofradias.android.model.callback.CofradiaService;
import com.cofradias.android.model.help.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alaria on 25/04/2016.
 */
public class RestManager {
    private CofradiaService mCofradiaService;

    public CofradiaService getCofradiaService() {
        if (mCofradiaService == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mCofradiaService = retrofit.create(CofradiaService.class);
        }
        return mCofradiaService;
    }
}
