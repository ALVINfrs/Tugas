package src;

public class Obat {
    private String code;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Obat(String code, String name, String description, double price, int stock) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int qty) {
        if (qty <= stock) {
            stock -= qty;
        } else {
            stock = 0;
        }
    }

    public void display() {
        System.out.println(code + " | " + name + " | " + description + " | Harga: Rp" + price + " | Stok: " + stock);
    }
}
