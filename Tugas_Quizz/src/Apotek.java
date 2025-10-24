package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Apotek {
    private Obat[] inventory;
    private Apoteker apoteker; // new

    public Apotek(Obat[] inventory, Apoteker apoteker) {
        this.inventory = inventory;
        this.apoteker = apoteker;
    }

    public void displayInventory() {
        System.out.println("\n--- Inventori Apotek ---");
        for (int i = 0; i < inventory.length; i++) {
            Obat o = inventory[i];
            System.out.printf("%2d. %s (%s) - Rp%.0f - Stok: %d%n", i+1, o.getName(), o.getCode(), o.getPrice(), o.getStock());
        }
    }

    public Obat getObat(int index) {
        if (index >= 0 && index < inventory.length) return inventory[index];
        return null;
    }

    public boolean dispense(int index, int qty) {
        Obat o = getObat(index);
        if (o == null) return false;
        if (o.getStock() >= qty) {
            o.reduceStock(qty);
            return true;
        }
        return false;
    }

    // new: generate resep (cek stok, dispense) dan kembalikan objek Resep
    public Resep createResep(Patient patient, Doctor doctor, int[] indices, int[] qtys) {
        List<Obat> items = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            int q = qtys[i];
            Obat o = getObat(idx);
            if (o == null) continue;
            if (o.getStock() >= q && q > 0) {
                dispense(idx, q);
                items.add(o);
                quantities.add(q);
            } else {
                System.out.println("Stok tidak cukup untuk " + (o != null ? o.getName() : "unknown"));
            }
        }
        Resep r = new Resep(patient.getName(), doctor.getName(), LocalDate.now(), items, quantities);
        System.out.println("\nResep berhasil dibuat oleh apoteker: " + apoteker.getName());
        return r;
    }

    public Apoteker getApoteker() {
        return apoteker;
    }
}
