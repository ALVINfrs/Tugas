package src;

import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RawatInap {
    private Patient patient;
    private Doctor doctor;
    private List<Obat> obatList;
    private List<Integer> obatQty;
    private double totalBiaya;
    private boolean isEmergency;
    private String diagnosis;
    private String tindakan;

    private Ruangan ruangan;
    private int roomDays;
    private List<Tindakan> tindakanList;
    private Apotek apotek; // tambah field apotek

    public RawatInap(Patient patient, Doctor doctor, boolean isEmergency, Apotek apotek) { // update konstruktor
        this.patient = patient;
        this.doctor = doctor;
        this.isEmergency = isEmergency;
        this.apotek = apotek; // tambah ini
        this.obatList = new ArrayList<>();
        this.obatQty = new ArrayList<>();
        this.totalBiaya = 0;
        this.tindakanList = new ArrayList<>();
    }

    public void setDiagnosis(String diagnosis, String tindakan) {
        this.diagnosis = diagnosis;
        this.tindakan = tindakan;
    }

    // obat sekarang dengan quantity
    public void tambahObat(Obat obat, int qty) {
        obatList.add(obat);
        obatQty.add(qty);
        totalBiaya += obat.getPrice() * qty;
    }

    public void tambahTindakan(Tindakan t) {
        tindakanList.add(t);
        totalBiaya += t.getCost();
    }

    public void assignRoom(Ruangan r, int days) {
        this.ruangan = r;
        this.roomDays = days;
        totalBiaya += r.getPricePerDay() * days;
    }

    public void hitungTotalBiaya() {
        if (isEmergency) {
            totalBiaya += 500000; // Biaya tambahan untuk emergency
        }
        totalBiaya += 250000; // konsultasi dokter
    }

    public void addEmergencySurcharge(double amount) {
        totalBiaya += amount;
    }

    public void applyVoucher(double voucherAmount) {
        totalBiaya -= voucherAmount;
    }

    public void applyInsurance() {
        if (patient.hasInsurance()) {
            totalBiaya *= 0.8;
        }
    }

    public void displayStruk() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
        String line = "========================================";
        String dash = "----------------------------------------";
        
        System.out.println("\n" + line);
        System.out.println("    RUMAH SAKIT SEHAT SEJAHTERA");
        System.out.println("      STRUK RAWAT INAP PASIEN");
        System.out.println(line);
        System.out.println("Tanggal: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        System.out.println(dash);
        
        // Info Pasien
        System.out.println("INFORMASI PASIEN");
        patient.display();
        System.out.println(dash);
        
        // Info Medis
        System.out.println("INFORMASI MEDIS");
        System.out.println("Dokter     : " + doctor.getName());
        System.out.println("Spesialis  : " + doctor.getSpecialization());
        System.out.println("Diagnosis  : " + diagnosis);
        System.out.println("Tindakan   : " + tindakan);
        System.out.println("Jenis      : " + (ruangan == null ? "Rawat Jalan" : "Rawat Inap"));
        if (isEmergency) System.out.println("Status     : EMERGENCY");
        System.out.println(dash);
        
        // Info Ruangan (hanya tampil jika rawat inap)
        if (ruangan != null) {
            System.out.println("INFORMASI KAMAR");
            System.out.println("Nomor     : " + ruangan.getRoomNumber());
            System.out.println("Tipe      : " + ruangan.getType());
            System.out.println("Lama Inap : " + roomDays + " hari");
            System.out.println("Fasilitas : " + ruangan.getFacilities());
            System.out.printf("Biaya/Hari: %s%n", nf.format(ruangan.getPricePerDay()));
            System.out.printf("Total     : %s%n", nf.format(ruangan.getPricePerDay()*roomDays));
            System.out.println(dash);
        }
        
        // Info Tindakan
        if (!tindakanList.isEmpty()) {
            System.out.println("TINDAKAN MEDIS");
            for (Tindakan t : tindakanList) {
                System.out.printf("%-30s %12s%n", t.getName(), nf.format(t.getCost()));
                System.out.println("  " + t.getDescription());
            }
            System.out.println(dash);
        }
        
        // Info Obat & Resep
        if (!obatList.isEmpty()) {
            System.out.println("RESEP & OBAT-OBATAN");
            System.out.printf("%-3s %-25s %8s %6s %12s%n", "No", "Nama Obat", "Harga", "Qty", "Subtotal");
            System.out.println(dash);
            double obatTotal = 0;
            for (int i = 0; i < obatList.size(); i++) {
                Obat o = obatList.get(i);
                int q = obatQty.get(i);
                double sub = o.getPrice() * q;
                obatTotal += sub;
                System.out.printf("%-3d %-25s %8s %6d %12s%n", 
                    i+1, o.getName(), nf.format(o.getPrice()), q, nf.format(sub));
                System.out.println("    Ket: " + o.getDescription());
            }
            System.out.printf("Total Obat: %33s%n", nf.format(obatTotal));
            System.out.println(dash);
        }
        
        // Rincian Biaya
        System.out.println("RINCIAN BIAYA");
        System.out.printf("%-35s %12s%n", "Konsultasi Dokter", nf.format(250000));
        if (isEmergency) {
            System.out.printf("%-35s %12s%n", "Emergency Fee", nf.format(500000));
        }
        if (patient.hasInsurance()) {
            System.out.printf("%-35s %12s%n", "Potongan Asuransi (20%)", "-" + nf.format(totalBiaya * 0.2));
        }
        System.out.println(dash);
        System.out.printf("TOTAL TAGIHAN: %28s%n", nf.format(totalBiaya));
        System.out.println(line);
        
        // Footer
        System.out.println("\nPerawat/Admin: [Nama Petugas]");
        System.out.println("Apoteker    : " + apotek.getApoteker().getName());
        System.out.println("              " + apotek.getApoteker().getLicenseId());
        System.out.println("\nSemoga Lekas Sembuh!");
        System.out.println(line);
    }

    public void generateSuratKontrol() {
        // menentukan hari kontrol berdasar diagnosis sederhana (keyword)
        int followUpDays = 30;
        String diagLower = (diagnosis == null) ? "" : diagnosis.toLowerCase();
        if (diagLower.contains("aritmia")) followUpDays = 14;
        else if (diagLower.contains("syaraf") || diagLower.contains("neurolog")) followUpDays = 7;
        else if (diagLower.contains("psiko") || diagLower.contains("depres")) followUpDays = 14;
        else if (diagLower.contains("infeksi") || diagLower.contains("antibiotik")) followUpDays = 7;

        LocalDate nextControl = LocalDate.now().plusDays(followUpDays);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMM yyyy");

        System.out.println("\n--- Surat Kontrol / Rujukan ---");
        System.out.println("Pasien     : " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
        System.out.println("Dokter     : " + doctor.getName() + " [" + doctor.getSpecialization() + "]");
        System.out.println("Diagnosis  : " + diagnosis);
        System.out.println("Rekomendasi: Kontrol kembali setelah " + followUpDays + " hari");
        System.out.println("Tanggal    : " + nextControl.format(fmt));
        if (!obatList.isEmpty()) {
            System.out.println("\nResep yang diberikan:");
            for (int i = 0; i < obatList.size(); i++) {
                System.out.println(" - " + obatList.get(i).getName() + " x" + obatQty.get(i));
            }
        }
        System.out.println("-------------------------------");
    }

	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

    public double getTotalBiaya() {
        return totalBiaya;
    }
}
