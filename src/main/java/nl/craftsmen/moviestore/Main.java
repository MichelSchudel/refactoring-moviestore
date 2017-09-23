package nl.craftsmen.moviestore;

import java.io.IOException;

import static nl.craftsmen.moviestore.PriceCode.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Customer customer = new Customer("John Doe");
        Movie childrensMovie = new Movie("Bambi", CHILDRENS);
        Movie newReleaseMovie = new Movie("American Sniper", NEW_RELEASE);
        Movie regularMovie = new Movie("Gone with the wind", REGULAR);

        customer.addRental(new Rental(childrensMovie, 3));
        customer.addRental(new Rental(newReleaseMovie, 3));
        customer.addRental(new Rental(regularMovie, 4));

        System.out.println(customer.getRentalOverview());
    }
}
