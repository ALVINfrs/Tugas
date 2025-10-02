/**
 * Kelas ini adalah blueprint untuk merepresentasikan sebuah barang
 * di dalam gudang atau inventaris.
 */
public class GudangBarang {
    // Atribut dengan access modifier private
    private String kodeBarang;
    private String namaBarang;
    private int stok;
    private double hargaSatuan;

    /**
     * Konstruktor untuk kelas GudangBarang.
     * Dipanggil saat objek baru dibuat untuk menginisialisasi data barang.
     */
    public GudangBarang(String kodeBarang, String namaBarang, int stok, double hargaSatuan) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.hargaSatuan = hargaSatuan;
    }

    /**
     * Method non-void untuk menghitung total nilai (value) dari stok barang.
     * @return double Total nilai (harga * stok).
     */
    public double hitungTotalNilai() {
        return this.stok * this.hargaSatuan;
    }

    /**
     * Method void untuk menampilkan semua informasi detail dari barang.
     */
    public void tampilkanInfoBarang() {
        System.out.println("\n========== DETAIL INFORMASI BARANG ==========");
        System.out.println("Kode Barang    : " + this.kodeBarang);
        System.out.println("Nama Barang    : " + this.namaBarang);
        System.out.println("Stok Tersedia  : " + this.stok + " unit");
        System.out.println("Harga Satuan   : Rp " + this.hargaSatuan);
        System.out.println("-------------------------------------------");
        System.out.println("Total Nilai Stok: Rp " + hitungTotalNilai());
        System.out.println("===========================================");
    }
}
