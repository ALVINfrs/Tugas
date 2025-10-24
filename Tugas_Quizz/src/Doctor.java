
package src;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialization;
    private double rating;
    private int numberOfRatings;
    private List<String> schedule;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.rating = 0.0;
        this.numberOfRatings = 0;
        this.schedule = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getRating() {
        return rating;
    }

    public void addRating(double rating) {
        this.rating = (this.rating * this.numberOfRatings + rating) / (this.numberOfRatings + 1);
        this.numberOfRatings++;
    }

    public void addToSchedule(String timeSlot) {
        this.schedule.add(timeSlot);
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Rating: " + String.format("%.1f", rating));
    }
}
