package src;

public class Apoteker {
    private String name;
    private String licenseId;
    private String position;  // new: jabatan

    public Apoteker(String name, String licenseId, String position) {
        this.name = name;
        this.licenseId = licenseId;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getPosition() {
        return position;
    }

    public void display() {
        System.out.println("Apoteker: " + name);
        System.out.println("License : " + licenseId);
        System.out.println("Jabatan : " + position);
    }
}
