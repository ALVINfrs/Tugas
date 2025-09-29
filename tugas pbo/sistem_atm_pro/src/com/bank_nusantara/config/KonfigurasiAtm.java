package com.bank_nusantara.config;

public final class KonfigurasiAtm {
    // Mencegah instansiasi kelas utilitas
    private KonfigurasiAtm() {}

    // Konfigurasi Keamanan
    public static final int MAKS_PERCOBAAN_PIN = 3;

    // Konfigurasi Transaksi
    public static final double BIAYA_ADMIN_TRANSFER = 6500.0;
    public static final double MINIMAL_TARIK_TUNAI = 50000.0;
    public static final double KELIPATAN_TARIK_TUNAI = 50000.0;

}
