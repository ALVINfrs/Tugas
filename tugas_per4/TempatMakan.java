/**
 * Kelas ini adalah blueprint (cetak biru) untuk merepresentasikan
 * sebuah pesanan di tempat makan.
 * Menggunakan access modifier private pada atributnya untuk enkapsulasi.
 */
public class TempatMakan {
    // 1. Atribut dengan access specifier/modifier "private"
    // Atribut hanya bisa diakses dari dalam kelas ini sendiri.
    private String namaPelanggan;
    private String pesanan;
    private int jumlah;
    private double hargaSatuan;

    // 2. Method - Konstruktor
    // Method khusus yang dipanggil saat objek pertama kali dibuat.
    // Digunakan untuk menginisialisasi nilai atribut.
    public TempatMakan(String namaPelanggan, String pesanan, int jumlah, double hargaSatuan) {
        this.namaPelanggan = namaPelanggan;
        this.pesanan = pesanan;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
    }

    // 3. Method non-void (return value)
    // Method ini melakukan perhitungan dan mengembalikan hasil total harga.
    public double hitungTotalBayar() {
        return hargaSatuan * jumlah;
    }

    // 4. Method void (tidak ada return value)
    // Method ini hanya menjalankan perintah untuk menampilkan informasi pesanan.
    public void tampilkanStruk() {
        System.out.println("\n================ STRUK PEMBAYARAN ================");
        System.out.println("Nama Pelanggan : " + this.namaPelanggan);
        System.out.println("Pesanan        : " + this.pesanan);
        System.out.println("Jumlah         : " + this.jumlah);
        System.out.println("Harga Satuan   : Rp " + this.hargaSatuan);
        System.out.println("--------------------------------------------------");
        System.out.println("Total Bayar    : Rp " + hitungTotalBayar());
        System.out.println("==================================================");
    }
}
