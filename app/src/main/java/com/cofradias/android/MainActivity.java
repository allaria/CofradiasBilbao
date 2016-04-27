package com.cofradias.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.cofradias.android.controller.RestManager;
import com.cofradias.android.model.Cofradia;
import com.cofradias.android.model.adapter.CofradiaAdapter;
import com.cofradias.android.model.help.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements CofradiaAdapter.CofradiaClickListener{
    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private CofradiaAdapter mCofradiaAdapter;
    private ImageView mIntroPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();

        mIntroPhoto = (ImageView) findViewById(R.id.introPhoto);
        Picasso.with(getApplicationContext()).load(R.drawable.intro_photo).into(mIntroPhoto);

        mManager = new RestManager();
        Call<List<Cofradia>> listCall = mManager.getCofradiaService().getAllCofradias();
        listCall.enqueue(new Callback<List<Cofradia>>() {
            @Override
            public void onResponse(Call<List<Cofradia>> call, Response<List<Cofradia>> response) {

                if (response.isSuccessful()) {
                    List<Cofradia> cofradiaList = response.body();

                    for (int i=0; i<cofradiaList.size(); i++){
                        Cofradia cofradia = cofradiaList.get(i);
                        mCofradiaAdapter.addCofradia(cofradia);
                    }
                }else{
                    int sc = response.code();
                    switch (sc){
                        case 400:
                            Log.e("Error 400", "Bad Request");
                            break;
                        case 404:
                            Log.e("Error 404", "Not Found");
                            break;
                        default:
                            Log.e("Error", "Generic Error");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Cofradia>> call, Throwable t) {

            }
        });
    }

    private void configViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        mCofradiaAdapter = new CofradiaAdapter(this);

        mRecyclerView.setAdapter(mCofradiaAdapter);
    }

    @Override
    public void onClick(int position) {
        Cofradia selectedCofradia = mCofradiaAdapter.getSelectedCofradia(position);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.COFRADIA, selectedCofradia);
        startActivity(intent);
    }
}
