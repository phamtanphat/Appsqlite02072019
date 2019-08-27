package com.example.sqlite02072019;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SinhvienAdapter extends RecyclerView.Adapter<SinhvienAdapter.Holder> {

    private ArrayList<Sinhvien> sinhviens;

    public SinhvienAdapter(ArrayList<Sinhvien> sinhviens) {
        this.sinhviens = sinhviens;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_sinhvien,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Sinhvien sinhvien = sinhviens.get(position);
        holder.txtTen.setText(String.format("Ten sinh vien : %s",sinhvien.getTen()));
        holder.txtDiachi.setText(String.format("Dia chi : %s",sinhvien.getDiachi()));
        holder.txtNamsinh.setText(String.format("Nam sinh : %d",sinhvien.getNamsinh()));

    }

    @Override
    public int getItemCount() {
        return sinhviens != null ? sinhviens.size() : 0;
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView txtTen,txtDiachi,txtNamsinh;
        Button btnXoa;
        public Holder(@NonNull View itemView) {
            super(itemView);
            txtDiachi = itemView.findViewById(R.id.textviewDiachi);
            txtTen = itemView.findViewById(R.id.textviewTen);
            txtNamsinh = itemView.findViewById(R.id.textviewNamsinh);
            btnXoa = itemView.findViewById(R.id.buttonXoa);
            btnXoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String delete = String.format("DELETE FROM Sinhvien WHERE Id = %s",sinhviens.get(getLayoutPosition()).getId());
                }
            });
        }
    }
}
