package com.bank_nusantara.model.transaksi;

import java.time.LocalDateTime;

public interface Transaksi {
    String getId();
    LocalDateTime getWaktu();
    TipeTransaksi getTipe();
    StatusTransaksi getStatus();
    double getJumlah();
    String getDetail();
}
