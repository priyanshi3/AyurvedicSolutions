package com.example.ayurvedicsolutions.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayurvedicsolutions.R;
import com.example.ayurvedicsolutions.adapter.DataAdapterLifeMedicine;
import com.example.ayurvedicsolutions.adapter.DataAdapterRogBeauty;
import com.example.ayurvedicsolutions.db.MyDatabase;
import com.example.ayurvedicsolutions.model.DataModelLifeMedicine;
import com.example.ayurvedicsolutions.model.DataModelRogBeauty;

import java.util.ArrayList;

public class DataDisplay extends AppCompatActivity {

    MyDatabase db;
    RecyclerView rcvUserList;
    DataAdapterLifeMedicine adapterLifeMedicine;
    ArrayList<DataModelLifeMedicine> dataLifeMedicine = new ArrayList<>();
    DataAdapterRogBeauty adapterRogBeauty;
    ArrayList<DataModelRogBeauty> dataRogBeauty = new ArrayList<>();
    ImageView btnback;
    TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        db = new MyDatabase(this);
        String value = getIntent().getStringExtra("sub");

        String str = db.getmainID(value);

        if (str.equals("1") || str.equals("4")) {
            rcvUserList = findViewById(R.id.rcvUserList);
            db = new MyDatabase(this);
            dataRogBeauty.addAll(db.getdatarogbeauty(value));
            adapterRogBeauty = new DataAdapterRogBeauty(dataRogBeauty);
            rcvUserList.setLayoutManager(new GridLayoutManager(this, 1));
            rcvUserList.setAdapter(adapterRogBeauty);
        } else {
            rcvUserList = findViewById(R.id.rcvUserList);
            db = new MyDatabase(this);
            dataLifeMedicine.addAll(db.getdatalifemedicine(value));
            adapterLifeMedicine = new DataAdapterLifeMedicine(dataLifeMedicine);
            rcvUserList.setLayoutManager(new GridLayoutManager(this, 1));
            rcvUserList.setAdapter(adapterLifeMedicine);
        }

        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar_title.setText(value);

        btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        // first parameter is the file for icon and second one is menu
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // We are using switch case because multiple icons can be kept
        switch (item.getItemId()) {
            case R.id.shareButton:

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);

                // type of the content to be shared
                sharingIntent.setType("text/plain");

                // Body of the content
                String shareBody = "Your Body Here";

                // subject of the content. you can share anything
                String shareSubject = "Your Subject Here";

                // passing body of the content
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                // passing subject of the content
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
