package nl.craftsmen.moviestore;

public class NewMovie extends AbstractMovie {

    public NewMovie(String title) {
        super(title);
    }


    double getAmount(int daysRented) {
        double amount = 0;
        amount += daysRented * 3;
        return amount;
    }

    int getFrequentRenterPoints(int daysRented) {
        return  daysRented > 1 ? 2 : 1;

    }

}
