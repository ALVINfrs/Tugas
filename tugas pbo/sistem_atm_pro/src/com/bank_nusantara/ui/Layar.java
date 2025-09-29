package com.bank_nusantara.ui;

import com.bank_nusantara.util.FormatUang;
import java.util.Scanner;

public class Layar {
    private final Scanner scanner = new Scanner(System.in);

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }

    public void tampilkanPesanBarisBaru(String pesan) {
        System.out.print(pesan);
    }

    public String bacaInput() {
        return scanner.nextLine();
    }

    public void jeda() {
        System.out.println("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    public void bersihkanLayar() {
        // Simulasi membersihkan layar dengan mencetak banyak baris baru
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public void tampilkanMenuUtama(String namaNasabah) {
        bersihkanLayar();
        System.out.println("========================================");
        System.out.println("Selamat Datang, " + namaNasabah);
        System.out.println("========================================");
        System.out.println("1. Tarik Tunai");
        System.out.println("2. Transfer");
        System.out.println("3. Cek Saldo");
        System.out.println("4. Keluar");
        System.out.println("========================================");
    }

    public void tampilkanStrukTarikTunai(String noRek, double jumlah, double sisaSaldo) {
        bersihkanLayar();
        System.out.println("===== STRUK TARIK TUNAI =====");
        System.out.println("No. Rekening : " + noRek);
        System.out.println("Jumlah Tarik : " + FormatUang.toRupiah(jumlah));
        System.out.println("Sisa Saldo   : " + FormatUang.toRupiah(sisaSaldo));
        System.out.println("=============================");
    }
    
    public void tampilkanStrukTransfer(String noRekAsal, String noRekTujuan, double jumlah, double biayaAdmin, double sisaSaldo) {
        bersihkanLayar();
        System.out.println("===== STRUK TRANSFER =====");
        System.out.println("No. Rekening Asal   : " + noRekAsal);
        System.out.println("No. Rekening Tujuan : " + noRekTujuan);
        System.out.println("Jumlah Transfer     : " + FormatUang.toRupiah(jumlah));
        System.out.println("Biaya Admin         : " + FormatUang.toRupiah(biayaAdmin));
        System.out.println("Sisa Saldo          : " + FormatUang.toRupiah(sisaSaldo));
        System.out.println("========================");
    }
}
