package com.tokoku.model;

/**
 * Kelas POJO (Plain Old Java Object) untuk merepresentasikan data produk.
 * Menggunakan prinsip encapsulation dengan field privat dan getter publik.
 */
public class Produk {
    private String id;
    private String nama;
    private double harga;

    public Produk(String id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Nama: %-20s | Harga: Rp %,.2f", id, nama, harga);
    }
}
