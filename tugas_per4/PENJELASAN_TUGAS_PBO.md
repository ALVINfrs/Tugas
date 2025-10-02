# Latihan Access Control dan Method

**Nama: (Isi Nama Anda)**
**NPM: (Isi NPM Anda)**

---

## 1. Simpulan Mengenai Access Specifier dan Access Modifier

*Access Specifier* atau *Access Modifier* adalah kata kunci (keyword) dalam pemrograman berorientasi objek yang digunakan untuk menentukan tingkat aksesibilitas (siapa saja yang boleh mengakses) dari sebuah atribut, method, atau kelas. Tujuannya adalah untuk menerapkan konsep **enkapsulasi**, yaitu menyembunyikan detail internal dari sebuah objek dan hanya memperlihatkan fungsionalitas yang diperlukan.

Di Java, terdapat 4 jenis access modifier:
1.  **`public`**: Dapat diakses dari kelas mana pun, baik dari dalam package yang sama maupun dari luar package.
2.  **`protected`**: Dapat diakses oleh kelas itu sendiri, kelas lain dalam package yang sama, dan kelas turunannya (subclass) meskipun berada di package yang berbeda.
3.  **`private`**: Paling restriktif. Hanya dapat diakses dari dalam kelas itu sendiri. Tidak bisa diakses sama sekali dari luar kelas, bahkan oleh kelas dalam package yang sama.
4.  **`default` (tanpa keyword)**: Jika tidak ada modifier yang dituliskan, maka aksesnya adalah default. Artinya, hanya dapat diakses oleh kelas lain yang berada dalam package yang sama.

---

## 2. Simpulan Mengenai Kegunaan Method dalam Pemrograman Berorientasi Objek (PBO)

Berdasarkan materi pada PDF, **Method** adalah sebuah blok kode atau fungsi yang didefinisikan di dalam sebuah kelas dan dapat dijalankan oleh objek dari kelas tersebut. Method merepresentasikan perilaku atau operasi yang bisa dilakukan oleh sebuah objek.

Kegunaan utama Method dalam PBO adalah:
1.  **Reusability (Penggunaan Ulang Kode)**: Method memungkinkan kita untuk menulis kode sekali dan memanggilnya berkali-kali dari berbagai bagian program tanpa harus menulis ulang kode yang sama.
2.  **Enkapsulasi (Pembungkusan)**: Method menjadi perantara untuk mengakses atau memanipulasi data (atribut) yang bersifat `private`. Ini memungkinkan kita menyembunyikan detail implementasi dan melindungi data dari perubahan yang tidak sah.
3.  **Modularitas**: Dengan memecah program menjadi method-method yang lebih kecil, kode menjadi lebih terstruktur, lebih mudah dibaca, lebih mudah dipahami, dan lebih mudah untuk diperbaiki jika terjadi kesalahan (debug).
4.  **Menjalankan Fungsi Spesifik**: Setiap method dirancang untuk melakukan satu tugas spesifik, misalnya method `hitungTotal()` untuk menghitung total, atau `tampilkanStruk()` untuk menampilkan data ke layar.

---

## 3. Penjelasan Lengkap Kode Program (NPM Ganjil - Tempat Makan)

Program ini adalah simulasi sederhana dari sistem kasir di sebuah tempat makan. Program akan meminta input dari pengguna mengenai detail pesanan, kemudian menghitung total bayar dan menampilkannya dalam bentuk struk. Kode programnya dipecah menjadi dua file: `TempatMakan.java` (blueprint) dan `RestoranDemo.java` (program utama).

### A. File `TempatMakan.java` (Blueprint Class)

Kelas ini berfungsi sebagai *blueprint* atau cetak biru untuk membuat objek "Pesanan".

#### Atribut:
- `private String namaPelanggan;`
- `private String pesanan;`
- `private int jumlah;`
- `private double hargaSatuan;`

Keempat atribut ini menggunakan access modifier `private`. Artinya, data ini sangat penting dan tidak boleh diubah secara sembarangan dari luar kelas `TempatMakan`. Akses ke atribut ini hanya dimungkinkan melalui method yang ada di dalam kelas itu sendiri.

#### Method:
1.  **`public TempatMakan(String nama, ...)` (Konstruktor)**
    -   Ini adalah method khusus yang namanya sama dengan nama kelasnya. Method ini otomatis dipanggil saat sebuah objek baru dibuat (misalnya: `new TempatMakan(...)`).
    -   Tugasnya adalah untuk menerima data awal (nama, pesanan, dll.) dan mengisikannya ke dalam atribut-atribut yang sudah disiapkan. Kata kunci `this` digunakan untuk membedakan antara parameter method dan atribut kelas.

2.  **`public double hitungTotalBayar()`**
    -   Ini adalah *method non-void* yang mengembalikan nilai (`return value`) bertipe `double`.
    -   Tugasnya adalah melakukan perhitungan total bayar dengan mengalikan `hargaSatuan` dengan `jumlah`. Hasil perhitungannya dikembalikan sebagai output dari method ini.

3.  **`public void tampilkanStruk()`**
    -   Ini adalah *method void*, artinya method ini tidak mengembalikan nilai apa pun.
    -   Tugasnya hanya satu: menjalankan serangkaian perintah `System.out.println()` untuk menampilkan seluruh informasi pesanan, termasuk total bayar yang didapat dari memanggil method `hitungTotalBayar()`, ke layar dalam format struk.

### B. File `RestoranDemo.java` (Main Class)

Kelas ini berfungsi sebagai "pintu masuk" atau titik awal eksekusi program.

#### Method `public static void main(String[] args)`:
-   Ini adalah method utama yang akan dijalankan pertama kali oleh Java.
-   **Langkah 1: Membuat `Scanner`**: `Scanner input = new Scanner(System.in);` digunakan untuk membaca input dari keyboard pengguna.
-   **Langkah 2: Menerima Input**: Program meminta pengguna memasukkan nama, pesanan, jumlah, dan harga, lalu menyimpannya ke dalam variabel sementara.
-   **Langkah 3: Membuat Objek**: Baris `TempatMakan pesananSatu = new TempatMakan(...)` adalah inti dari program ini. Di sini, kita membuat sebuah objek nyata bernama `pesananSatu` dari blueprint `TempatMakan`. Data yang diinput oleh pengguna langsung dimasukkan ke dalam objek ini melalui konstruktor.
-   **Langkah 4: Memanggil Method**: `pesananSatu.tampilkanStruk();` adalah perintah untuk menyuruh objek `pesananSatu` menjalankan method `tampilkanStruk()` miliknya, yang kemudian akan menampilkan semua detail pesanan ke layar.

---

## 4. Penjelasan Lengkap Kode Program (NPM Genap - Gudang Barang)

Program ini adalah simulasi sederhana untuk pencatatan data barang di gudang. Pengguna akan memasukkan detail barang, lalu program akan menampilkan informasi lengkap beserta total nilai dari stok barang tersebut.

### A. File `GudangBarang.java` (Blueprint Class)

Kelas ini adalah blueprint untuk objek "Barang".

#### Atribut:
- `private String kodeBarang;`
- `private String namaBarang;`
- `private int stok;`
- `private double hargaSatuan;`

Sama seperti contoh sebelumnya, semua atribut bersifat `private` untuk menjaga integritas data (enkapsulasi).

#### Method:
1.  **`public GudangBarang(String kode, ...)` (Konstruktor)**
    -   Method ini dipanggil saat objek `GudangBarang` dibuat.
    -   Tugasnya adalah menerima detail barang (kode, nama, stok, harga) dan menyimpannya ke dalam atribut internal objek.

2.  **`public double hitungTotalNilai()`**
    -   Sebuah *method non-void* yang bertugas menghitung total nilai inventaris dari satu jenis barang.
    -   Perhitungannya adalah `stok` dikalikan `hargaSatuan`.
    -   Method ini mengembalikan (`return`) hasil perhitungan yang bertipe `double`.

3.  **`public void tampilkanInfoBarang()`**
    -   Sebuah *method void* yang tidak mengembalikan nilai.
    -   Tugasnya adalah menampilkan semua informasi barang, termasuk memanggil method `hitungTotalNilai()` untuk mendapatkan total nilai stok, lalu menampilkannya ke layar.

### B. File `InventarisDemo.java` (Main Class)

Kelas ini adalah kelas utama untuk menjalankan program pencatatan barang.

#### Method `public static void main(String[] args)`:
-   **Langkah 1: Membuat `Scanner`**: Untuk membaca input dari pengguna.
-   **Langkah 2: Menerima Input**: Meminta pengguna memasukkan data untuk kode barang, nama, stok, dan harga.
-   **Langkah 3: Membuat Objek**: `GudangBarang barangBaru = new GudangBarang(...)` menciptakan objek baru dari kelas `GudangBarang` dengan data yang sudah diinputkan.
-   **Langkah 4: Memanggil Method**: `barangBaru.tampilkanInfoBarang();` memerintahkan objek `barangBaru` untuk menjalankan method `tampilkanInfoBarang()` dan menampilkan detailnya ke konsol.