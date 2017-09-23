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
        double t = 0;
        int p = 0;
        StringBuilder b = new StringBuilder();

        // Add header to overview
        b.append("Rental overview for " + name + "\n\n");
        for (Rental r : rentals) {
            double a = 0;

            // Determine amounts for each line
            switch (r.getMovie().getPriceCode()) {
                case CHILDRENS:
                    a += 1.5;
                    if (r.getDaysRented() > 3) {
                        a += (r.getDaysRented() - 3) * 1.5;
                    }
                    break;
                case NEW_RELEASE:
                    a += r.getDaysRented() * 3;
                    break;
                case REGULAR:
                    a += 2;
                    if (r.getDaysRented() > 2) {
                        a += (r.getDaysRented() - 2) * 1.5;
                    }
                    break;
            }

            // Add frequent renter points
            p += 1;

            // Add bonus for a two day new release rental
            if (r.getMovie().getPriceCode() == PriceCode.NEW_RELEASE && r.getDaysRented() > 1) {
                p++;
            }

            // Add rental to overview
            b.append(String.format("%-20s %5.2f\n", r.getMovie().getTitle(), a));
            t += a;
        }

        // Add footer to overview
        b.append("==========================\n");
        b.append(String.format("%-20s %5.2f\n", "Total", t));
        b.append("\n");
        b.append("You earned " + p + " frequent renter points\n");
        return b.toString();
    }
}