package src;

public class Ruangan {
    private String roomNumber;
    private String type;
    private double pricePerDay;
    private String facilities; // new: deskripsi fasilitas

    public Ruangan(String roomNumber, String type, double pricePerDay, String facilities) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerDay = pricePerDay;
        this.facilities = facilities;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getFacilities() {
        return facilities;
    }

    public void display() {
        System.out.println("Room: " + roomNumber);
        System.out.println("Type: " + type);
        System.out.println("Fasilitas: " + facilities);
        System.out.println("Price/Day: Rp" + pricePerDay);
    }
}
