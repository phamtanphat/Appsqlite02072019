package com.example.sqlite02072019;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

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
        sqLite.onQuery(createTable);

        //them du lieu
//        String insert = "INSERT INTO Sinhvien VALUES(null,'Nguyễn Văn A','Quận 1',1990)";
//        sqLite.onQuery(insert);

        // lấy dữ liệu trong database
//        String data = "SELECT Id , Ten ,Diachi ,Namsinh FROM Sinhvien";
//        Cursor cursor = sqLite.getData(data);
//        while (cursor.moveToNext()){
//            int id = cursor.getInt(0);
//            String ten = cursor.getString(1);
//            String diachi = cursor.getString(2);
//            int namsinh = cursor.getInt(3);
//
//            int indexcotdiachi = cursor.getColumnIndex("Diachi");
//        }
    }
}
