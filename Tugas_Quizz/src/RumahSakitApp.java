package src;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RumahSakitApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data Dokter (diperbanyak)
        Doctor[] doctors = new Doctor[12];
        doctors[0] = new Doctor("Dr. Budi Santoso", "Penyakit Dalam");
        doctors[1] = new Doctor("Dr. Ani Wijaya", "Syaraf");
        doctors[2] = new Doctor("Dr. Citra Dewi", "Aritmia");
        doctors[3] = new Doctor("Dr. Doni Prakasa", "Psikolog");
        doctors[4] = new Doctor("Dr. Eka Putra", "Umum");
        doctors[5] = new Doctor("Dr. Fajar Ramadhan", "Bedah Umum");
        doctors[6] = new Doctor("Dr. Gita Savitri", "Anak");
        doctors[7] = new Doctor("Dr. Hendra Wijaya", "Jantung");
        doctors[8] = new Doctor("Dr. Indah Permata", "Mata");
        doctors[9] = new Doctor("Dr. Julia Putri", "Gigi");
        doctors[10] = new Doctor("Dr. Kartika Sari", "THT");
        doctors[11] = new Doctor("Dr. Linda Kusuma", "Kulit & Kelamin");

        // Data Obat (diperbanyak)
        Obat[] obats = new Obat[] {
            // Obat Generik
            new Obat("OB001","Paracetamol","Meredakan demam dan nyeri",20000,100),
            new Obat("OB002","Amoxicillin","Antibiotik spectrum luas",50000,50),
            new Obat("OB003","Amiodarone","Obat antiaritmia",150000,20),
            new Obat("OB004","Sertraline","Antidepresan",100000,30),
            new Obat("OB005","Vitamin C","Suplemen daya tahan",30000,200),
            new Obat("OB006","Aspirin","Pengencer darah",25000,80),
            new Obat("OB007","Metoprolol","Beta blocker",120000,25),
            new Obat("OB008","Atorvastatin","Penurun kolesterol",90000,40),
            // Obat Khusus
            new Obat("OB009","Ceftriaxone","Antibiotik suntik",175000,15),
            new Obat("OB010","Omeprazole","Antasida lambung",45000,60),
            new Obat("OB011","Insulin","Kontrol gula darah",80000,10),
            new Obat("OB012","Salbutamol","Inhaler asma",60000,35),
            new Obat("OB013","Heparin","Antikoagulan",110000,12),
            new Obat("OB014","Diclofenac","Anti inflamasi",30000,70),
            new Obat("OB015","Morphine","Analgesik kuat",250000,5),
            // Obat Tambahan
            new Obat("OB016","Metformin","Diabetes oral",35000,45),
            new Obat("OB017","Lansoprazole","Asam lambung",55000,30),
            new Obat("OB018","Alprazolam","Anti cemas",95000,20),
            new Obat("OB019","Simvastatin","Kolesterol",70000,40),
            new Obat("OB020","Amlodipine","Tekanan darah",45000,55)
        };

        // Data Apoteker (diperbanyak)
        Apoteker[] apotekers = new Apoteker[] {
            new Apoteker("Dr. Siti Aisyah, S.Farm, Apt", "AP-12345", "Kepala Apoteker"),
            new Apoteker("Budi Santoso, S.Farm, Apt", "AP-23456", "Apoteker Klinis"),
            new Apoteker("Dewi Putri, S.Farm, Apt", "AP-34567", "Apoteker Senior"),
            new Apoteker("Ahmad Rizki, S.Farm, Apt", "AP-45678", "Apoteker Junior"),
            new Apoteker("Maya Indah, S.Farm, Apt", "AP-56789", "Apoteker Senior"),
            new Apoteker("Rudi Hermawan, S.Farm, Apt", "AP-67890", "Apoteker Klinis"),
            new Apoteker("Nina Sari, S.Farm, Apt", "AP-78901", "Apoteker Junior")
        };

        // Data Tindakan (diperbanyak)
        Tindakan[] tindakanOptions = new Tindakan[12];
        tindakanOptions[0] = new Tindakan("EKG", "Pemeriksaan elektrokardiogram", 250000);
        tindakanOptions[1] = new Tindakan("CT-Scan", "Pemeriksaan CT", 1000000);
        tindakanOptions[2] = new Tindakan("Fisioterapi", "Terapi gerak", 150000);
        tindakanOptions[3] = new Tindakan("Operasi Minor", "Bedah kecil", 2000000);
        tindakanOptions[4] = new Tindakan("Konseling Psikolog", "Sesi konseling", 200000);
        tindakanOptions[5] = new Tindakan("EKG Ambulatory", "Monitoring aritmia", 400000);
        tindakanOptions[6] = new Tindakan("MRI", "Magnetic Resonance Imaging", 2500000);
        tindakanOptions[7] = new Tindakan("Rontgen", "X-Ray diagnostik", 150000);
        tindakanOptions[8] = new Tindakan("USG", "Ultrasonografi", 300000);
        tindakanOptions[9] = new Tindakan("Endoskopi", "Pemeriksaan internal", 800000);
        tindakanOptions[10] = new Tindakan("Kemoterapi", "Terapi kanker", 5000000);
        tindakanOptions[11] = new Tindakan("Hemodialisis", "Cuci darah", 850000);

        // Data Ruangan (diperbanyak)
        Ruangan[] ruanganArr = new Ruangan[8];
        ruanganArr[0] = new Ruangan("VVIP-01", "VVIP Suite", 2500000, 
            "AC Inverter, Smart TV 55\", Sofa Tamu, Kulkas, Microwave, Kamar Mandi Premium, Nurses Station, WiFi Premium");
        ruanganArr[1] = new Ruangan("VIP-01", "VIP", 1500000, 
            "AC, Smart TV 43\", Sofa, Kulkas, Kamar Mandi Dalam, Extra Bed, WiFi");
        ruanganArr[2] = new Ruangan("ICU-01", "ICU", 1000000, 
            "AC, Monitor Pasien, Ventilator, Defibrillator, Nurse Call, Peralatan ICU Lengkap");
        ruanganArr[3] = new Ruangan("K1-01", "Kelas 1", 500000, 
            "AC, TV 32\", Kamar Mandi Dalam, 2 Tempat Tidur, WiFi");
        ruanganArr[4] = new Ruangan("K2-01", "Kelas 2", 250000, 
            "AC, TV Bersama, Kamar Mandi Luar, 4 Tempat Tidur");
        ruanganArr[5] = new Ruangan("PICU-01", "PICU", 1200000, 
            "AC, Monitor Khusus Anak, Ventilator Pediatrik, Nurse Call, Peralatan PICU");
        ruanganArr[6] = new Ruangan("NICU-01", "NICU", 1500000, 
            "AC, Inkubator, Monitor Bayi, Ventilator Neonatal, Peralatan NICU Lengkap");
        ruanganArr[7] = new Ruangan("ISO-01", "Isolasi", 800000, 
            "AC HEPA Filter, Pressure Negatif, Kamar Mandi Dalam, Monitor Pasien");

        System.out.println("Selamat Datang di Sistem Rawat Inap Rumah Sakit");

        // Registrasi Pasien
        System.out.print("Masukkan Nama Pasien: ");
        String namaPasien = scanner.nextLine();
        System.out.print("Masukkan Alamat Pasien: ");
        String alamatPasien = scanner.nextLine();
        System.out.print("Masukkan Riwayat Medis: ");
        String riwayatMedis = scanner.nextLine();
        System.out.print("Apakah memiliki asuransi (true/false): ");
        boolean hasInsurance = scanner.nextBoolean();
        scanner.nextLine(); // consume newline
        Patient patient = new Patient(namaPasien, alamatPasien, "P001", riwayatMedis, hasInsurance);

        // Emergency Handling
        System.out.print("Apakah ini kasus emergency (true/false): ");
        boolean isEmergency = scanner.nextBoolean();
        scanner.nextLine();

        // Pilih Dokter
        System.out.println("\nPilih Dokter:");
        for (int i = 0; i < doctors.length; i++) {
            System.out.println((i + 1) + ". " + doctors[i].getName() + " - " + doctors[i].getSpecialization());
        }
        System.out.print("Pilih nomor dokter: ");
        int pilihanDokter = scanner.nextInt();
        scanner.nextLine();
        Doctor selectedDoctor = doctors[pilihanDokter - 1];

        // Pilih Apoteker bertugas
        System.out.println("\nPilih Apoteker bertugas:");
        for (int i = 0; i < apotekers.length; i++) {
            System.out.println((i + 1) + ". " + apotekers[i].getName());
            System.out.println("   Jabatan: " + apotekers[i].getPosition());
            System.out.println("   Lisensi: " + apotekers[i].getLicenseId());
        }
        System.out.print("Pilih nomor apoteker: ");
        int pilihanApoteker = scanner.nextInt();
        scanner.nextLine();
        
        // Buat objek Apotek dengan apoteker terpilih
        Apotek apotek = new Apotek(obats, apotekers[pilihanApoteker - 1]);
        System.out.println("Apoteker " + apotekers[pilihanApoteker - 1].getName() + " bertugas.");

        // Sekarang buat RawatInap dengan apotek yang sudah diinisialisasi
        RawatInap rawatInap = new RawatInap(patient, selectedDoctor, isEmergency, apotek);

        // Diagnosis dan Tindakan (deskripsi umum)
        System.out.print("Masukkan diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Masukkan tindakan (deskripsi singkat): ");
        String tindakan = scanner.nextLine();
        rawatInap.setDiagnosis(diagnosis, tindakan);

        // Pemberian Obat via Apotek (multi-select dengan qty)
        apotek.displayInventory();
        System.out.print("Pilih nomor obat (pisahkan dengan koma jika lebih dari satu, atau kosong untuk none): ");
        String obatInput = scanner.nextLine().trim();

        List<Integer> chosenIdx = new ArrayList<>();
        List<Integer> chosenQty = new ArrayList<>();

        if (!obatInput.isEmpty()) {
            String[] pilihanObatStr = obatInput.split(",");
            for (String s : pilihanObatStr) {
                int idx = Integer.parseInt(s.trim()) - 1;
                Obat chosen = apotek.getObat(idx);
                if (chosen == null) continue;
                System.out.print("Masukkan jumlah untuk " + chosen.getName() + " (tersedia " + chosen.getStock() + "): ");
                int qty = scanner.nextInt();
                scanner.nextLine();
                if (qty <= 0) {
                    System.out.println("Jumlah tidak valid, dilewati.");
                    continue;
                }
                // hanya simpan pilihan dulu; pengecekan & dispense dilakukan di createResep
                chosenIdx.add(idx);
                chosenQty.add(qty);
            }

            // buat arrays untuk createResep
            int[] indices = new int[chosenIdx.size()];
            int[] qtys = new int[chosenIdx.size()];
            for (int i = 0; i < chosenIdx.size(); i++) {
                indices[i] = chosenIdx.get(i);
                qtys[i] = chosenQty.get(i);
            }

            // create resep — Apotek akan memeriksa stok dan men-dispense
            Resep resep = apotek.createResep(patient, selectedDoctor, indices, qtys);
            resep.display();

            // tambahkan ke rawatInap apabila dispense berhasil (per obat yang tersedia)
            for (int i = 0; i < indices.length; i++) {
                Obat o = apotek.getObat(indices[i]);
                if (o != null) {
                    // cek apakah sebelumnya stok cukup (apotek sudah dispense sehingga stok berkurang)
                    // kita tidak double-dispatch, cukup tambahkan obat ke rawatInap sesuai qtys[i]
                    rawatInap.tambahObat(o, qtys[i]);
                }
            }
        }

        // Pilih Tindakan (multi-select)
        System.out.println("\nPilih Tindakan/Procedure yang dilakukan:");
        for (int i = 0; i < tindakanOptions.length; i++) {
            System.out.println((i + 1) + ". " + tindakanOptions[i].getName() + " - Rp" + tindakanOptions[i].getCost());
        }
        System.out.print("Pilih nomor tindakan (pisahkan dengan koma jika lebih dari satu, atau kosong untuk none): ");
        String tindakanInput = scanner.nextLine().trim();
        if (!tindakanInput.isEmpty()) {
            String[] pilihanTindakan = tindakanInput.split(",");
            for (String s : pilihanTindakan) {
                int idx = Integer.parseInt(s.trim());
                rawatInap.tambahTindakan(tindakanOptions[idx - 1]);
            }
        }

        // Rujukan
        System.out.print("Apakah perlu rujukan ke spesialis lain (true/false): ");
        boolean perluRujukan = scanner.nextBoolean();
        scanner.nextLine();
        if (perluRujukan) {
            System.out.println("\nPilih Dokter Rujukan:");
            for (int i = 0; i < doctors.length; i++) {
                System.out.println((i + 1) + ". " + doctors[i].getName() + " - " + doctors[i].getSpecialization());
            }
            System.out.print("Pilih nomor dokter rujukan: ");
            int pilihanRujukan = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Pasien dirujuk ke " + doctors[pilihanRujukan - 1].getName());
        }

        // Pilih Ruangan dan lama inap (dengan opsi rawat jalan)
        System.out.println("\nPilih Jenis Perawatan:");
        System.out.println("1. Rawat Inap");
        System.out.println("2. Rawat Jalan");
        System.out.print("Pilihan Anda (1/2): ");
        int jenisPerawatan = scanner.nextInt();
        scanner.nextLine();

        if (jenisPerawatan == 1) {
            System.out.println("\nPilih Ruangan untuk inap:");
            for (int i = 0; i < ruanganArr.length; i++) {
                System.out.println((i + 1) + ". " + ruanganArr[i].getRoomNumber() + 
                    " - " + ruanganArr[i].getType() + 
                    " - Rp" + ruanganArr[i].getPricePerDay() + "/hari");
                System.out.println("   Fasilitas: " + ruanganArr[i].getFacilities());
            }
            int pilihanRuangan = -1;
            while (pilihanRuangan < 1 || pilihanRuangan > ruanganArr.length) {
                System.out.print("Masukkan nomor ruangan yang dipilih: ");
                pilihanRuangan = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.print("Masukkan lama inap (hari): ");
            int lamaInap = scanner.nextInt();
            scanner.nextLine();
            rawatInap.assignRoom(ruanganArr[pilihanRuangan - 1], lamaInap);
        } else {
            System.out.println("\nAnda memilih Rawat Jalan");
            // ruangan tetap null untuk rawat jalan
        }

        // Jika emergency, minta severity dan gunakan switch-case untuk surcharge
        if (isEmergency) {
            System.out.println("\nTentukan tingkat emergency (1 = ringan, 2 = sedang, 3 = berat): ");
            int severity = scanner.nextInt();
            scanner.nextLine();
            switch (severity) {
                case 1:
                    rawatInap.addEmergencySurcharge(100000);
                    break;
                case 2:
                    rawatInap.addEmergencySurcharge(300000);
                    break;
                case 3:
                    rawatInap.addEmergencySurcharge(700000);
                    break;
                default:
                    System.out.println("Tingkat tidak valid, tidak ada surcharge tambahan.");
            }
        }

        // Hitung Biaya
        rawatInap.hitungTotalBiaya();
        rawatInap.applyInsurance();

        // Loyalty Program
        patient.addLoyaltyPoints(10);
        if (patient.getLoyaltyPoints() >= 50) {
            System.out.println("Selamat! Anda mendapatkan voucher potongan harga Rp 50.000");
            rawatInap.applyVoucher(50000);
            patient.addLoyaltyPoints(-50);
        }

        // Struk (lebih rapi)
        rawatInap.displayStruk();

        // Booking Jadwal Kontrol
        rawatInap.generateSuratKontrol();

        // Rating Dokter
        System.out.print("\nBeri rating untuk dokter " + selectedDoctor.getName() + " (1-5): ");
        double rating = scanner.nextDouble();
        selectedDoctor.addRating(rating);

        System.out.println("\nTerima kasih telah menggunakan layanan kami.");
        scanner.close();
    }
}
