package com.example.sqlite02072019.db;

import android.content.Context;

import androidx.annotation.Nullable;

public class Database {
    private static SQLite instance = null;

    private Database(){

    }

    public SQLite getInstance(@Nullable Context context){
        if (instance == null){
            instance = new SQLite(context,
                    "Quanlysinhvien.sql",
                    null,
                    1);
        }
        return instance;
    }
}
