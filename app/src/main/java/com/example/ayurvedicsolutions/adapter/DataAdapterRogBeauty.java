package com.example.ayurvedicsolutions.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayurvedicsolutions.R;
import com.example.ayurvedicsolutions.model.DataModelRogBeauty;

import java.util.ArrayList;

public class DataAdapterRogBeauty extends RecyclerView.Adapter<DataAdapterRogBeauty.dataHolderRogBeauty> {

    ArrayList<DataModelRogBeauty> data;

    public DataAdapterRogBeauty(ArrayList<DataModelRogBeauty> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public dataHolderRogBeauty onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new dataHolderRogBeauty(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_data_display_rog_beauty, null));
    }

    @Override
    public void onBindViewHolder(@NonNull dataHolderRogBeauty holder, int position) {
        holder.tvcommon_causes.setText(data.get(position).getCommon_causes());
        holder.tvsymptoms.setText(data.get(position).getSymptoms());
        holder.tvremedies.setText(data.get(position).getRemedies());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class dataHolderRogBeauty extends RecyclerView.ViewHolder {

        TextView tvcommon_causes, tvsymptoms, tvremedies;

        public dataHolderRogBeauty(@NonNull View itemView) {
            super(itemView);
            tvcommon_causes = itemView.findViewById(R.id.tvcommon_causes);
            tvsymptoms = itemView.findViewById(R.id.tvsymptoms);
            tvremedies = itemView.findViewById(R.id.tvremedies);
        }
    }
}
