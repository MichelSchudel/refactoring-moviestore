package nl.craftsmen.moviestore;

public abstract class AbstractMovie {
    protected String title;

    public AbstractMovie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract double getAmount(int dayRented);

    abstract int getFrequentRenterPoints(int daysRented);


}
