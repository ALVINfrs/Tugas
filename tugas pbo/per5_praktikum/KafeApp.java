import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class KafeApp (Versi Kompleks)
 * Simulasi mesin kasir kafe yang interaktif dengan fitur lengkap.
 */
public class KafeApp {

    public static void main(String[] args) {
        // 1. Setup Aplikasi
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produk> menu = new ArrayList<>();
        setupMenu(menu);

        System.out.println("==================================================");
        System.out.println("    SELAMAT DATANG DI APLIKASI KASIR KAFE     ");
        System.out.println("==================================================");

        // 2. Input Nama Pelanggan
        System.out.print("\n> Masukkan Nama Pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        Pesanan pesanan = new Pesanan(namaPelanggan);

        // 3. Proses Pemesanan (Looping)
        boolean selesaiPesan = false;
        while (!selesaiPesan) {
            tampilkanMenu(menu);
            System.out.print("\n> Pilih menu (nomor): ");
            int pilihan = scanner.nextInt();

            if (pilihan == 0) {
                selesaiPesan = true;
            } else if (pilihan > 0 && pilihan <= menu.size()) {
                System.out.print("> Masukkan jumlah: ");
                int jumlah = scanner.nextInt();
                pesanan.tambahProduk(menu.get(pilihan - 1), jumlah);
            } else {
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }

        // 4. Proses Voucher
        System.out.print("\n> Apakah pelanggan memiliki kode voucher? (y/n): ");
        String adaVoucher = scanner.next();
        if (adaVoucher.equalsIgnoreCase("y")) {
            System.out.print("> Masukkan kode voucher: ");
            String kode = scanner.next();
            pesanan.applyVoucher(kode);
        }

        // 5. Tampilkan Struk Final
        pesanan.tampilkanStruk();

        System.out.println("Aplikasi ditutup.");
        scanner.close();
    }

    /**
     * Method static untuk mempersiapkan daftar menu.
     */
    public static void setupMenu(ArrayList<Produk> menu) {
        // Kategori Kopi
        menu.add(new Produk("Espresso", 15000, 100));
        menu.add(new Produk("Americano", 18000, 100));
        menu.add(new Produk("Caffe Latte", 22000, 80));
        menu.add(new Produk("Kopi Gula Aren", 20000, 80));
        // Kategori Non-Kopi
        menu.add(new Produk("Matcha Latte", 24000, 50));
        menu.add(new Produk("Chocolate", 22000, 60));
        menu.add(new Produk("Lemon Tea", 16000, 70));
        // Kategori Makanan
        menu.add(new Produk("Croissant", 18000, 40));
        menu.add(new Produk("Red Velvet Cake", 25000, 30));
        menu.add(new Produk("Spaghetti Carbonara", 45000, 25));
    }

    /**
     * Method static untuk menampilkan menu kepada pengguna.
     */
    public static void tampilkanMenu(ArrayList<Produk> menu) {
        System.out.println("\n-------------------- MENU --------------------");
        for (int i = 0; i < menu.size(); i++) {
            Produk p = menu.get(i);
            System.out.printf("%d. %-22s (Rp%,.0f) | Stok: %d\n", (i + 1), p.getNamaProduk(), p.getHarga(), p.getStok());
        }
        System.out.println("----------------------------------------------");
        System.out.println("0. Selesai dan Lanjut ke Pembayaran");
    }
}
