package com.bank_nusantara.model.nasabah;

public class Kartu {
    public enum StatusKartu { AKTIF, BLOKIR }

    private final String nomorKartu;
    private StatusKartu status;

    public Kartu(String nomorKartu) {
        this.nomorKartu = nomorKartu;
        this.status = StatusKartu.AKTIF;
    }

    public String getNomorKartu() {
        return nomorKartu;
    }

    public StatusKartu getStatus() {
        return status;
    }

    public void setStatus(StatusKartu status) {
        this.status = status;
    }

    public boolean isAktif() {
        return this.status == StatusKartu.AKTIF;
    }
}
