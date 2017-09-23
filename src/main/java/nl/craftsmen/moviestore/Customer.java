package nl.craftsmen.moviestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getRentalOverview() {
        StringBuilder overviewBuilder = new StringBuilder();

        // Add header to overview
        overviewBuilder.append("Rental overview for " + name + "\n\n");
        for (Rental rental : rentals) {
            overviewBuilder.append(String.format("%-20s %5.2f\n", rental.getMovie().getTitle(), rental.getAmount()));
        }

        // Add footer to overview
        overviewBuilder.append("==========================\n");
        overviewBuilder.append(String.format("%-20s %5.2f\n", "Total", getTotalAmount()));
        overviewBuilder.append("\n");
        overviewBuilder.append("You earned " + getFrequentRenterPoints() + " frequent renter points\n");
        return overviewBuilder.toString();
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}