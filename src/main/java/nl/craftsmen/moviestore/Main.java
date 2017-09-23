package nl.craftsmen.moviestore;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Customer customer = new Customer("John Doe");
        ChildrensMovie childrensMovie = new ChildrensMovie("Bambi");
        NewMovie newReleaseMovie = new NewMovie("American Sniper");
        RegularMovie regularMovie = new RegularMovie("Gone with the wind");

        customer.addRental(new Rental(childrensMovie, 3));
        customer.addRental(new Rental(newReleaseMovie, 3));
        customer.addRental(new Rental(regularMovie, 4));

        System.out.println(customer.getRentalOverview());
    }
}
