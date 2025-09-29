package com.bank_nusantara.service;

import com.bank_nusantara.config.KonfigurasiAtm;
import com.bank_nusantara.exception.KartuBlokirException;
import com.bank_nusantara.exception.PinSalahException;
import com.bank_nusantara.model.akun.Akun;
import com.bank_nusantara.repository.AkunRepository;

public class LayananAutentikasi {
    private final AkunRepository akunRepository;

    public LayananAutentikasi(AkunRepository akunRepository) {
        this.akunRepository = akunRepository;
    }

    public Akun getAkunDariKartu(String nomorKartu) {
        return akunRepository.findByNomorKartu(nomorKartu);
    }

    public void autentikasiPin(Akun akun, String pin) throws PinSalahException, KartuBlokirException {
        if (!akun.getKartu().isAktif()) {
            throw new KartuBlokirException("Kartu Anda telah terblokir. Harap hubungi bank.");
        }

        if (akun.isPinValid(pin)) {
            akun.resetPercobaanPin();
        } else {
            akun.tambahPercobaanPinGagal();
            if (akun.getPercobaanPinGagal() >= KonfigurasiAtm.MAKS_PERCOBAAN_PIN) {
                akun.blokirKartu();
                throw new KartuBlokirException("PIN salah 3 kali. Kartu Anda telah diblokir.");
            }
            int sisaPercobaan = KonfigurasiAtm.MAKS_PERCOBAAN_PIN - akun.getPercobaanPinGagal();
            throw new PinSalahException("PIN salah. Sisa percobaan: " + sisaPercobaan);
        }
    }
}
