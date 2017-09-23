package nl.craftsmen.moviestore;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer = new Customer("John Doe");

    private char sep;

    @Before
    public void setup() {
        NumberFormat format = DecimalFormat.getInstance();
        DecimalFormatSymbols symbols = ((DecimalFormat) format).getDecimalFormatSymbols();
        sep = symbols.getDecimalSeparator();
    }

    @Test
    public void no_rented_movies() {
        StringBuilder expectedOverviewBuilder = new StringBuilder();

        expectedOverviewBuilder.append("Rental overview for John Doe\n");
        expectedOverviewBuilder.append("\n");
        expectedOverviewBuilder.append("==========================\n");
        expectedOverviewBuilder.append("Total                 0" + sep + "00\n");
        expectedOverviewBuilder.append("\n");
        expectedOverviewBuilder.append("You earned 0 frequent renter points\n");

        assertEquals(expectedOverviewBuilder.toString(), customer.getRentalOverview());
    }

    @Test
    public void childrens_movie_for_1_day() {
        ChildrensMovie movie = new ChildrensMovie("Bambi");
        Rental rental = new Rental(movie, 1);

        customer.addRental(rental);

        assertRentalOverview(movie, 1.5, 1);
    }


    @Test
    public void childrens_movie_for_3_days() {
        ChildrensMovie movie = new ChildrensMovie("Bambi");
        Rental rental = new Rental(movie, 3);

        customer.addRental(rental);

        assertRentalOverview(movie, 1.5, 1);
    }


    @Test
    public void childrens_movie_for_4_days() {
        ChildrensMovie movie = new ChildrensMovie("Bambi");
        Rental rental = new Rental(movie, 4);

        customer.addRental(rental);

        assertRentalOverview(movie, 3, 1);
    }

    @Test
    public void childrens_movie_for_5_days() {
        ChildrensMovie movie = new ChildrensMovie("Bambi");
        Rental rental = new Rental(movie, 5);

        customer.addRental(rental);

        assertRentalOverview(movie, 4.5, 1);
    }

    @Test
    public void new_release_movie_for_1_day() {
        NewMovie movie = new NewMovie("American Sniper");
        Rental rental = new Rental(movie, 1);

        customer.addRental(rental);

        assertRentalOverview(movie, 3, 1);
    }

    @Test
    public void new_release_movie_for_2_days() {
        NewMovie movie = new NewMovie("American Sniper");
        Rental rental = new Rental(movie, 2);

        customer.addRental(rental);

        assertRentalOverview(movie, 6, 2);
    }

    @Test
    public void new_release_movie_for_3_days() {
        NewMovie movie = new NewMovie("American Sniper");
        Rental rental = new Rental(movie, 3);

        customer.addRental(rental);

        assertRentalOverview(movie, 9, 2);
    }

    @Test
    public void regular_movie_for_1_day() {
        RegularMovie movie = new RegularMovie("Gone with the wind");
        Rental rental = new Rental(movie, 2);

        customer.addRental(rental);

        assertRentalOverview(movie, 2, 1);
    }

    @Test
    public void regular_movie_for_3_days() {
        RegularMovie movie = new RegularMovie("Gone with the wind");
        Rental rental = new Rental(movie, 3);

        customer.addRental(rental);

        assertRentalOverview(movie, 3.5, 1);
    }

    @Test
    public void regular_movie_for_4_days() {
        RegularMovie movie = new RegularMovie("Gone with the wind");
        Rental rental = new Rental(movie, 4);

        customer.addRental(rental);

        assertRentalOverview(movie, 5, 1);
    }

    @Test
    public void three_movies() {
        ChildrensMovie childrensMovie = new ChildrensMovie("Bambi");
        customer.addRental(new Rental(childrensMovie, 3));

        NewMovie newReleaseMovie = new NewMovie("American Sniper");
        customer.addRental(new Rental(newReleaseMovie, 3));

        RegularMovie regularMovie = new RegularMovie("Gone with the wind");
        customer.addRental(new Rental(regularMovie, 4));

        StringBuilder expectedOverviewBuilder = new StringBuilder();
        expectedOverviewBuilder.append("Rental overview for John Doe\n");
        expectedOverviewBuilder.append("\n");
        expectedOverviewBuilder.append("Bambi                 1" + sep + "50\n");
        expectedOverviewBuilder.append("American Sniper       9" + sep + "00\n");
        expectedOverviewBuilder.append("Gone with the wind    5" + sep + "00\n");
        expectedOverviewBuilder.append("==========================\n");
        expectedOverviewBuilder.append("Total                15" + sep + "50\n");
        expectedOverviewBuilder.append("\n");
        expectedOverviewBuilder.append("You earned 4 frequent renter points\n");


        assertEquals(expectedOverviewBuilder.toString(), customer.getRentalOverview());
    }

    private void assertRentalOverview(AbstractMovie movie, double totalAmount, int frequentRenterPoints) {
        StringBuilder expectedOverviewBuilder = new StringBuilder();
        expectedOverviewBuilder.append("Rental overview for John Doe\n");
        expectedOverviewBuilder.append("\n");
        expectedOverviewBuilder.append(String.format("%-20s %5.2f\n", movie.getTitle(), totalAmount));
        expectedOverviewBuilder.append("==========================\n");
        expectedOverviewBuilder.append(String.format("%-20s %5.2f\n", "Total", totalAmount));
        expectedOverviewBuilder.append("\n");
        expectedOverviewBuilder.append("You earned " + frequentRenterPoints + " frequent renter points\n");

        assertEquals(expectedOverviewBuilder.toString(), customer.getRentalOverview());
    }
}