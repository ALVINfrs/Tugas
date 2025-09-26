import java.util.Scanner; // Import kelas Scanner

public class InputDataMahasiswa {
    public static void main(String[] args) {
        // 1. Membuat objek Scanner untuk membaca input dari keyboard
        Scanner input = new Scanner(System.in);

        System.out.println("### Program Input Data Mahasiswa ###");

        // 2. Meminta dan membaca input dari pengguna
        System.out.print("Masukkan NPM     : ");
        String npm = input.nextLine();

        System.out.print("Masukkan Nama    : ");
        String nama = input.nextLine();

        System.out.print("Masukkan Jurusan : ");
        String jurusan = input.nextLine();

        System.out.print("Masukkan IPK     : ");
        double ipk = input.nextDouble();

        // 3. Membuat objek 'mahasiswaBaru' dari kelas Mahasiswa dengan data yang sudah diinput
        Mahasiswa mahasiswaBaru = new Mahasiswa(npm, nama, jurusan, ipk);

        // 4. Menutup objek scanner untuk melepaskan sumber daya
        input.close();

        // 5. Memanggil method untuk menampilkan data dari objek yang telah dibuat
        mahasiswaBaru.tampilkanData();
    }
}
