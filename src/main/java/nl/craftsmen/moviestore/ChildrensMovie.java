package nl.craftsmen.moviestore;

public class ChildrensMovie extends AbstractMovie {

    public ChildrensMovie(String title) {
        super(title);
    }


    double getAmount(int daysRented) {
        double amount = 0;
                amount += 1.5;
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 1.5;
                }
        return amount;
    }

    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
