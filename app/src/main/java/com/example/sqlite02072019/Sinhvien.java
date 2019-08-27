package com.example.sqlite02072019;

public class Sinhvien {
    private Integer id;
    private String ten;
    private String diachi;
    private Integer namsinh;

    public Sinhvien(Integer id, String ten, String diachi, Integer namsinh) {
        this.id = id;
        this.ten = ten;
        this.diachi = diachi;
        this.namsinh = namsinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Integer getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(Integer namsinh) {
        this.namsinh = namsinh;
    }
}
