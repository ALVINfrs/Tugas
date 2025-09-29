package com.bank_nusantara.model.akun;

import com.bank_nusantara.model.nasabah.Kartu;
import com.bank_nusantara.model.nasabah.Nasabah;
import com.bank_nusantara.model.transaksi.Transaksi;

import java.util.ArrayList;
import java.util.List;

public class Akun {
    private final String nomorRekening;
    private String pin;
    private double saldo;
    private final Nasabah pemilik;
    private final Kartu kartu;
    private int percobaanPinGagal;
    private final List<Transaksi> riwayatTransaksi;

    public Akun(String nomorRekening, String pin, double saldo, Nasabah pemilik, Kartu kartu) {
        this.nomorRekening = nomorRekening;
        this.pin = pin;
        this.saldo = saldo;
        this.pemilik = pemilik;
        this.kartu = kartu;
        this.percobaanPinGagal = 0;
        this.riwayatTransaksi = new ArrayList<>();
    }

    public boolean isPinValid(String pin) {
        return this.pin.equals(pin);
    }

    public void tambahPercobaanPinGagal() {
        this.percobaanPinGagal++;
    }

    public void resetPercobaanPin() {
        this.percobaanPinGagal = 0;
    }

    public int getPercobaanPinGagal() {
        return percobaanPinGagal;
    }

    public void blokirKartu() {
        this.kartu.setStatus(Kartu.StatusKartu.BLOKIR);
    }

    public void tambahTransaksi(Transaksi transaksi) {
        this.riwayatTransaksi.add(transaksi);
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Nasabah getPemilik() {
        return pemilik;
    }

    public Kartu getKartu() {
        return kartu;
    }

    public List<Transaksi> getRiwayatTransaksi() {
        return riwayatTransaksi;
    }
}
