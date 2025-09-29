package com.bank_nusantara.service;

import com.bank_nusantara.exception.AtmException;
import com.bank_nusantara.model.akun.Akun;
import com.bank_nusantara.model.bank.MesinAtm;
import com.bank_nusantara.model.transaksi.StatusTransaksi;
import com.bank_nusantara.model.transaksi.TarikTunai;

public class LayananTarikTunai {
    private final LayananAkun layananAkun;

    public LayananTarikTunai(LayananAkun layananAkun) {
        this.layananAkun = layananAkun;
    }

    public void eksekusi(Akun akun, MesinAtm mesin, double jumlah) throws AtmException {
        mesin.validasiKas(jumlah);

        try {
            layananAkun.debit(akun, jumlah);
            mesin.keluarkanUang(jumlah);
            akun.tambahTransaksi(new TarikTunai(jumlah, StatusTransaksi.BERHASIL));
        } catch (AtmException e) {
            akun.tambahTransaksi(new TarikTunai(jumlah, StatusTransaksi.GAGAL));
            throw e; // Lemparkan lagi exception setelah mencatat transaksi gagal
        }
    }
}
