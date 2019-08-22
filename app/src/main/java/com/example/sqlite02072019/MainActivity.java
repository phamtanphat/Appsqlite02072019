package com.example.sqlite02072019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sqlite02072019.db.SQLite;

public class MainActivity extends AppCompatActivity {

    SQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tao database
        sqLite = new SQLite(this,"Quanlysinhvien.sql",null,1);

        //tao table
        String createTable = "CREATE TABLE IF NOT EXISTS Sinhvien(Id INTEGER PRIMARY KEY AUTOINCREMENT , Ten VARCHAR , Diachi VARCHAR , Namsinh INTEGER)";
    }
}
