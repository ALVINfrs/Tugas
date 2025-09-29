package com.tokoku.service;

/**
 * Interface untuk Strategy Pattern.
 * Mendefinisikan kontrak untuk semua jenis algoritma diskon.
 */
public interface DiskonStrategy {
    /**
     * Menghitung diskon berdasarkan total belanja.
     * @param totalBelanja Total harga belanjaan.
     * @return Jumlah diskon yang diberikan.
     */
    double hitungDiskon(double totalBelanja);
    String getNamaDiskon();
}
