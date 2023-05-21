package com.example.ayurvedicsolutions.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayurvedicsolutions.R;
import com.example.ayurvedicsolutions.activity.DataDisplay;
import com.example.ayurvedicsolutions.model.subCategoryModel;

import java.util.ArrayList;

import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.ShapeType;

public class subCategoryAdapter extends RecyclerView.Adapter<subCategoryAdapter.dataHolder>{

    ArrayList<subCategoryModel> data;

    public subCategoryAdapter(ArrayList<subCategoryModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public dataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new subCategoryAdapter.dataHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_sub, null));
    }

    @Override
    public void onBindViewHolder(@NonNull dataHolder holder, int position) {
        holder.tvtitle.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class dataHolder extends RecyclerView.ViewHolder {

        TextView tvtitle;
        NeumorphCardView ncv;

        public dataHolder(@NonNull View itemView) {
            super(itemView);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            ncv = itemView.findViewById(R.id.ncv);

            ncv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        ncv.setShapeType(ShapeType.PRESSED);
                        Intent i = new Intent(v.getContext(), DataDisplay.class);
                        i.putExtra("sub", tvtitle.getText().toString());
                        v.getContext().startActivity(i);
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        ncv.setShapeType(ShapeType.FLAT);
                    }
                    return false;
                }
            });
        }
    }
}
