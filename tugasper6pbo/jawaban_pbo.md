
# Jawaban Latihan PBO - Method, Konstruktor, dan Parameter

## 1. Penjelasan Method `void` dan `return`

Dalam Pemrograman Berorientasi Objek (PBO), method adalah blok kode yang berisi serangkaian pernyataan yang melakukan tugas tertentu. Berdasarkan kemampuannya untuk mengembalikan nilai, method dibagi menjadi dua jenis:

### Method `void`
- **Penjelasan**: Method `void` adalah method yang dieksekusi untuk melakukan suatu tindakan atau operasi, tetapi **tidak mengembalikan nilai apa pun** setelah selesai. Kata kunci `void` secara eksplisit menyatakan bahwa tidak ada nilai yang akan dikembalikan.
- **Kegunaan**: Biasanya digunakan untuk tugas-tugas yang tujuannya adalah mengubah keadaan suatu objek (memodifikasi nilai atribut), mencetak sesuatu ke konsol, atau memanggil method lain.
- **Contoh**:
  ```java
  public void cetakInfo(String nama) {
      System.out.println("Nama Karyawan: " + nama);
      // Method ini hanya menampilkan info, tidak mengembalikan data
  }
  ```

### Method dengan `return` (Non-void)
- **Penjelasan**: Method ini adalah method yang **mengembalikan sebuah nilai** setelah dieksekusi. Tipe data dari nilai yang dikembalikan harus dideklarasikan saat pembuatan method (misalnya `int`, `double`, `String`, atau tipe objek lainnya). Kata kunci `return` digunakan untuk mengembalikan nilai tersebut ke pemanggil method.
- **Kegunaan**: Digunakan ketika kita perlu melakukan suatu perhitungan atau proses dan hasilnya akan digunakan di bagian lain dari program.
- **Contoh**:
  ```java
  public double hitungGajiTotal(double gajiPokok, double tunjangan) {
      double total = gajiPokok + tunjangan;
      return total; // Mengembalikan hasil perhitungan
  }
  ```

**Kesimpulan**: Perbedaan utamanya adalah `void` untuk melakukan aksi tanpa hasil kembalian, sedangkan method dengan `return` digunakan untuk melakukan proses yang menghasilkan sebuah nilai untuk digunakan lebih lanjut.

---

## 2. Penjelasan Konstruktor dan Parameter

### Konstruktor (`Constructor`)
- **Penjelasan**: Konstruktor adalah sebuah method khusus yang namanya **sama persis** dengan nama class-nya dan tidak memiliki tipe kembalian (`return type`), bahkan `void`. Konstruktor akan dipanggil secara otomatis ketika sebuah objek baru dibuat (diinstansiasi) menggunakan kata kunci `new`.
- **Kegunaan**: Fungsi utamanya adalah untuk **menginisialisasi** atau memberikan nilai awal kepada atribut-atribut (variabel instance) dari sebuah objek. Ini memastikan bahwa objek berada dalam keadaan yang valid dan siap digunakan segera setelah dibuat.
- **Contoh**:
  ```java
  public class Karyawan {
      String nama;
      // Ini adalah konstruktor
      public Karyawan() {
          nama = "Belum ada nama"; // Memberi nilai awal pada atribut nama
      }
  }
  ```

### Parameter
- **Penjelasan**: Parameter adalah variabel yang dideklarasikan di dalam tanda kurung `()` pada deklarasi method atau konstruktor. Parameter berfungsi sebagai "pintu masuk" untuk memberikan data atau nilai dari luar (saat pemanggilan) ke dalam method atau konstruktor tersebut.
- **Kegunaan**: Parameter membuat method dan konstruktor menjadi lebih fleksibel dan dinamis. Daripada menggunakan nilai yang tetap (hardcoded), kita bisa memberikan nilai yang berbeda-beda setiap kali memanggilnya. Hal ini memungkinkan sebuah method/konstruktor untuk bekerja dengan data yang bervariasi.
- **Contoh dengan Parameter**:
  ```java
  public class Karyawan {
      String nama;
      // Konstruktor dengan parameter 'namaKaryawan'
      public Karyawan(String namaKaryawan) {
          this.nama = namaKaryawan; // Inisialisasi atribut 'nama' dengan nilai dari parameter
      }
  }
  // Pemanggilan: Karyawan karyawanBaru = new Karyawan("Budi");
  ```

**Kesimpulan**: **Konstruktor** adalah "cetak biru" inisialisasi objek saat dibuat, sementara **Parameter** adalah cara untuk "mengirim" data ke dalam konstruktor (atau method lain) agar inisialisasi atau proses di dalamnya bisa lebih dinamis.

---

## 3. Penjelasan Kodingan `Penggajian.java`

Kode di bawah ini merupakan implementasi dari class `Penggajian` sesuai dengan ketentuan soal nomor 3, dengan asumsi NPM Ganjil.

- **Atribut**: Class `Penggajian` memiliki tiga atribut dengan access modifier `private` untuk enkapsulasi:
  - `private String nama`: Menyimpan nama karyawan.
  - `private double gajiPokok`: Menyimpan gaji pokok karyawan.
  - `private double tunjangan`: Menyimpan tunjangan yang diterima.

- **Konstruktor**: Terdapat dua jenis konstruktor (overloading):
  1.  **Tanpa Parameter (`public Penggajian()`):** Menginisialisasi objek dengan nilai default. Berguna jika objek dibuat tanpa informasi awal.
  2.  **Dengan Parameter (`public Penggajian(String nama, ...)`):** Menginisialisasi objek dengan nilai yang diberikan saat instansiasi, menggunakan `this` untuk membedakan antara atribut class dan parameter.

- **Method**: Terdapat tiga method yang diminta:
  1.  **`tampilkanInfo()` (`void`)**: Method ini tidak mengembalikan nilai. Tugasnya hanya untuk menampilkan semua informasi gaji karyawan ke konsol.
  2.  **`hitungGajiTotal()` (non-`void`)**: Method ini mengembalikan nilai bertipe `double`. Tugasnya adalah menghitung total gaji (gaji pokok + tunjangan) dan mengembalikan hasilnya.
  3.  **`hitungPajak()` (non-`void`)**: Method ini juga mengembalikan nilai `double` dan menerima parameter `persenPajak`. Ini menunjukkan method yang bisa melakukan kalkulasi berdasarkan input eksternal.

- **Class `Main`**: Class ini berisi method `main` yang berfungsi sebagai titik awal eksekusi program. Di dalamnya, kita membuat dua objek `Penggajian` menggunakan kedua konstruktor untuk menunjukkan cara kerjanya, lalu memanggil method-method yang ada untuk menampilkan hasilnya.
