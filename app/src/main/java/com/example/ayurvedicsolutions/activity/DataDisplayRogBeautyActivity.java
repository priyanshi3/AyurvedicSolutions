package com.example.ayurvedicsolutions.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ayurvedicsolutions.R;
import com.example.ayurvedicsolutions.adapter.DataAdapterRogBeauty;
import com.example.ayurvedicsolutions.db.MyDatabase;
import com.example.ayurvedicsolutions.model.DataModelRogBeauty;

import java.util.ArrayList;

public class DataDisplayRogBeautyActivity extends AppCompatActivity {

    MyDatabase db;
    RecyclerView rcvUserList;
    DataAdapterRogBeauty adapter;
    ArrayList<DataModelRogBeauty> data= new ArrayList<>();
    ImageView btnback;
    TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        db = new MyDatabase(this);
        String value = getIntent().getStringExtra("key");

        rcvUserList = findViewById(R.id.rcvUserList);
        db = new MyDatabase(this);
        data.addAll(db.getdatarogbeauty(value));
        adapter = new DataAdapterRogBeauty(data);
        rcvUserList.setLayoutManager(new GridLayoutManager(this, 1));
        rcvUserList.setAdapter(adapter);

        toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText(value);

        btnback=findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}