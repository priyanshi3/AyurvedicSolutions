package com.example.ayurvedicsolutions.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ayurvedicsolutions.R;
import com.example.ayurvedicsolutions.adapter.ItemOffsetDecoration;
import com.example.ayurvedicsolutions.adapter.subCategoryAdapter;
import com.example.ayurvedicsolutions.db.MyDatabase;
import com.example.ayurvedicsolutions.model.subCategoryModel;

import java.util.ArrayList;

public class SubCategory extends AppCompatActivity {

    RecyclerView rcv;
    MyDatabase db;
    subCategoryAdapter adapter;
    ArrayList<subCategoryModel> data= new ArrayList<>();
    ImageView btnback;
    TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        db = new MyDatabase(this);
        String value = getIntent().getStringExtra("key");

        rcv=findViewById(R.id.rcv);
        db = new MyDatabase(this);
        data.addAll(db.getsubcatlist(value));
        adapter = new subCategoryAdapter(data);
        rcv.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        rcv.addItemDecoration(itemDecoration);
        rcv.setAdapter(adapter);

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