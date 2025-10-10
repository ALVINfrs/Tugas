import java.util.ArrayList;

/**
 * Class Pesanan (Versi Kompleks)
 * Mengelola data pesanan, termasuk pelanggan, item, dan diskon.
 */
public class Pesanan {
    private String namaPelanggan;
    private ArrayList<Produk> daftarProduk;
    private ArrayList<Integer> jumlahPesanan;
    private double persentaseDiskon;
    private String namaVoucher;

    public Pesanan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
        this.daftarProduk = new ArrayList<>();
        this.jumlahPesanan = new ArrayList<>();
        this.persentaseDiskon = 0.0; // Awalnya tidak ada diskon
        this.namaVoucher = "";
    }

    public void tambahProduk(Produk produk, int jumlah) {
        if (produk.getStok() >= jumlah) {
            daftarProduk.add(produk);
            jumlahPesanan.add(jumlah);
            produk.kurangiStok(jumlah);
            System.out.println("✔️  " + produk.getNamaProduk() + " (x" + jumlah + ") berhasil ditambahkan.");
        } else {
            System.out.println("❌  Maaf, stok " + produk.getNamaProduk() + " tidak mencukupi (sisa: " + produk.getStok() + ").");
        }
    }

    /**
     * Method void untuk mengaplikasikan voucher.
     * Menggunakan logika switch case (syarat terpenuhi).
     */
    public void applyVoucher(String kode) {
        switch (kode.toUpperCase()) {
            case "HEMAT10":
                this.persentaseDiskon = 0.10; // Diskon 10%
                this.namaVoucher = "HEMAT10 (10%)";
                System.out.println("✔️  Voucher 'HEMAT10' berhasil digunakan!");
                break;
            case "KOPIHEMAT":
                this.persentaseDiskon = 0.20; // Diskon 20%
                this.namaVoucher = "KOPIHEMAT (20%)";
                System.out.println("✔️  Voucher 'KOPIHEMAT' berhasil digunakan!");
                break;
            default:
                System.out.println("❌  Kode voucher tidak valid.");
                break;
        }
    }

    public double hitungSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < daftarProduk.size(); i++) {
            subtotal += daftarProduk.get(i).getHarga() * jumlahPesanan.get(i);
        }
        return subtotal;
    }

    public void tampilkanStruk() {
        double subtotal = hitungSubtotal();
        double jumlahDiskon = subtotal * this.persentaseDiskon;
        double totalAkhir = subtotal - jumlahDiskon;

        System.out.println("\n========================================");
        System.out.println("          STRUK PEMBAYARAN          ");
        System.out.println("========================================");
        System.out.println("Pelanggan: " + this.namaPelanggan);
        System.out.println("----------------------------------------");

        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk p = daftarProduk.get(i);
            int jumlah = jumlahPesanan.get(i);
            String hargaFormatted = String.format("Rp%,.0f", (p.getHarga() * jumlah));
            System.out.println(p.getNamaProduk() + " x" + jumlah);
            System.out.println("  " + hargaFormatted);
        }

        System.out.println("----------------------------------------");
        String subtotalFormatted = String.format("Rp%,.0f", subtotal);
        System.out.println("Subtotal: " + subtotalFormatted);

        if (jumlahDiskon > 0) {
            String diskonFormatted = String.format("-Rp%,.0f", jumlahDiskon);
            System.out.println("Diskon (" + this.namaVoucher + "):");
            System.out.println("  " + diskonFormatted);
        }

        System.out.println("----------------------------------------");
        String totalFormatted = String.format("Rp%,.0f", totalAkhir);
        System.out.println("Total Bayar: " + totalFormatted);
        System.out.println("========================================");
        System.out.println("           Terima Kasih!          ");
        System.out.println("========================================\n");
    }
}