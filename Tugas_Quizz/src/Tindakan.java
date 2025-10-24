package src;

public class Tindakan {
    private String name;
    private String description;
    private double cost;

    public Tindakan(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public void display() {
        System.out.println("Tindakan: " + name);
        System.out.println("Deskripsi: " + description);
        System.out.println("Biaya: Rp" + cost);
    }
}
