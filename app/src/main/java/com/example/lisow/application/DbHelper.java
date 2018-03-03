package com.example.lisow.application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper  extends SQLiteOpenHelper{
   // public static final String TABLE_NAME = "Users";
   // public static final String E_MAIL= "E-MAIL";
   // public static final String LOGIN = "LOGIN";
   // public static final String PASSWORD = "PASSWORD";
   // private static final int DATABASE_VERSION = 1; // Для обновления БД

    public DbHelper(Context context) {
        super(context, "DbForRegistration", null, 1);
    }

    @Override
    //Создаем таблицу, с заданными полями через sql команды
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Users("
                + "id integer primary key autoincrement,"
                + "E_MAIL_COLUMN text,"
                + "LOGIN_COLUMN text,"
                + "PASSWORD_COLUMN text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
