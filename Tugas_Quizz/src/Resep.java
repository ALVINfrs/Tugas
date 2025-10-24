package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Resep {
    private String patientName;
    private String doctorName;
    private LocalDate date;
    private List<Obat> items;
    private List<Integer> qtys;

    public Resep(String patientName, String doctorName, LocalDate date, List<Obat> items, List<Integer> qtys) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.items = items;
        this.qtys = qtys;
    }

    public void display() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMM yyyy");
        System.out.println("\n--- Resep Obat ---");
        System.out.println("Tanggal : " + date.format(fmt));
        System.out.println("Pasien  : " + patientName);
        System.out.println("Dokter  : " + doctorName);
        System.out.println("Obat:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(" - " + items.get(i).getName() + " x" + qtys.get(i) + " (Instruksi: " + items.get(i).getDescription() + ")");
        }
        System.out.println("-------------------");
    }
}
