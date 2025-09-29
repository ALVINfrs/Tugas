package com.tokoku.ui;

import com.tokoku.model.ItemPenjualan;
import com.tokoku.model.Penjualan;
import com.tokoku.model.Produk;
import com.tokoku.service.KasirService;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kelas yang bertanggung jawab penuh untuk interaksi dengan pengguna via konsol.
 * Tidak mengandung logika bisnis sama sekali (prinsip Separation of Concerns).
 */
public class TampilanKonsol {
    private final KasirService kasirService;
    private final Scanner scanner;

    public TampilanKonsol(KasirService kasirService) {
        this.kasirService = kasirService;
        this.scanner = new Scanner(System.in);
    }

    public void mulai() {
        System.out.println("===== SELAMAT DATANG DI SISTEM KASIR TOKOKU =====");
        kasirService.buatPenjualanBaru();

        while (true) {
            tampilkanMenuUtama();
            System.out.print("Pilih opsi: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    tambahItemBelanja();
                    break;
                case "2":
                    selesaikanDanCetakStruk();
                    return; // Keluar dari loop dan aplikasi
                case "3":
                    System.out.println("Membatalkan transaksi...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void tampilkanMenuUtama() {
        System.out.println("\n--- MENU TRANSAKSI ---");
        System.out.println("1. Tambah Item Belanja");
        System.out.println("2. Selesaikan & Cetak Struk");
        System.out.println("3. Batalkan Transaksi");
    }

    private void tampilkanDaftarProduk() {
        System.out.println("\n--- DAFTAR PRODUK ---");
        for (Produk p : kasirService.getProdukRepository().findAll()) {
            System.out.println(p);
        }
        System.out.println("-----------------------");
    }

    private void tambahItemBelanja() {
        tampilkanDaftarProduk();
        try {
            System.out.print("Masukkan ID Produk: ");
            String idProduk = scanner.nextLine().toUpperCase();

            System.out.print("Masukkan Kuantitas: ");
            int kuantitas = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer scanner

            kasirService.tambahProdukKeKeranjang(idProduk, kuantitas);
            System.out.println("-> Item berhasil ditambahkan ke keranjang.");

        } catch (InputMismatchException e) {
            System.err.println("Error: Kuantitas harus berupa angka.");
            scanner.nextLine(); // Membersihkan buffer scanner dari input yang salah
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void selesaikanDanCetakStruk() {
        try {
            Penjualan penjualan = kasirService.selesaikanPenjualan();
            cetakStruk(penjualan);
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void cetakStruk(Penjualan penjualan) {
        System.out.println("\n\n==================================================");
        System.out.println("               STRUK BELANJA TOKOKU");
        System.out.println("==================================================");
        System.out.println("ID Transaksi : " + penjualan.getIdTransaksi());
        System.out.println("Waktu        : " + penjualan.getWaktuTransaksiFormatted());
        System.out.println("--------------------------------------------------");

        System.out.printf("%-20s %-5s %-12s %-12s\n", "Nama Produk", "Qty", "Harga", "Subtotal");
        System.out.println("--------------------------------------------------");

        for (ItemPenjualan item : penjualan.getDaftarItem()) {
            Produk p = item.getProduk();
            System.out.printf("%-20s %-5d Rp %-10.2f Rp %-10.2f\n",
                    p.getNama(),
                    item.getKuantitas(),
                    p.getHarga(),
                    item.getSubtotal());
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Total Belanja       : Rp %,.2f\n", penjualan.getTotalBelanja());
        System.out.printf("Diskon              : Rp %,.2f\n", penjualan.getJumlahDiskon());
        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL BAYAR         : Rp %,.2f\n", penjualan.getTotalSetelahDiskon());
        System.out.println("==================================================");
        System.out.println("           TERIMA KASIH TELAH BERBELANJA");
        System.out.println("==================================================\n");
    }
}
