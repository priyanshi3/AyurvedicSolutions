package com.example.ayurvedicsolutions.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.ayurvedicsolutions.R;

import soup.neumorphism.NeumorphCardView;
import soup.neumorphism.ShapeType;

public class MainActivity extends AppCompatActivity {

    NeumorphCardView ncvrog, ncvlife, ncvmedicine, ncvbeauty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        findwidgetreference();
        onclick();

    }

    void findwidgetreference() {
        ncvrog=findViewById(R.id.ncvrog);
        ncvlife=findViewById(R.id.ncvlife);
        ncvmedicine=findViewById(R.id.ncvmedicine);
        ncvbeauty=findViewById(R.id.ncvbeauty);
    }

    void onclick() {
        ncvrog.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ncvrog.setShapeType(ShapeType.PRESSED);
                    Intent i = new Intent(MainActivity.this, SubCategory.class);
                    i.putExtra("key", "રોગ અને ઉપચાર");
                    startActivity(i);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ncvrog.setShapeType(ShapeType.FLAT);
                }
                return false;
            }
        });

        ncvlife.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ncvlife.setShapeType(ShapeType.PRESSED);
                    /*Intent i = new Intent(MainActivity.this, SwasthJivanSutraActivity.class);
                    startActivity(i);*/
                    Intent i = new Intent(MainActivity.this, SubCategory.class);
                    i.putExtra("key", "સ્વસ્થ જીવન સૂત્ર");
                    startActivity(i);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ncvlife.setShapeType(ShapeType.FLAT);
                }
                return false;
            }
        });

        ncvmedicine.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ncvmedicine.setShapeType(ShapeType.PRESSED);
                    /*Intent i = new Intent(MainActivity.this, AusadhiyaActivity.class);
                    startActivity(i);*/
                    Intent i = new Intent(MainActivity.this, SubCategory.class);
                    i.putExtra("key", "આયુર્વેદિક ઔષધિ");
                    startActivity(i);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ncvmedicine.setShapeType(ShapeType.FLAT);
                }
                return false;
            }
        });

        ncvbeauty.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ncvbeauty.setShapeType(ShapeType.PRESSED);
                    /*Intent i = new Intent(MainActivity.this, SaundaryaTipsActivity.class);
                    startActivity(i);*/
                    Intent i = new Intent(MainActivity.this, SubCategory.class);
                    i.putExtra("key", "આયુર્વેદિક સૌંદર્ય ટિપ્સ");
                    startActivity(i);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ncvbeauty.setShapeType(ShapeType.FLAT);
                }
                return false;
            }
        });
    }
}