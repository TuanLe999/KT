package com.example.myapp;

public class Police {
    int id, hinhAnh,sao;
    String ten,capBac,quocGia,noiCongTac;


    public Police() {
    }

    public Police(int hinhAnh, int sao, int id, String ten, String capBac, String quocGia, String noiCongTac) {
        this.hinhAnh = hinhAnh;
        this.sao = sao;
        this.id = id;
        this.ten = ten;
        this.capBac = capBac;
        this.quocGia = quocGia;
        this.noiCongTac = noiCongTac;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public void setNoiCongTac(String noiCongTac) {
        this.noiCongTac = noiCongTac;
    }





}
