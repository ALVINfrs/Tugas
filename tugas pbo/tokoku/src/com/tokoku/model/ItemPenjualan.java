package com.tokoku.model;

/**
 * Merepresentasikan satu item dalam keranjang belanja (sebuah produk dan kuantitasnya).
 * Ini adalah contoh Composition, di mana ItemPenjualan 'has-a' Produk.
 */
public class ItemPenjualan {
    private Produk produk;
    private int kuantitas;

    public ItemPenjualan(Produk produk, int kuantitas) {
        this.produk = produk;
        this.kuantitas = kuantitas;
    }

    public Produk getProduk() {
        return produk;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    /**
     * Menghitung subtotal untuk item ini.
     * @return harga produk dikalikan dengan kuantitas.
     */
    public double getSubtotal() {
        return produk.getHarga() * kuantitas;
    }
}
