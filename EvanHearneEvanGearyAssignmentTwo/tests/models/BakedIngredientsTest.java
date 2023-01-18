package models;

// Evan Geary (20098723) - Applied Computing (Computer Forensics and Security), Data Structures and Algorithms.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BakedIngredientsTest {

    BakedIngredients bakedIngredientsOne, bakedIngredientsTwo, bakedIngredientsThree;
    @BeforeEach
    void setUp() {
        // First field uses the default constructor.
        bakedIngredientsOne = new BakedIngredients();

        // Second field assumes all the correct inputs for the defined constructor.
        bakedIngredientsTwo = new BakedIngredients("Flour", "A powder made by grinding raw grains, Very important for baking!", 200);

        // Third field attempts to "break" the constructor, hoping the fields that aren't correct will not be filled.
        bakedIngredientsThree = new BakedIngredients("Chocolate Cake", "A huge chocolate cake, Wow!", 2000, 200);
    }
    @AfterEach
    void tearDown() {
        // Assigns fields as null after each test.
        bakedIngredientsOne = bakedIngredientsTwo = bakedIngredientsThree = null;
    }


    @Test
    void getNextIngredients() {
        // Since the 'next' field is not set yet, all should return null;
        assertNull(bakedIngredientsOne.getNextIngredients());
        assertNull(bakedIngredientsTwo.getNextIngredients());
        assertNull(bakedIngredientsThree.getNextIngredients());
    }


    @Test
    void setNextIngredients() {
        // Assigns the 'next' field within all bakedIngredient fields.
        bakedIngredientsOne.setNextIngredients(bakedIngredientsTwo);
        bakedIngredientsTwo.setNextIngredients(bakedIngredientsThree);
        bakedIngredientsThree.setNextIngredients(bakedIngredientsOne);

        // Checks the 'next' field within all bakedIngredient fields using the getNext() method previously tested above.
        assertEquals(bakedIngredientsTwo, bakedIngredientsOne.getNextIngredients());
        assertEquals(bakedIngredientsThree, bakedIngredientsTwo.getNextIngredients());
        assertEquals(bakedIngredientsOne, bakedIngredientsThree.getNextIngredients());
    }

    @Test
    void getIngredientsName() {

        // bakedIngredientsOne should return "" as nothing was assigned.
        assertEquals("", bakedIngredientsOne.getIngredientsName());

        // bakedIngredientsTwo should return "Cake" since it is within the bakedIngredientsName array.
        assertEquals("Flour", bakedIngredientsTwo.getIngredientsName());

        // bakedIngredientsThree should return "" since its name "Cookie" was not within the bakedIngredientNames array.
        assertEquals("", bakedIngredientsThree.getIngredientsName());
    }

    @Test
    void setIngredientsName() {
        // Re-assigns the name of the bakedIngredients fields as "Sugar", "Metal" and "Fruits".
        // bakedIngredientsOne's name field should be assigned as "Sugar" since it is within the bakedIngredientsName array.
        bakedIngredientsOne.setIngredientsName("Sugar");

        // bakedIngredientsTwo's name field should remain as "Flour" since "Metal" is not within the bakedIngredientsName array.
        bakedIngredientsTwo.setIngredientsName("Metal");

        // bakedIngredientsThree's name field should be assigned as "Fruits" since it is within the bakedIngredientsName array.
        bakedIngredientsThree.setIngredientsName("Fruits");

        // Checks to see if the name was set using getIngredientsName(), tested above.
        // Should return true since "Sugar" is within the bakedIngredientsName array.
        assertEquals("Sugar",bakedIngredientsOne.getIngredientsName());

        // Should return true since "Metal" is not within the bakedIngredientsName array.
        assertNotEquals("Metal", bakedIngredientsTwo.getIngredientsName());

        // Should return true as bakeGoodTwo's name field should not have changed, remaining as "Flour" since it is within the bakedIngredientsName array.
        assertEquals("Flour", bakedIngredientsTwo.getIngredientsName());

        // Should return true since "Fruits" is within the bakedIngredientsName array.
        assertEquals("Fruits", bakedIngredientsThree.getIngredientsName());
    }

    @Test
    void getIngredientsDescription() {
        // Should return true since bakedIngredientsOne's description should be "".
        assertEquals("",bakedIngredientsOne.getIngredientsDescription());

        // Should return true since bakedIngredientsTwo's description should be "A powder made by grinding raw grains, Very important for baking!".
        assertEquals("A powder made by grinding raw grains, Very important for baking!", bakedIngredientsTwo.getIngredientsDescription());

        // Should return true since bakedIngredientsThree's description should be "A huge chocolate cake, Wow!".
        assertEquals("A huge chocolate cake, Wow!",bakedIngredientsThree.getIngredientsDescription());
    }

    @Test
    void setIngredientsDescription() {
        // Re-assigns all description fields as "apple" since we are testing for a blank description.
        bakedIngredientsOne.setIngredientsDescription("apple");
        bakedIngredientsTwo.setIngredientsDescription("apple");
        bakedIngredientsThree.setIngredientsDescription("apple");

        // Checking to ensure all description fields have changed using the getDescription method tested above.
        // Should return true since the set fields did not use a blank string.
        assertEquals("apple", bakedIngredientsTwo.getIngredientsDescription());
        assertEquals("apple", bakedIngredientsTwo.getIngredientsDescription());
        assertEquals("apple", bakedIngredientsThree.getIngredientsDescription());
    }

    @Test
    void getIngredientsCalories() {
        // Should return true since bakedIngredientsOne's calorie content should be 0.
        assertEquals(0,bakedIngredientsOne.getIngredientsCalories());

        // Should return true since bakedIngredientsTwo's calorie content should be 200.
        assertEquals(200, bakedIngredientsTwo.getIngredientsCalories());

        // Should return true since bakedIngredientsThree's calorie content should be 2000.
        assertEquals(2000,bakedIngredientsThree.getIngredientsCalories());
    }

    @Test
    void setIngredientsCalories() {
        // The calorie field in bakedGoodOne should change since 0 should be correct
        bakedIngredientsOne.setIngredientsCalories(0);

        // The calorie field in bakedGoodTwo should not change since 200000 should not be correct
        bakedIngredientsTwo.setIngredientsCalories(200000);

        // The calorie field in bakedGoodThree should change since 2000 should be correct
        bakedIngredientsThree.setIngredientsCalories(2000);

        // Should return true since 0 should be correct, using the getIngredientsCalories method previously tested above.
        assertEquals(0, bakedIngredientsOne.getIngredientsCalories());

        // Should return true since 200000 should not be correct
        assertEquals(200, bakedIngredientsTwo.getIngredientsCalories());

        // Should return true since 2000 should be correct
        assertEquals(2000, bakedIngredientsThree.getIngredientsCalories());
    }

    @Test
    void getQuantity() {
        // Both bakedIngredientsOne and bakedIngredientsTwo should return zero, while bakedIngredientsThree should return 200
        assertEquals(0, bakedIngredientsOne.getQuantity());
        assertEquals(0, bakedIngredientsTwo.getQuantity());
        assertEquals(200, bakedIngredientsThree.getQuantity());
    }

    @Test
    void setQuantity() {
        // All BakedIngredients instances' quantity field should be allowed set above 0 - value 10 used to check that it sets, value -10 used to check that it doesn't set.
        // Setting all instances' quantity fields to 10.
        bakedIngredientsOne.setQuantity(10);
        bakedIngredientsTwo.setQuantity(10);
        bakedIngredientsThree.setQuantity(10);

        // Should all return true since 10 is greater than 0.
        assertEquals(10, bakedIngredientsOne.getQuantity());
        assertEquals(10, bakedIngredientsTwo.getQuantity());
        assertEquals(10, bakedIngredientsThree.getQuantity());

        // Setting all instances' quantity field to -10.
        bakedIngredientsOne.setQuantity(-10);
        bakedIngredientsTwo.setQuantity(-10);
        bakedIngredientsThree.setQuantity(-10);

        // Should all still equal -10 since -10 is below zero.
        assertEquals(10, bakedIngredientsOne.getQuantity());
        assertEquals(10, bakedIngredientsTwo.getQuantity());
        assertEquals(10, bakedIngredientsThree.getQuantity());
    }

}