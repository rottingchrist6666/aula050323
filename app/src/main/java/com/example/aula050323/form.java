package com.example.aula050323;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class form extends SQLiteOpenHelper {
    private Context context;

    public form(@Nullable Context activity, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(activity, name, factory, version);
        this.context = activity;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
