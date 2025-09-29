package com.tokoku.repository;

import com.tokoku.model.Produk;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Bertindak sebagai simulasi database untuk produk.
 * Menggunakan Map untuk menyimpan dan mengambil data produk dengan cepat.
 * Ini adalah contoh dari Repository Pattern.
 */
public class ProdukRepository {
    private final Map<String, Produk> produkMap = new HashMap<>();

    public ProdukRepository() {
        inisialisasiData();
    }

    /**
     * Mengisi repository dengan data produk awal.
     */
    private void inisialisasiData() {
        produkMap.put("P001", new Produk("P001", "Indomie Goreng", 3500.00));
        produkMap.put("P002", new Produk("P002", "Susu Ultra Milk", 6500.00));
        produkMap.put("P003", new Produk("P003", "Teh Botol Sosro", 5000.00));
        produkMap.put("P004", new Produk("P004", "Minyak Goreng 1L", 25000.00));
        produkMap.put("P005", new Produk("P005", "Beras 5kg", 68000.00));
    }

    /**
     * Mengambil produk berdasarkan ID-nya.
     * @param id ID produk yang dicari.
     * @return Objek Produk jika ditemukan, null jika tidak.
     */
    public Produk findById(String id) {
        return produkMap.get(id);
    }

    /**
     * Mengambil semua produk yang ada di repository.
     * @return Collection dari semua objek Produk.
     */
    public Collection<Produk> findAll() {
        return produkMap.values();
    }
}
