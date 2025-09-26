public class KebunBinatang {
    public static void main(String[] args) {
        // Memanggil method static sebelum ada objek
        // Ini menunjukkan bahwa method static milik kelas, bukan objek
        Hewan.tampilkanJumlahHewan();

        System.out.println("\nMenciptakan objek pertama...");
        // 1. Membuat Objek (instansiasi) dari kelas Hewan
        Hewan kucing = new Hewan("Mochi", "Kucing", 2);

        // Memanggil method dari objek 'kucing'
        kucing.tampilkanInfo();
        kucing.bersuara();

        System.out.println("\nMenciptakan objek kedua...");
        // 2. Membuat Objek kedua
        Hewan anjing = new Hewan("Bruno", "Anjing", 4);

        // Memanggil method dari objek 'anjing'
        anjing.tampilkanInfo();
        anjing.bersuara();

        // Memanggil method static lagi untuk melihat total hewan
        Hewan.tampilkanJumlahHewan();
    }
}
