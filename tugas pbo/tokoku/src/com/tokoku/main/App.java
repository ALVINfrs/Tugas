package com.tokoku.main;

import com.tokoku.repository.ProdukRepository;
import com.tokoku.service.DiskonMember;
import com.tokoku.service.DiskonStrategy;
import com.tokoku.service.KasirService;
import com.tokoku.ui.TampilanKonsol;

/**
 * Kelas utama (entry point) dari aplikasi.
 * Bertanggung jawab untuk "merakit" semua komponen aplikasi.
 * Ini adalah contoh dari Composition Root, tempat semua dependensi di-resolve.
 */
public class App {
    public static void main(String[] args) {
        // 1. Inisialisasi semua komponen yang dibutuhkan
        ProdukRepository produkRepository = new ProdukRepository();
        DiskonStrategy diskonStrategy = new DiskonMember(); // Bisa diganti strategi lain
        KasirService kasirService = new KasirService(produkRepository, diskonStrategy);
        TampilanKonsol tampilan = new TampilanKonsol(kasirService);

        // 2. Mulai aplikasi
        tampilan.mulai();
    }
}
