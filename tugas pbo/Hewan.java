public class Hewan {
    // 1. Variabel Instance (Instance Variable)
    // Dimiliki oleh setiap objek yang dibuat dari kelas ini.
    String nama;
    String jenis;
    int umur;

    // 2. Variabel Kelas (Class Variable / Static)
    // Dimiliki oleh kelas itu sendiri, nilainya sama untuk semua objek.
    static int jumlahHewan = 0;

    // Constructor: Method khusus yang dipanggil saat objek dibuat (instansiasi)
    // Parameter `namaHewan`, `jenisHewan`, `umurHewan` adalah Variabel Lokal.
    public Hewan(String namaHewan, String jenisHewan, int umurHewan) {
        this.nama = namaHewan;
        this.jenis = jenisHewan;
        this.umur = umurHewan;
        
        // Menambah jumlah total hewan setiap kali objek baru dibuat
        jumlahHewan++;
    }

    // Method (Behavior) untuk menampilkan informasi
    public void tampilkanInfo() {
        System.out.println("--- Informasi Hewan ---");
        System.out.println("Nama  : " + this.nama);
        System.out.println("Jenis : " + this.jenis);
        System.out.println("Umur  : " + this.umur + " tahun");
    }

    // Method (Behavior) lain
    public void bersuara() {
        // `suara` adalah Variabel Lokal untuk method ini.
        String suara;
        if (this.jenis.equalsIgnoreCase("Kucing")) {
            suara = "Meow!";
        } else if (this.jenis.equalsIgnoreCase("Anjing")) {
            suara = "Guk Guk!";
        } else {
            suara = "(Suara tidak dikenal)";
        }
        System.out.println(this.nama + " bersuara: " + suara);
    }

    // Method Static: Milik kelas, bukan objek.
    public static void tampilkanJumlahHewan() {
        System.out.println("=====================================");
        System.out.println("Total jumlah hewan yang dibuat: " + jumlahHewan);
        System.out.println("=====================================");
    }
}
