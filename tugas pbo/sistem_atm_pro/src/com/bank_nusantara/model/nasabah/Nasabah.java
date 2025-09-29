package com.bank_nusantara.model.nasabah;

public class Nasabah {
    private String nik;
    private String namaLengkap;

    public Nasabah(String nik, String namaLengkap) {
        this.nik = nik;
        this.namaLengkap = namaLengkap;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }
}
