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
}
