package nl.craftsmen.moviestore;

public class RegularMovie extends AbstractMovie {

    public RegularMovie(String title) {
        super(title);
    }

    double getAmount(int daysRented) {
        double amount = 0;
        amount += 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
