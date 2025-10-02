import java.util.Scanner;

/**
 * Kelas utama yang berisi method main untuk menjalankan program inventaris.
 */
public class InventarisDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= PROGRAM PENCATATAN GUDANG BARANG =======");

        System.out.print("Masukkan Kode Barang : ");
        String kode = scanner.nextLine();

        System.out.print("Masukkan Nama Barang : ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Jumlah Stok : ");
        int stok = scanner.nextInt();

        System.out.print("Masukkan Harga Satuan: ");
        double harga = scanner.nextDouble();

        // Membuat objek (instance) dari kelas GudangBarang
        GudangBarang barangBaru = new GudangBarang(kode, nama, stok, harga);

        // Memanggil method dari objek untuk menampilkan informasinya
        barangBaru.tampilkanInfoBarang();

        scanner.close();
    }
}
