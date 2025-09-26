public class HewanDetail {
    // Variabel Instance
    String nama;
    String spesies;
    String habitat;
    String caraBerkembangBiak;

    // Constructor untuk inisialisasi objek
    public HewanDetail(String nama, String spesies, String habitat, String caraBerkembangBiak) {
        this.nama = nama;
        this.spesies = spesies;
        this.habitat = habitat;
        this.caraBerkembangBiak = caraBerkembangBiak;
    }

    // Method untuk menampilkan deskripsi lengkap
    public void tampilkanDeskripsi() {
        System.out.println("\n--- Deskripsi Lengkap Hewan ---");
        System.out.println(this.nama + " adalah seekor " + this.spesies + ".");
        System.out.println("Habitat aslinya berada di " + this.habitat + ".");
        System.out.println("Ia berkembang biak dengan cara " + this.caraBerkembangBiak + ".");
        System.out.println("---------------------------------");
    }

    // Method untuk menampilkan info singkat
    public void infoSingkat() {
        System.out.println("\n--- Info Singkat ---");
        System.out.println("Nama    : " + this.nama);
        System.out.println("Spesies : " + this.spesies);
        System.out.println("--------------------\n");
    }
}