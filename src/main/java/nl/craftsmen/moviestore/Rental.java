package nl.craftsmen.moviestore;

public class Rental {
    private final int daysRented;
    private final Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.daysRented = daysRented;
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getAmount() {
        double amount = 0;

        // Determine amounts for each line
        switch (getMovie().getPriceCode()) {
            case CHILDRENS:
                amount += 1.5;
                if (getDaysRented() > 3) {
                    amount += (getDaysRented() - 3) * 1.5;
                }
                break;
            case NEW_RELEASE:
                amount += getDaysRented() * 3;
                break;
            case REGULAR:
                amount += 2;
                if (getDaysRented() > 2) {
                    amount += (getDaysRented() - 2) * 1.5;
                }
                break;
        }
        return amount;
    }
}
