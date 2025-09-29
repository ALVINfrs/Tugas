package com.tokoku.service;

import com.tokoku.model.ItemPenjualan;
import com.tokoku.model.Penjualan;
import com.tokoku.model.Produk;
import com.tokoku.repository.ProdukRepository;

/**
 * Kelas service utama yang mengatur semua logika bisnis kasir.
 * Menggunakan Dependency Injection (melalui constructor) untuk mendapatkan instance
 * dari repository dan service lain. Ini adalah praktik standar industri untuk
 * mencapai loose coupling (ketergantungan yang longgar).
 */
public class KasirService {

    private final ProdukRepository produkRepository;
    private final DiskonStrategy diskonStrategy;
    private Penjualan penjualanSaatIni;

    public KasirService(ProdukRepository produkRepository, DiskonStrategy diskonStrategy) {
        this.produkRepository = produkRepository;
        this.diskonStrategy = diskonStrategy;
    }

    /**
     * Memulai sesi penjualan baru.
     */
    public void buatPenjualanBaru() {
        this.penjualanSaatIni = new Penjualan();
    }

    /**
     * Menambahkan produk ke keranjang belanja saat ini.
     * @param idProduk ID produk yang akan ditambahkan.
     * @param kuantitas Jumlah produk.
     * @throws IllegalArgumentException jika produk tidak ditemukan atau kuantitas tidak valid.
     */
    public void tambahProdukKeKeranjang(String idProduk, int kuantitas) {
        if (penjualanSaatIni == null) {
            throw new IllegalStateException("Penjualan belum dimulai. Panggil buatPenjualanBaru() terlebih dahulu.");
        }
        if (kuantitas <= 0) {
            throw new IllegalArgumentException("Kuantitas harus lebih dari 0.");
        }

        Produk produk = produkRepository.findById(idProduk);
        if (produk == null) {
            throw new IllegalArgumentException("Produk dengan ID " + idProduk + " tidak ditemukan.");
        }

        ItemPenjualan item = new ItemPenjualan(produk, kuantitas);
        penjualanSaatIni.tambahItem(item);
    }

    /**
     * Menyelesaikan transaksi, menghitung total, diskon, dan total akhir.
     * @return Objek Penjualan yang telah selesai diproses.
     * @throws IllegalStateException jika tidak ada item dalam keranjang.
     */
    public Penjualan selesaikanPenjualan() {
        if (penjualanSaatIni == null || penjualanSaatIni.getDaftarItem().isEmpty()) {
            throw new IllegalStateException("Tidak ada item dalam keranjang belanja.");
        }

        // 1. Hitung total belanja
        penjualanSaatIni.hitungTotal();
        double totalBelanja = penjualanSaatIni.getTotalBelanja();

        // 2. Hitung diskon menggunakan strategy yang di-inject
        double jumlahDiskon = diskonStrategy.hitungDiskon(totalBelanja);
        penjualanSaatIni.setJumlahDiskon(jumlahDiskon);

        // 3. Hitung total akhir
        double totalAkhir = totalBelanja - jumlahDiskon;
        penjualanSaatIni.setTotalSetelahDiskon(totalAkhir);

        return penjualanSaatIni;
    }

    public Penjualan getPenjualanSaatIni() {
        return penjualanSaatIni;
    }

    public ProdukRepository getProdukRepository() {
        return produkRepository;
    }
}
