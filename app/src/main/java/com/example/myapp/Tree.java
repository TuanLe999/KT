package com.example.myapp;

public class Tree {
    String ten,dacTinh,mauLa;
    int hinhAnh;

    public Tree() {
    }

    public Tree(String ten, String dacTinh, String mauLa, int hinhAnh) {
        this.ten = ten;
        this.dacTinh = dacTinh;
        this.mauLa = mauLa;
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDacTinh() {
        return dacTinh;
    }

    public void setDacTinh(String dacTinh) {
        this.dacTinh = dacTinh;
    }

    public String getMauLa() {
        return mauLa;
    }

    public void setMauLa(String mauLa) {
        this.mauLa = mauLa;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
