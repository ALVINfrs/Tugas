package com.penggajian;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class utama untuk menjalankan aplikasi penggajian.
 * Berfungsi untuk menerima input dari user dan menampilkan output.
 */
public class AplikasiPenggajian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("   PROGRAM PENGGAJIAN KARYAWAN SEDERHANA");
        System.out.println("=============================================");

        try {
            System.out.print("Masukkan NIK      : ");
            String nik = scanner.nextLine();

            System.out.print("Masukkan Nama     : ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan Jabatan (Manager/Supervisor/Staff): ");
            String jabatan = scanner.nextLine();

            System.out.print("Masukkan Golongan (1/2/3) : ");
            int golongan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline character dari buffer

            // Validasi input sederhana
            if (nik.isEmpty() || nama.isEmpty() || jabatan.isEmpty()) {
                System.out.println("\n[ERROR] NIK, Nama, dan Jabatan tidak boleh kosong.");
                scanner.close();
                return;
            }

            // Membuat objek Karyawan dari input user
            Karyawan karyawan = new Karyawan(nik, nama, jabatan, golongan);

            // Membuat objek HitungGaji untuk memproses data gaji
            HitungGaji dataGaji = new HitungGaji(karyawan);

            // Menampilkan slip gaji
            dataGaji.tampilkanSlipGaji();

        } catch (InputMismatchException e) {
            System.out.println("\n[ERROR] Input untuk golongan harus berupa angka. Silakan coba lagi.");
        } finally {
            scanner.close();
            System.out.println("\nTerima kasih telah menggunakan program ini.");
        }
    }
}
