package com.tokoku.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Merepresentasikan satu transaksi penjualan yang terdiri dari banyak ItemPenjualan.
 * Menggunakan Composition.
 */
public class Penjualan {
    private final String idTransaksi;
    private final LocalDateTime waktuTransaksi;
    private final List<ItemPenjualan> daftarItem;
    private double totalBelanja;
    private double jumlahDiskon;
    private double totalSetelahDiskon;

    public Penjualan() {
        this.idTransaksi = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.waktuTransaksi = LocalDateTime.now();
        this.daftarItem = new ArrayList<>();
    }

    /**
     * Menambahkan item ke dalam transaksi penjualan saat ini.
     * @param item Item yang akan ditambahkan.
     */
    public void tambahItem(ItemPenjualan item) {
        this.daftarItem.add(item);
    }

    /**
     * Menghitung total belanja dari semua item dalam daftar.
     */
    public void hitungTotal() {
        this.totalBelanja = 0;
        for (ItemPenjualan item : daftarItem) {
            this.totalBelanja += item.getSubtotal();
        }
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getWaktuTransaksiFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return waktuTransaksi.format(formatter);
    }

    public List<ItemPenjualan> getDaftarItem() {
        return daftarItem;
    }

    public double getTotalBelanja() {
        return totalBelanja;
    }

    public double getJumlahDiskon() {
        return jumlahDiskon;
    }

    public void setJumlahDiskon(double jumlahDiskon) {
        this.jumlahDiskon = jumlahDiskon;
    }

    public double getTotalSetelahDiskon() {
        return totalSetelahDiskon;
    }

    public void setTotalSetelahDiskon(double totalSetelahDiskon) {
        this.totalSetelahDiskon = totalSetelahDiskon;
    }
}
