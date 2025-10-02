import java.util.Scanner;

/**
 * Kelas utama yang berisi method main untuk menjalankan program.
 * Kelas ini bertugas untuk membuat objek dari kelas TempatMakan dan berinteraksi dengan pengguna.
 */
public class RestoranDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("========= PROGRAM KASIR TEMPAT MAKAN =========");
        
        System.out.print("Masukkan Nama Pelanggan : ");
        String nama = input.nextLine();
        
        System.out.print("Masukkan Nama Makanan   : ");
        String makanan = input.nextLine();
        
        System.out.print("Masukkan Jumlah Pesanan : ");
        int jumlah = input.nextInt();
        
        System.out.print("Masukkan Harga Satuan   : ");
        double harga = input.nextDouble();

        // Membuat objek baru dari kelas TempatMakan menggunakan konstruktor
        TempatMakan pesananSatu = new TempatMakan(nama, makanan, jumlah, harga);

        // Memanggil method untuk menampilkan struk dari objek yang sudah dibuat
        pesananSatu.tampilkanStruk();
        
        input.close();
    }
}