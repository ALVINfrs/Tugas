
public class TempatMakan {
   
    private String namaPelanggan;
    private String pesanan;
    private int jumlah;
    private double hargaSatuan;

   
    public TempatMakan(String namaPelanggan, String pesanan, int jumlah, double hargaSatuan) {
        this.namaPelanggan = namaPelanggan;
        this.pesanan = pesanan;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
    }

  
    public double hitungTotalBayar() {
        return hargaSatuan * jumlah;
    }

   
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
