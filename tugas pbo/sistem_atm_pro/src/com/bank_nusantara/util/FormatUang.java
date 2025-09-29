package com.bank_nusantara.util;

import java.text.NumberFormat;
import java.util.Locale;

public final class FormatUang {

    private FormatUang() {}

    public static String toRupiah(double value) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        formatRupiah.setMinimumFractionDigits(0); // Tidak menampilkan desimal
        formatRupiah.setMaximumFractionDigits(0);
        return formatRupiah.format(value);
    }
}
