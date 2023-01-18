package models;
// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BakedGoodTest {

    // Setting up fields to be tested.
    BakedGood bakedGoodOne, bakedGoodTwo, bakedGoodThree;
    @BeforeEach
    void setUp() {
        // First field uses the default constructor.
        bakedGoodOne = new BakedGood();

        // Second field assumes all the correct inputs for the defined constructor.
        bakedGoodTwo = new BakedGood("Cake", "Ireland", "A very delicious cake, all the way from the Emerald Isle!", "https://www.biggerbolderbaking.com/wp-content/uploads/2019/08/Apple-cake1.png");

        // Third field attempts to "break" the constructor, hoping the fields that aren't correct will not be filled.
        bakedGoodThree = new BakedGood("Cookie", "Canada", "This cookie is very tasty, with real Canadian butter!","image.com/CanadaCookie");
    }

    @AfterEach
    void tearDown() {
        // Assigns fields as null after each test.
        bakedGoodOne = bakedGoodTwo = bakedGoodThree = null;
    }

    @Test
    void getNext() {
        // Since the 'next' field is not set yet, all should return null;
        assertNull(bakedGoodOne.getNext());
        assertNull(bakedGoodTwo.getNext());
        assertNull(bakedGoodThree.getNext());
    }

    @Test
    void setNext() {
        // Assigns the 'next' field within all bakedGood fields.
        bakedGoodOne.setNext(bakedGoodTwo);
        bakedGoodTwo.setNext(bakedGoodThree);
        bakedGoodThree.setNext(bakedGoodOne);

        // Checks the 'next' field within all bakedGood fields using the getNext() method previously tested above.
        assertEquals(bakedGoodTwo, bakedGoodOne.getNext());
        assertEquals(bakedGoodThree, bakedGoodTwo.getNext());
        assertEquals(bakedGoodOne, bakedGoodThree.getNext());
    }

    @Test
    void getName() {
        // bakedGoodOne should return "" as nothing was assigned.
        assertEquals("", bakedGoodOne.getName());

        // bakedGoodTwo should return "Cake" since it is within the bakedGoodNames array.
        assertEquals("Cake", bakedGoodTwo.getName());

        // bakedGoodThree should return "" since its name "Cookie" was not within the bakedGoodName array.
        assertEquals("", bakedGoodThree.getName());
    }

    @Test
    void setName() {
        // Re-assigns the name of the bakedGood fields as "Pie", "Pastry" and "Bread".
        // bakedGoodOne's name field should be assigned as "Pie" since it is within the bakedGoodNames array.
        bakedGoodOne.setName("Pie");

        // bakedGoodTwo's name field should remain as "Cake" since "Pastry" is not within the bakedGoodNames array.
        bakedGoodTwo.setName("Pastry");

        // bakedGoodThree's name field should be assigned as "Bread" since it is within the bakedGoodNames array.
        bakedGoodThree.setName("Bread");

        // Checks to see if the name was set using getName(), tested above.
        // Should return true since "Pie" is within the bakedGoodNames array.
        assertEquals("Pie",bakedGoodOne.getName());

        // Should return true since "Pastry" is not within the bakedGoodNames array.
        assertNotEquals("Pastry", bakedGoodTwo.getName());

        // Should return true as bakeGoodTwo's name field should not have changed, remaining as "Cake" since it is within the bakedGoodNames array.
        assertEquals("Cake", bakedGoodTwo.getName());

        // Should return true since "Bread" is within the bakedGoodNames array.
        assertEquals("Bread", bakedGoodThree.getName());
    }

    @Test
    void getCountry() {
        // bakedGoodOne's country field should return "" since a blank constructor was used.
        assertEquals("", bakedGoodOne.getCountry());

        // bakedGoodTwo's country field should return "Ireland" since it is within the countriesOfOrigin array.
        assertEquals("Ireland", bakedGoodTwo.getCountry());

        // bakedGoodThree's country field should return "" since "Canada" is not within the countriesOfOrigin array.
        assertEquals("", bakedGoodThree.getCountry());
    }

    @Test
    void setCountry() {
        // Re-assigns the bakedGood country fields as "Canada", "Japan" and "United Kingdom".
        // bakedGoodOne's country field should not have changed since "Canada" does not exist in the countriesOfOrigin array, and should remain blank.
        bakedGoodOne.setCountry("Canada");

        // bakedGoodTwo's country field should not have changed either, since "Japan" does not exist in the countriesOfOrigin array, and should remain as "Ireland".
        bakedGoodTwo.setCountry("Japan");

        // bakedGoodThree's country field should have changed since "United Kingdom" is in the countriesOfOrigin field.
        bakedGoodThree.setCountry("United Kingdom");

        // Checks to see if the bakedGood's country field has changed using getCountry() previously tested above.
        // Should return true since bakedGoodOne's country field should not have changed.
        assertNotEquals("Canada", bakedGoodOne.getCountry());

        // Should return true since bakedGoodOne's country field is "".
        assertEquals("", bakedGoodOne.getCountry());

        // Should return true since bakedGoodTwo's country field should not have changed.
        assertNotEquals("Japan", bakedGoodTwo.getCountry());

        // Should return true since bakedGoodTwo's country field remains "Ireland";
        assertEquals("Ireland", bakedGoodTwo.getCountry());

        //Should return true since bakedGoodThree's country field should have changed to "United Kingdom".
        assertEquals("United Kingdom", bakedGoodThree.getCountry());
    }

    @Test
    void getDescription() {
        // Should return true since bakedGoodOne's description should be "".
        assertEquals("",bakedGoodOne.getDescription());

        // Should return true since bakedGoodTwo's description should be "A very delicious cake, all the way from the Emerald Isle!".
        assertEquals("A very delicious cake, all the way from the Emerald Isle!", bakedGoodTwo.getDescription());

        // Should return true since bakedGoodThree's description should be "This cookie is very tasty, with real Canadian butter!".
        assertEquals("This cookie is very tasty, with real Canadian butter!",bakedGoodThree.getDescription());
    }

    @Test
    void setDescription() {
        // Re-assigns all description fields as "a" since we are testing for a blank description.
        bakedGoodOne.setDescription("a");
        bakedGoodTwo.setDescription("a");
        bakedGoodThree.setDescription("a");

        // Checking to ensure all description fields have changed using the getDescription method tested above.
        // Should return true since the set fields did not use a blank string.
        assertEquals("a", bakedGoodOne.getDescription());
        assertEquals("a", bakedGoodTwo.getDescription());
        assertEquals("a", bakedGoodThree.getDescription());
    }

    @Test
    void getImageURL() {
        // Should return true since bakedGoodOne's imageURL field should be "".
        assertEquals("", bakedGoodOne.getImageURL());

        // Should return true since bakedGoodTwo's imageURL field should have met the regex requirements.
        assertEquals("https://www.biggerbolderbaking.com/wp-content/uploads/2019/08/Apple-cake1.png", bakedGoodTwo.getImageURL());

        // Should return true since bakedGoodThree's imageURL field should not have met the regex requirements.
        assertNotEquals("image.com/CanadaCookie", bakedGoodThree.getImageURL());

        // Should return true since bakedGoodThree's imageURL should be "".
        assertEquals("",bakedGoodThree.getImageURL());

    }

    @Test
    void setImageURL() {
        // Re-assigns the imageURL fields in all bakedGood field.
        // The imageURL field in bakedGoodOne should change since "https://www.google.com" should have met the regex requirements.
        bakedGoodOne.setImageURL("https://www.google.com");

        // The imageURL field in bakedGoodTwo should not change since "image.com/cake" should not meet the regex requirements.
        bakedGoodTwo.setImageURL("image.com/cake");

        // The imageURL field in bakedGoodThree should change since "http://www.google.com" should have met the regex requirements.
        bakedGoodThree.setImageURL("http://www.google.com");

        // Should return true since "https://www.google.com" should have met the regex requirements in isValidURL from RegexUtility, using the getImageURL method previously tested above.
        assertEquals("https://www.google.com", bakedGoodOne.getImageURL());

        // Should return true since "image.com/cake" does not meet the regex requirements.
        assertEquals("https://www.biggerbolderbaking.com/wp-content/uploads/2019/08/Apple-cake1.png", bakedGoodTwo.getImageURL());

        // Should return true since "http://www.google.com" should have met the regex requirements.
        assertEquals("http://www.google.com", bakedGoodThree.getImageURL());
    }
}