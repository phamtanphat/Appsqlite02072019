package com.example.sqlite02072019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite02072019.db.SQLite;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLite sqLite;
    RecyclerView recyclerView;
    SinhvienAdapter msinhvienAdapter;
    ArrayList<Sinhvien> msinhviens;
    Button btnReset,btnAdd;
    EditText edtTen,edtDiachi,edtNamsinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tao database
        sqLite = new SQLite(this,"Quanlysinhvien.sql",null,1);

        recyclerView = findViewById(R.id.recyclerviewSinhvien);
        edtDiachi = findViewById(R.id.edittextDiachi);
        edtTen = findViewById(R.id.edittextTen);
        edtNamsinh= findViewById(R.id.edittextNamsinh);
        btnAdd =findViewById(R.id.buttonThem);
        btnReset = findViewById(R.id.buttonXoa);
        msinhviens = new ArrayList<>();
        msinhvienAdapter = new SinhvienAdapter(msinhviens);
        recyclerView.setAdapter(msinhvienAdapter);

        payLoad();
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtDiachi.setText("");
                edtNamsinh.setText("");
                edtTen.setText("");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                String diachi = edtDiachi.getText().toString();
                String namsinh =  edtNamsinh.getText().toString();

                if (ten.length() <= 0 || diachi.length() <= 0 || namsinh.length()<=0) return;
                try {
                    String insert = String.format("INSERT INTO Sinhvien VALUES (null , '%s' , '%s' ,%s)" , ten , diachi , namsinh);
//                String insert = "INSERT INTO Sinhvien VALUES (null , ? , ? ,?)";
                    sqLite.onQuery(insert);
                    payLoad();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    private void payLoad(){
        String data = "SELECT * FROM Sinhvien";
        Cursor cursor = sqLite.getData(data);
        if (msinhviens != null){
            msinhviens.clear();
        }
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            String diachi = cursor.getString(2);
            int namsinh = cursor.getInt(3);
            msinhviens.add(new Sinhvien(id,ten,diachi,namsinh));
            msinhvienAdapter.notifyDataSetChanged();
        }
    }

}
