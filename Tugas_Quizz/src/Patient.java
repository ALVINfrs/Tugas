
package src;

public class Patient {
    private String name;
    private String address;
    private String patientId;
    private String medicalHistory;
    private boolean hasInsurance;
    private int loyaltyPoints;

    public Patient(String name, String address, String patientId, String medicalHistory, boolean hasInsurance) {
        this.name = name;
        this.address = address;
        this.patientId = patientId;
        this.medicalHistory = medicalHistory;
        this.hasInsurance = hasInsurance;
        this.loyaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public boolean hasInsurance() {
        return hasInsurance;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public void display() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Insurance: " + (hasInsurance ? "Yes" : "No"));
        System.out.println("Loyalty Points: " + loyaltyPoints);
    }
}
