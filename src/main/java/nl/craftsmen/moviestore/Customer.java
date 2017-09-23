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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder overviewBuilder = new StringBuilder();

        // Add header to overview
        overviewBuilder.append("Rental overview for " + name + "\n\n");
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();


            // Add rental to overview
            double amount = rental.getAmount();
            overviewBuilder.append(String.format("%-20s %5.2f\n", rental.getMovie().getTitle(), amount));
            totalAmount += amount;
        }

        // Add footer to overview
        overviewBuilder.append("==========================\n");
        overviewBuilder.append(String.format("%-20s %5.2f\n", "Total", totalAmount));
        overviewBuilder.append("\n");
        overviewBuilder.append("You earned " + frequentRenterPoints + " frequent renter points\n");
        return overviewBuilder.toString();
    }

}