package com.example.aula050323;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private Context activity;

    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "myfirsttable";
   EditText f1,f2,f3,f4;

    private static final String c1 = "Nome";
    private static final String c2 = "CPF";
    private static final String c3 = "Idade";
    private static final String c4 = "Email";


    public database(@Nullable Context activity) {
        super(activity, TABLE_NAME, null, DATABASE_VERSION);
        this.activity = activity;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE " + TABLE_NAME + " (" + c1 +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                c2+ " TEXT, " + c3 + " TEXT, " +c4 +"TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public void addPerson(String nome, String idade, String cpf, String email) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(c1, nome);
        cv.put(c2, cpf);
        cv.put(c3, idade);
        cv.put(c4, email);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(activity, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor displayAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }

        return cursor;

    }
}
}
