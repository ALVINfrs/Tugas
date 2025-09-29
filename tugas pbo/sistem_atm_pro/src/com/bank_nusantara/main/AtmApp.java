package com.bank_nusantara.main;

import com.bank_nusantara.model.bank.MesinAtm;
import com.bank_nusantara.repository.AkunRepository;
import com.bank_nusantara.service.LayananAkun;
import com.bank_nusantara.service.LayananAutentikasi;
import com.bank_nusantara.service.LayananTarikTunai;
import com.bank_nusantara.service.LayananTransfer;
import com.bank_nusantara.ui.Layar;

public class AtmApp {
    public static void main(String[] args) {
        // === COMPOSITION ROOT ===
        // Di sinilah semua objek "dirakit". Pola ini disebut Dependency Injection manual.

        // 1. Buat komponen dasar
        Layar layar = new Layar();
        AkunRepository akunRepository = new AkunRepository();

        // 2. Buat service-service
        LayananAkun layananAkun = new LayananAkun();
        LayananAutentikasi layananAutentikasi = new LayananAutentikasi(akunRepository);
        LayananTarikTunai layananTarikTunai = new LayananTarikTunai(layananAkun);
        LayananTransfer layananTransfer = new LayananTransfer(layananAkun, akunRepository);

        // 3. Buat dan konfigurasikan objek utama (Mesin ATM)
        MesinAtm mesinAtm = new MesinAtm(
            "ATM-BNI-001", 
            20000000, // Kas awal di mesin
            layar, 
            layananAutentikasi, 
            layananAkun, 
            layananTarikTunai, 
            layananTransfer
        );

        // 4. Mulai aplikasi
        mesinAtm.mulai();
    }
}
