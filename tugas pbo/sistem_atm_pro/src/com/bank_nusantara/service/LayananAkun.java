package com.bank_nusantara.service;

import com.bank_nusantara.exception.SaldoTidakCukupException;
import com.bank_nusantara.model.akun.Akun;

public class LayananAkun {

    public void debit(Akun akun, double jumlah) throws SaldoTidakCukupException {
        if (akun.getSaldo() < jumlah) {
            throw new SaldoTidakCukupException("Saldo tidak mencukupi untuk melakukan transaksi ini.");
        }
        akun.setSaldo(akun.getSaldo() - jumlah);
    }

    public void kredit(Akun akun, double jumlah) {
        akun.setSaldo(akun.getSaldo() + jumlah);
    }

    public double cekSaldo(Akun akun) {
        return akun.getSaldo();
    }
}
