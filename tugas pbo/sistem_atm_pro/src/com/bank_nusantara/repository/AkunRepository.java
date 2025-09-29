package com.bank_nusantara.repository;

import com.bank_nusantara.model.akun.Akun;
import com.bank_nusantara.model.nasabah.Kartu;
import com.bank_nusantara.model.nasabah.Nasabah;

import java.util.HashMap;
import java.util.Map;

public class AkunRepository {
    // Key: Nomor Kartu, Value: Akun
    private final Map<String, Akun> dbAkun = new HashMap<>();

    public AkunRepository() {
        // Inisialisasi data dummy
        Nasabah nasabah1 = new Nasabah("3301101234560001", "Budi Santoso");
        Kartu kartu1 = new Kartu("1111222233334444");
        Akun akun1 = new Akun("1234567890", "123456", 5000000, nasabah1, kartu1);

        Nasabah nasabah2 = new Nasabah("3301106543210002", "Siti Aminah");
        Kartu kartu2 = new Kartu("5555666677778888");
        Akun akun2 = new Akun("0987654321", "654321", 1500000, nasabah2, kartu2);

        dbAkun.put(kartu1.getNomorKartu(), akun1);
        dbAkun.put(kartu2.getNomorKartu(), akun2);
    }

    public Akun findByNomorKartu(String nomorKartu) {
        return dbAkun.get(nomorKartu);
    }

    public Akun findByNomorRekening(String nomorRekening) {
        return dbAkun.values().stream()
                .filter(akun -> akun.getNomorRekening().equals(nomorRekening))
                .findFirst()
                .orElse(null);
    }
}
