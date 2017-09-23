package nl.craftsmen.moviestore;

public class Movie {
    private PriceCode priceCode;
    private String title;

    public Movie(String title, PriceCode priceCode) {
        this.priceCode = priceCode;
        this.title = title;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    double getAmount(int daysRented) {
        double amount = 0;

        // Determine amounts for each line
        switch (getPriceCode()) {
            case CHILDRENS:
                amount += 1.5;
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 1.5;
                }
                break;
            case NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case REGULAR:
                amount += 2;
                if (daysRented > 2) {
                    amount += (daysRented - 2) * 1.5;
                }
                break;
        }
        return amount;
    }

    int getFrequentRenterPoints(int daysRented) {
        // Add frequent renter points
        int frequentRenterPoints = 1;

        // Add bonus for a two day new release rental
        if (getPriceCode() == PriceCode.NEW_RELEASE && daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

}
