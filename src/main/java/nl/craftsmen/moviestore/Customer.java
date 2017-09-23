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
            double amount = 0;

            // Determine amounts for each line
            switch (rental.getMovie().getPriceCode()) {
                case CHILDRENS:
                    amount += 1.5;
                    if (rental.getDaysRented() > 3) {
                        amount += (rental.getDaysRented() - 3) * 1.5;
                    }
                    break;
                case NEW_RELEASE:
                    amount += rental.getDaysRented() * 3;
                    break;
                case REGULAR:
                    amount += 2;
                    if (rental.getDaysRented() > 2) {
                        amount += (rental.getDaysRented() - 2) * 1.5;
                    }
                    break;
            }

            // Add frequent renter points
            frequentRenterPoints += 1;

            // Add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == PriceCode.NEW_RELEASE && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // Add rental to overview
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