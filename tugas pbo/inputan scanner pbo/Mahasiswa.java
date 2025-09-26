public class Mahasiswa {
    // Variabel Instance
    String npm;
    String nama;
    String jurusan;
    double ipk;

    // Constructor untuk membuat objek Mahasiswa
    public Mahasiswa(String npm, String nama, String jurusan, double ipk) {
        this.npm = npm;
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Method untuk menampilkan data mahasiswa
    public void tampilkanData() {
        System.out.println("\n--- Data Mahasiswa yang Telah Diinput ---");
        System.out.println("NPM     : " + this.npm);
        System.out.println("Nama    : " + this.nama);
        System.out.println("Jurusan : " + this.jurusan);
        System.out.println("IPK     : " + this.ipk);
        System.out.println("-----------------------------------------");
    }
}
