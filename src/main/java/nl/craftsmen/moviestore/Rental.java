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

    double getAmount() {
        return movie.getAmount(getDaysRented());
    }

    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(getDaysRented());
    }

    String getMovieTitle() {
        return movie.getTitle();
    }
}
