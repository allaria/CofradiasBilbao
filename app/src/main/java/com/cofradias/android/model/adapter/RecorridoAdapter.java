package com.cofradias.android.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cofradias.android.R;
import com.cofradias.android.model.Recorrido;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alaria on 27/04/2016.
 */
public class RecorridoAdapter extends RecyclerView.Adapter<RecorridoAdapter.Holder>{

    private static final String TAG = RecorridoAdapter.class.getSimpleName();
    private final RecorridoClickListener mListener;
    private List<Recorrido> mRecorridos;

    public RecorridoAdapter(RecorridoClickListener listener) {
        mRecorridos = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_recorrido, null, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Recorrido currRecorrido = mRecorridos.get(position);

        String imgProcesion = currRecorrido.getImagenProcesion();

        int idDrawable = holder.itemView.getContext().getResources().getIdentifier(imgProcesion, "drawable", holder.itemView.getContext().getPackageName());
        Picasso.with(holder.itemView.getContext()).load(idDrawable).into(holder.mPhotoRecorrido);
        holder.mRecorrido.setText(currRecorrido.getNombreProcesion());
    }

    @Override
    public int getItemCount() {
        return mRecorridos.size();
    }

    public void addRecorrido(Recorrido recorrido) {
        mRecorridos.add(recorrido);
        notifyDataSetChanged();
    }

    public Recorrido getSelectedRecorrido(int position) {
        return mRecorridos.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mPhotoRecorrido;
        private TextView mRecorrido;

        public Holder(View itemView) {
            super(itemView);
            mRecorrido = (TextView) itemView.findViewById(R.id.procesionName);
            mPhotoRecorrido = (ImageView) itemView.findViewById(R.id.procesionPhoto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getLayoutPosition());
        }
    }

    public interface RecorridoClickListener {
        void onClick(int position);
    }
}
