package utils;
// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BakedGoodUtilityTest {

    // Setting up the fields used for this test.
    // a represents the bakedGoodNames array, b represents the countriesOfOrigin array.
    public String[] a,b;

    @BeforeEach
    void setUp() {
        // Setting up our fields.
        a = new String[]{"Cake", "Bread", "Tart", "Pie", "Quiche", "Biscuit"};
        b = new String[]{"Ireland", "France", "Spain", "United Kingdom"};
    }

    @AfterEach
    void tearDown() {
        // Setting used fields as null after each test.
        a = b = null;
    }

    @Test
    void getBakedGoodNames() {
        // Checking to see if the BakedGoodUtility class returns the bakedGoodNames array using a for loop.
        for (int i = 0; i < BakedGoodUtility.getBakedGoodNames().length; i ++)
            assertEquals(a[i], BakedGoodUtility.getBakedGoodNames()[i]);
    }

    @Test
    void getCountriesOfOrigin() {
        // Checking to see if the BakedGoodUtility class returns the countriesOfOrigin array using a for loop.
        for (int i = 0; i < BakedGoodUtility.getCountriesOfOrigin().length; i ++)
            assertEquals(b[i], BakedGoodUtility.getCountriesOfOrigin()[i]);
    }
}