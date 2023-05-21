package com.example.ayurvedicsolutions.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ayurvedicsolutions.adapter.subCategoryAdapter;
import com.example.ayurvedicsolutions.model.DataModelLifeMedicine;
import com.example.ayurvedicsolutions.model.DataModelRogBeauty;
import com.example.ayurvedicsolutions.model.subCategoryModel;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "ayurveda";
    private static final int DATABASE_VERSION = 1;

    public static final String COMMON_CAUSES="common_causes";
    public static final String SYMPTOMS="symptoms";
    public static final String REMEDIES="remedies";

    public static final String ADVANTAGES="advantages";
    public static final String USES="uses";

    public MyDatabase(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @SuppressLint("Range")
    public ArrayList<DataModelRogBeauty> getdatarogbeauty(String type) {
        ArrayList<DataModelRogBeauty> data = new ArrayList<>();
        String query = "SELECT * FROM sub_category Inner join category_info on sub_category.subCategoryID=category_info.subCategoryID WHERE sub_category.Name=?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[] {type});
        cursor.moveToFirst();
        for (int i=0; i<cursor.getCount(); i++) {
            DataModelRogBeauty dataModel = new DataModelRogBeauty();
            dataModel.setCommon_causes(cursor.getString(cursor.getColumnIndex(COMMON_CAUSES)));
            dataModel.setSymptoms(cursor.getString(cursor.getColumnIndex(SYMPTOMS)));
            dataModel.setRemedies(cursor.getString(cursor.getColumnIndex(REMEDIES)));
            data.add(dataModel);
            cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return data;
    }

    @SuppressLint("Range")
    public ArrayList<DataModelLifeMedicine> getdatalifemedicine(String type) {
        ArrayList<DataModelLifeMedicine> data = new ArrayList<>();
        String query = "SELECT * FROM sub_category Inner join category_info on sub_category.subCategoryID=category_info.subCategoryID WHERE sub_category.Name=?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[] {type});
        cursor.moveToFirst();
        for (int i=0; i<cursor.getCount(); i++) {
                DataModelLifeMedicine dataModel = new DataModelLifeMedicine();
                dataModel.setAdvantages(cursor.getString(cursor.getColumnIndex(ADVANTAGES)));
                dataModel.setUses(cursor.getString(cursor.getColumnIndex(USES)));
                data.add(dataModel);
                cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return data;
    }

    public String getmainID(String cat) {
        String query = "select main_category.mainCategoryID from main_category inner join sub_category on sub_category.mainCategoryID=main_category.mainCategoryID where sub_category.Name=?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[] {cat});
        cursor.moveToFirst();
        @SuppressLint("Range") String str = cursor.getString(cursor.getColumnIndex("mainCategoryID"));
        return str;
    }


    @SuppressLint("Range")
    public ArrayList<subCategoryModel> getsubcatlist(String cat) {
        ArrayList<subCategoryModel> data = new ArrayList<>();
        String query = "SELECT Name FROM main_category Inner join sub_category on main_category.mainCategoryID=sub_category.mainCategoryID WHERE main_category.Category=?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[] {cat});
        cursor.moveToFirst();
        for (int i=0; i<cursor.getCount(); i++) {
            subCategoryModel dataModel = new subCategoryModel();
            dataModel.setName(cursor.getString(cursor.getColumnIndex("Name")));
            data.add(dataModel);
            cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return data;
    }
}
