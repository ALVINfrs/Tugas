package com.bank_nusantara.model.bank;

import com.bank_nusantara.config.KonfigurasiAtm;
import com.bank_nusantara.exception.AtmException;
import com.bank_nusantara.exception.KasAtmTidakCukupException;
import com.bank_nusantara.model.akun.Akun;
import com.bank_nusantara.service.LayananAkun;
import com.bank_nusantara.service.LayananAutentikasi;
import com.bank_nusantara.service.LayananTarikTunai;
import com.bank_nusantara.service.LayananTransfer;
import com.bank_nusantara.ui.Layar;
import com.bank_nusantara.util.FormatUang;

public class MesinAtm {
    private enum State { OFF, MENUNGGU_KARTU, VALIDASI_PIN, MENU_UTAMA, TARIK_TUNAI, TRANSFER, CEK_SALDO, KELUAR }

    private final String idMesin;
    private double kasTersedia;
    private final Layar layar;
    private final LayananAutentikasi layananAutentikasi;
    private final LayananAkun layananAkun;
    private final LayananTarikTunai layananTarikTunai;
    private final LayananTransfer layananTransfer;

    private State state;
    private Akun akunSaatIni;

    public MesinAtm(String idMesin, double kasAwal, Layar layar, LayananAutentikasi layananAutentikasi, LayananAkun layananAkun, LayananTarikTunai layananTarikTunai, LayananTransfer layananTransfer) {
        this.idMesin = idMesin;
        this.kasTersedia = kasAwal;
        this.layar = layar;
        this.layananAutentikasi = layananAutentikasi;
        this.layananAkun = layananAkun;
        this.layananTarikTunai = layananTarikTunai;
        this.layananTransfer = layananTransfer;
        this.state = State.OFF;
    }

    public void mulai() {
        this.state = State.MENUNGGU_KARTU;
        while (this.state != State.OFF) {
            try {
                switch (state) {
                    case MENUNGGU_KARTU -> prosesMenungguKartu();
                    case VALIDASI_PIN -> prosesValidasiPin();
                    case MENU_UTAMA -> prosesMenuUtama();
                    case TARIK_TUNAI -> prosesTarikTunai();
                    case TRANSFER -> prosesTransfer();
                    case CEK_SALDO -> prosesCekSaldo();
                    case KELUAR -> prosesKeluar();
                }
            } catch (AtmException e) {
                layar.tampilkanPesan("\nERROR: " + e.getMessage());
                layar.jeda();
                // Jika error terjadi saat transaksi, kembali ke menu utama
                if (akunSaatIni != null) state = State.MENU_UTAMA; 
                else state = State.MENUNGGU_KARTU; // Jika error sebelum login
            }
        }
    }

    private void prosesMenungguKartu() throws AtmException {
        layar.bersihkanLayar();
        layar.tampilkanPesan("===== SELAMAT DATANG DI ATM BANK NUSANTARA =====");
        layar.tampilkanPesanBarisBaru("Masukkan Nomor Kartu Anda (16 digit): ");
        String noKartu = layar.bacaInput();
        this.akunSaatIni = layananAutentikasi.getAkunDariKartu(noKartu);
        if (this.akunSaatIni == null) {
            throw new AtmException("Kartu tidak terdaftar.");
        }
        this.state = State.VALIDASI_PIN;
    }

    private void prosesValidasiPin() throws AtmException {
        layar.tampilkanPesanBarisBaru("Masukkan PIN Anda (6 digit): ");
        String pin = layar.bacaInput();
        layananAutentikasi.autentikasiPin(akunSaatIni, pin);
        this.state = State.MENU_UTAMA;
    }

    private void prosesMenuUtama() {
        layar.tampilkanMenuUtama(akunSaatIni.getPemilik().getNamaLengkap());
        layar.tampilkanPesanBarisBaru("Pilih menu (1-4): ");
        String pilihan = layar.bacaInput();
        switch (pilihan) {
            case "1" -> this.state = State.TARIK_TUNAI;
            case "2" -> this.state = State.TRANSFER;
            case "3" -> this.state = State.CEK_SALDO;
            case "4" -> this.state = State.KELUAR;
            default -> layar.tampilkanPesan("Pilihan tidak valid.");
        }
    }

    private void prosesTarikTunai() throws AtmException {
        layar.bersihkanLayar();
        layar.tampilkanPesan("--- TARIK TUNAI ---");
        layar.tampilkanPesan("Kelipatan: " + FormatUang.toRupiah(KonfigurasiAtm.KELIPATAN_TARIK_TUNAI));
        layar.tampilkanPesanBarisBaru("Masukkan jumlah: ");
        double jumlah = Double.parseDouble(layar.bacaInput());

        layananTarikTunai.eksekusi(akunSaatIni, this, jumlah); 
        
        layar.tampilkanStrukTarikTunai(akunSaatIni.getNomorRekening(), jumlah, akunSaatIni.getSaldo());
        layar.jeda();
        this.state = State.MENU_UTAMA;
    }

    private void prosesTransfer() throws AtmException {
        layar.bersihkanLayar();
        layar.tampilkanPesan("--- TRANSFER ---");
        layar.tampilkanPesanBarisBaru("Masukkan nomor rekening tujuan: ");
        String noRekTujuan = layar.bacaInput();
        layar.tampilkanPesanBarisBaru("Masukkan jumlah transfer: ");
        double jumlah = Double.parseDouble(layar.bacaInput());

        layananTransfer.eksekusi(akunSaatIni, noRekTujuan, jumlah);

        layar.tampilkanStrukTransfer(akunSaatIni.getNomorRekening(), noRekTujuan, jumlah, KonfigurasiAtm.BIAYA_ADMIN_TRANSFER, akunSaatIni.getSaldo());
        layar.jeda();
        this.state = State.MENU_UTAMA;
    }

    private void prosesCekSaldo() {
        layar.bersihkanLayar();
        layar.tampilkanPesan("--- CEK SALDO ---");
        layar.tampilkanPesan("Saldo Anda saat ini adalah: " + FormatUang.toRupiah(layananAkun.cekSaldo(akunSaatIni)));
        layar.jeda();
        this.state = State.MENU_UTAMA;
    }

    private void prosesKeluar() {
        layar.bersihkanLayar();
        layar.tampilkanPesan("Terima kasih telah menggunakan layanan kami.");
        this.akunSaatIni = null;
        this.state = State.MENUNGGU_KARTU; // Kembali ke state awal
    }

    public void validasiKas(double jumlah) throws KasAtmTidakCukupException {
        if (this.kasTersedia < jumlah) {
            throw new KasAtmTidakCukupException("Mohon maaf, dana di mesin ATM tidak mencukupi.");
        }
    }

    public void keluarkanUang(double jumlah) {
        this.kasTersedia -= jumlah;
    }
}