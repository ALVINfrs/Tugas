# Sistem Informasi Rawat Inap dan Apotek Rumah Sakit

## Deskripsi Program

Program ini merupakan implementasi sistem informasi untuk mengelola rawat inap dan apotek rumah sakit. Sistem ini mendukung pengelolaan pasien, dokter, apoteker, obat-obatan, tindakan medis, dan ruangan rawat inap.

## Fitur Utama

1. Registrasi dan manajemen data pasien
2. Pengelolaan dokter dan apoteker
3. Inventori obat-obatan
4. Manajemen ruang rawat inap
5. Penanganan kasus emergency
6. Pembuatan resep dan dispensing obat
7. Perhitungan biaya dan asuransi
8. Program loyalitas pasien
9. Sistem rating dokter
10. Pembuatan surat kontrol

## Struktur Class dan Method

### 1. RumahSakitApp (Main Class)

- Main entry point program
- Inisialisasi data dummy (dokter, obat, apoteker, ruangan)
- Flow utama program

### 2. Patient

#### Properties:

- name, address, patientId, medicalHistory, hasInsurance, loyaltyPoints

#### Methods:

- Constructor
- Getters
- addLoyaltyPoints()
- display()

### 3. Doctor

#### Properties:

- name, specialization, rating, numberOfRatings, schedule

#### Methods:

- Constructor
- Getters
- addRating()
- addToSchedule()
- display()

### 4. Apoteker

#### Properties:

- name, licenseId, position

#### Methods:

- Constructor
- Getters
- display()

### 5. Apotek

#### Properties:

- inventory (Obat[])
- apoteker

#### Methods:

- Constructor
- displayInventory()
- getObat()
- dispense()
- createResep()

### 6. Obat

#### Properties:

- code, name, description, price, stock

#### Methods:

- Constructor
- Getters
- reduceStock()
- display()

### 7. Ruangan

#### Properties:

- roomNumber, type, pricePerDay, facilities

#### Methods:

- Constructor
- Getters
- display()

### 8. RawatInap

#### Properties:

- patient, doctor, obatList, obatQty, totalBiaya
- isEmergency, diagnosis, tindakan
- ruangan, roomDays, tindakanList

#### Methods:

- Constructor
- setDiagnosis()
- tambahObat()
- tambahTindakan()
- assignRoom()
- hitungTotalBiaya()
- addEmergencySurcharge()
- applyVoucher()
- applyInsurance()
- displayStruk()
- generateSuratKontrol()

### 9. Tindakan

#### Properties:

- name, description, cost

#### Methods:

- Constructor
- Getters
- display()

### 10. Resep

#### Properties:

- patientName, doctorName, date, items, qtys

#### Methods:

- Constructor
- display()

## Alur Program

1. Input data pasien
2. Cek status emergency
3. Pilih dokter yang menangani
4. Pilih apoteker bertugas
5. Input diagnosis dan tindakan
6. Pilih obat-obatan
7. Pilih tindakan medis
8. Atur rujukan (opsional)
9. Pilih jenis perawatan (rawat inap/jalan)
10. Jika rawat inap, pilih ruangan dan lama inap
11. Hitung total biaya
12. Terapkan asuransi dan voucher
13. Cetak struk dan surat kontrol
14. Rating dokter

## Contoh Input/Output

### Input:

```
Nama Pasien: John Doe
Alamat: Jl. Contoh No. 123
Riwayat Medis: Hipertensi
Asuransi: true
Emergency: false
Pilih Dokter: 1
Pilih Apoteker: 2
Diagnosis: Demam tinggi
Tindakan: Observasi
Pilih Obat: 1,5 (Paracetamol, Vitamin C)
Pilih Tindakan: 1 (EKG)
Rujukan: false
Jenis Perawatan: 1 (Rawat Inap)
Pilih Ruangan: 2 (VIP)
Lama Inap: 3
Rating Dokter: 4.5
```

### Output:

```
=== STRUK PEMBAYARAN ===
[Informasi lengkap pasien]
[Rincian tindakan]
[Rincian obat]
[Rincian ruangan]
[Total biaya]

=== SURAT KONTROL ===
[Informasi kontrol berikutnya]
[Resep obat]
```

## Fitur Tambahan

1. Sistem perhitungan emergency berdasarkan severity
2. Program loyalitas dengan poin
3. Fasilitas ruangan yang detail
4. Rating dokter
5. Manajemen stok obat otomatis

## Penggunaan Collection dan Logic

1. ArrayList untuk menyimpan obat dan tindakan
2. Switch-case untuk emergency severity
3. Looping untuk validasi input
4. If-else untuk logika bisnis
5. Method overloading
6. Encapsulation dengan private fields
7. Inheritance dan polymorphism

## Contributor

[Nama Mahasiswa]
[NIM]
[Kelas]
