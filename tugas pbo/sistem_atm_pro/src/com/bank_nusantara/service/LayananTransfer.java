package com.bank_nusantara.service;

import com.bank_nusantara.config.KonfigurasiAtm;
import com.bank_nusantara.exception.AtmException;
import com.bank_nusantara.exception.SaldoTidakCukupException;
import com.bank_nusantara.model.akun.Akun;
import com.bank_nusantara.model.transaksi.StatusTransaksi;
import com.bank_nusantara.model.transaksi.Transfer;
import com.bank_nusantara.repository.AkunRepository;

public class LayananTransfer {
    private final LayananAkun layananAkun;
    private final AkunRepository akunRepository;

    public LayananTransfer(LayananAkun layananAkun, AkunRepository akunRepository) {
        this.layananAkun = layananAkun;
        this.akunRepository = akunRepository;
    }

    public void eksekusi(Akun akunAsal, String noRekTujuan, double jumlah) throws AtmException {
        Akun akunTujuan = akunRepository.findByNomorRekening(noRekTujuan);
        if (akunTujuan == null) {
            throw new AtmException("Nomor rekening tujuan tidak ditemukan.");
        }

        double totalDebit = jumlah + KonfigurasiAtm.BIAYA_ADMIN_TRANSFER;

        try {
            layananAkun.debit(akunAsal, totalDebit);
            layananAkun.kredit(akunTujuan, jumlah);
            akunAsal.tambahTransaksi(new Transfer(jumlah, noRekTujuan, StatusTransaksi.BERHASIL));
        } catch (SaldoTidakCukupException e) {
            akunAsal.tambahTransaksi(new Transfer(jumlah, noRekTujuan, StatusTransaksi.GAGAL));
            throw new SaldoTidakCukupException("Saldo tidak cukup untuk transfer dan biaya admin.");
        }
    }
}
