package com.penggajian;

/**
 * Class Karyawan untuk merepresentasikan data diri seorang karyawan.
 */
public class Karyawan {
    private String nik;
    private String nama;
    private String jabatan;
    private int golongan;

    /**
     * Konstruktor untuk membuat objek Karyawan.
     * @param nik Nomor Induk Karyawan.
     * @param nama Nama lengkap karyawan.
     * @param jabatan Posisi jabatan karyawan (e.g., Manager, Staff).
     * @param golongan Golongan karyawan yang mempengaruhi tunjangan.
     */
    public Karyawan(String nik, String nama, String jabatan, int golongan) {
        this.nik = nik;
        this.nama = nama;
        this.jabatan = jabatan;
        this.golongan = golongan;
    }

    // Getter methods
    public String getNik() {
        return nik;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public int getGolongan() {
        return golongan;
    }

    /**
     * Method void untuk menampilkan data dasar karyawan.
     */
    public void tampilkanInfoDasar() {
        System.out.println("NIK      : " + this.nik);
        System.out.println("Nama     : " + this.nama);
        System.out.println("Jabatan  : " + this.jabatan);
        System.out.println("Golongan : " + this.golongan);
    }
}
