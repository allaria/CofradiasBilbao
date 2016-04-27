package com.cofradias.android.model.callback;

import com.cofradias.android.model.Cofradia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alaria on 25/04/2016.
 */
public interface CofradiaService {
    //https://gist.githubusercontent.com/allaria/7d8b54b0bb755b7eb8abbffba25b6557/raw/9042a91e32103347c3954880a4c49a639de545b8/cofradiasv1.json

    @GET("/allaria/7d8b54b0bb755b7eb8abbffba25b6557/raw/f6182d32ecf405453abb2c49d92a3cc803ee4921/cofradiasv1.json")
    Call<List<Cofradia>> getAllCofradias();
}
