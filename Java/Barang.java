/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudanginternet;

/**
 *
 * @author ASUS
 */
public class Barang {
    private int id;
    private String namaBarang;
    private String kategori;
    private double harga;
    private int stok;

    public Barang(int id, String namaBarang, String kategori, double harga, int stok) {
        this.id = id;
        setNamaBarang(namaBarang);
        setKategori(kategori);
        setHarga(harga);
        setStok(stok);
    }
    public int getId() {
        return id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        if (namaBarang == null || namaBarang.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong");
        }
        this.namaBarang = namaBarang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        if (kategori == null || kategori.trim().isEmpty()) {
            throw new IllegalArgumentException("Kategori tidak boleh kosong");
        }
        this.kategori = kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif");
        }
        this.stok = stok;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-32s %-15s Rp%-15.0f %-6d",
                id, namaBarang, kategori, harga, stok);
    }
}
