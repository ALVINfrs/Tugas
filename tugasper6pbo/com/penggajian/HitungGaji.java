package com.penggajian;

/**
 * Class HitungGaji untuk melakukan kalkulasi gaji berdasarkan data karyawan.
 * Class ini memenuhi ketentuan:
 * - Memiliki 3+ method (void dan non-void).
 * - Menggunakan atribut private.
 */
public class HitungGaji {
    private Karyawan karyawan;
    private double gajiPokok;
    private double tunjanganJabatan;
    private double tunjanganGolongan;

    /**
     * Konstruktor untuk inisialisasi perhitungan gaji.
     * @param karyawan Objek Karyawan yang akan dihitung gajinya.
     */
    public HitungGaji(Karyawan karyawan) {
        this.karyawan = karyawan;
        // Gaji dan tunjangan dihitung saat objek dibuat
        this.gajiPokok = hitungGajiPokokBerdasarkanJabatan();
        this.tunjanganJabatan = hitungTunjanganJabatan();
        this.tunjanganGolongan = hitungTunjanganGolongan();
    }

    /**
     * Method non-void (private) untuk menentukan gaji pokok berdasarkan jabatan.
     * @return Gaji pokok karyawan.
     */
    private double hitungGajiPokokBerdasarkanJabatan() {
        switch (karyawan.getJabatan().toLowerCase()) {
            case "manager":
                return 7000000;
            case "supervisor":
                return 5000000;
            case "staff":
                return 3000000;
            default:
                return 2500000; // Gaji default jika jabatan tidak dikenal
        }
    }

    /**
     * Method non-void (private) untuk menghitung tunjangan jabatan (15% dari Gaji Pokok).
     * @return Tunjangan jabatan.
     */
    private double hitungTunjanganJabatan() {
        return this.gajiPokok * 0.15;
    }

    /**
     * Method non-void (private) untuk menghitung tunjangan berdasarkan golongan.
     * @return Tunjangan golongan.
     */
    private double hitungTunjanganGolongan() {
        switch (karyawan.getGolongan()) {
            case 1:
                return 500000;
            case 2:
                return 1000000;
            case 3:
                return 1500000;
            default:
                return 0; // Tidak ada tunjangan jika golongan tidak valid
        }
    }

    /**
     * Method non-void untuk menghitung total gaji kotor (sebelum pajak).
     * @return Total gaji kotor.
     */
    public double getGajiKotor() {
        return this.gajiPokok + this.tunjanganJabatan + this.tunjanganGolongan;
    }

    /**
     * Method non-void untuk menghitung potongan pajak (5% dari gaji kotor).
     * @return Jumlah potongan pajak.
     */
    public double hitungPotonganPajak() {
        return getGajiKotor() * 0.05;
    }

    /**
     * Method non-void untuk menghitung gaji bersih yang diterima karyawan.
     * @return Gaji bersih setelah dipotong pajak.
     */
    public double getGajiBersih() {
        return getGajiKotor() - hitungPotonganPajak();
    }

    /**
     * Method void untuk menampilkan slip gaji lengkap.
     */
    public void tampilkanSlipGaji() {
        System.out.println("\n=================================");
        System.out.println("      SLIP GAJI KARYAWAN");
        System.out.println("=================================");
        karyawan.tampilkanInfoDasar();
        System.out.println("---------------------------------");
        System.out.printf("Gaji Pokok         : Rp %,.2f\n", this.gajiPokok);
        System.out.printf("Tunjangan Jabatan  : Rp %,.2f\n", this.tunjanganJabatan);
        System.out.printf("Tunjangan Golongan : Rp %,.2f\n", this.tunjanganGolongan);
        System.out.println("---------------------------------");
        System.out.printf("Gaji Kotor         : Rp %,.2f\n", getGajiKotor());
        System.out.printf("Potongan Pajak (5%%): Rp %,.2f\n", hitungPotonganPajak());
        System.out.println("=================================");
        System.out.printf("Gaji Bersih        : Rp %,.2f\n", getGajiBersih());
        System.out.println("=================================");
    }
}
