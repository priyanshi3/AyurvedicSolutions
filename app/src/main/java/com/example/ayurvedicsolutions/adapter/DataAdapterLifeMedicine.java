package com.example.ayurvedicsolutions.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayurvedicsolutions.R;
import com.example.ayurvedicsolutions.model.DataModelLifeMedicine;

import java.util.ArrayList;

public class DataAdapterLifeMedicine extends RecyclerView.Adapter<DataAdapterLifeMedicine.dataHolderLifeMedicine>{
    ArrayList<DataModelLifeMedicine> data;

    public DataAdapterLifeMedicine(ArrayList<DataModelLifeMedicine> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public dataHolderLifeMedicine onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new dataHolderLifeMedicine(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_data_display_life_medicine, null));
    }

    @Override
    public void onBindViewHolder(@NonNull dataHolderLifeMedicine holder, int position) {
        holder.tvadv.setText(data.get(position).getAdvantages());
        holder.tvuses.setText(data.get(position).getUses());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class dataHolderLifeMedicine extends RecyclerView.ViewHolder {

        TextView tvadv, tvuses;

        public dataHolderLifeMedicine(@NonNull View itemView) {
            super(itemView);
            tvadv = itemView.findViewById(R.id.tvadv);
            tvuses = itemView.findViewById(R.id.tvuses);

        }
    }
}
