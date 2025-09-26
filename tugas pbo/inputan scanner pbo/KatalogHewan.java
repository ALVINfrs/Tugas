import java.util.Scanner; // Mengimpor kelas Scanner

public class KatalogHewan {
    public static void main(String[] args) {
        // Membuat objek Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Program Katalog Hewan =======");
        System.out.println("Masukkan detail hewan yang ingin Anda data:");

        // Meminta input dari pengguna
        System.out.print("Nama Hewan (contoh: Singa): ");
        String nama = scanner.nextLine();

        System.out.print("Spesies (contoh: Mamalia Karnivora): ");
        String spesies = scanner.nextLine();

        System.out.print("Habitat (contoh: Padang Rumput Afrika): ");
        String habitat = scanner.nextLine();

        System.out.print("Cara Berkembang Biak (contoh: Melahirkan): ");
        String caraBerkembangBiak = scanner.nextLine();

        // Membuat objek 'hewan' dari kelas HewanDetail menggunakan data dari input
        HewanDetail hewan = new HewanDetail(nama, spesies, habitat, caraBerkembangBiak);

        // Menutup scanner setelah tidak digunakan
        scanner.close();

        // Memanggil method dari objek 'hewan' untuk menampilkan hasilnya
        hewan.infoSingkat();
        hewan.tampilkanDeskripsi();

        System.out.println("\n======= Program Selesai =======");
    }
}
