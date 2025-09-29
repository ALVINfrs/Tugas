package com.tokoku.service;

/**
 * Implementasi konkret dari DiskonStrategy.
 * Memberikan diskon 10% jika total belanja melebihi Rp 100.000.
 */
public class DiskonMember implements DiskonStrategy {
    private static final double AMBANG_BATAS_DISKON = 100000.00;
    private static final double PERSENTASE_DISKON = 0.10; // 10%

    @Override
    public double hitungDiskon(double totalBelanja) {
        if (totalBelanja >= AMBANG_BATAS_DISKON) {
            return totalBelanja * PERSENTASE_DISKON;
        }
        return 0;
    }

    @Override
    public String getNamaDiskon() {
        return "Diskon Member (10%)";
    }
}
