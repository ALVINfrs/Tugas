package com.bank_nusantara.model.transaksi;

import java.time.LocalDateTime;
import java.util.UUID;

public class TarikTunai implements Transaksi {
    private final String id;
    private final LocalDateTime waktu;
    private final double jumlah;
    private final StatusTransaksi status;

    public TarikTunai(double jumlah, StatusTransaksi status) {
        this.id = UUID.randomUUID().toString();
        this.waktu = LocalDateTime.now();
        this.jumlah = jumlah;
        this.status = status;
    }

    @Override
    public String getId() { return id; }

    @Override
    public LocalDateTime getWaktu() { return waktu; }

    @Override
    public TipeTransaksi getTipe() { return TipeTransaksi.TARIK_TUNAI; }

    @Override
    public StatusTransaksi getStatus() { return status; }

    @Override
    public double getJumlah() { return jumlah; }

    @Override
    public String getDetail() {
        return "Tarik Tunai Sejumlah " + jumlah;
    }
}
