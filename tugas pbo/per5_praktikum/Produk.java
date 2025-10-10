/**
 * Class Produk
 * Merepresentasikan satu jenis produk yang dijual di kafe.
 * Menggunakan konsep Encapsulation dengan atribut private dan method public (getter).
 */
public class Produk {
    // Atribut (State) dengan access specifier private
    private String namaProduk;
    private double harga;
    private int stok;

    /**
     * Konstruktor untuk menciptakan objek Produk.
     * Ini adalah contoh method khusus dari Pertemuan 2.
     */
    public Produk(String namaProduk, double harga, int stok) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }

    // --- Public Methods (Getters) untuk mengakses atribut private ---
    public String getNamaProduk() {
        return this.namaProduk;
    }

    public double getHarga() {
        return this.harga;
    }

    public int getStok() {
        return this.stok;
    }

    /**
     * Method void untuk mengurangi stok.
     * Ini adalah salah satu contoh method void yang diminta.
     */
    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        }
    }
}
