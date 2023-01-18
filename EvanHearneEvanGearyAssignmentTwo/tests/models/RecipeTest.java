package models;

// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    // Since other ADTs have been extensively tested, only one instance of BakedGood and BakedIngredients will be used.

    BakedGood bakedGoodOne;
    BakedIngredients bakedIngredientsOne;


    // Recipe ADT will have three instances.

    Recipe recipeOne, recipeTwo, recipeThree;

    @BeforeEach
    void setUp() {
        // Setting up instances before each test.
        // Setting up BakedGood instance.
        bakedGoodOne = new BakedGood("Cake", "Ireland", "A very delicious cake, all the way from the Emerald Isle!", "https://www.biggerbolderbaking.com/wp-content/uploads/2019/08/Apple-cake1.png");
        // Setting up BakedIngredients instance
        bakedIngredientsOne = new BakedIngredients("Flour", "A powder made by grinding raw grains, Very important for baking!", 200, 400);

        // Setting up Recipe instances
        // Blank constructor used.
        recipeOne = new Recipe();
        // Defined constructor used with correctly assigned fields within the ADTs BakedGood and BakedIngredients.
        recipeTwo = new Recipe(bakedGoodOne, bakedIngredientsOne);
        // Defined constructor used with blank ADTs BakedGood and BakedIngredients.
        recipeThree = new Recipe(new BakedGood(), new BakedIngredients());
    }

    @AfterEach
    void tearDown() {
        // Assigning all instances as null after each test.
        bakedGoodOne = null;
        bakedIngredientsOne = null;
        recipeOne = recipeTwo = recipeThree = null;
    }

    @Test
    void getNext() {
        // All Recipe instances should return null for getNext() since there is next field within Recipe hasn't been used yet.
        assertNull(recipeOne.getNext());
        assertNull(recipeTwo.getNext());
        assertNull(recipeThree.getNext());
    }

    @Test
    void setNext() {
        // All Recipe instances' next field will be set to the (n + 1)th Recipe instance.
        recipeOne.setNext(recipeTwo);
        recipeTwo.setNext(recipeThree);
        recipeThree.setNext(recipeOne);

        // Uses the getNext() method tested above to determine the value of the next field within each Recipe instance.
        assertEquals(recipeTwo, recipeOne.getNext());
        assertEquals(recipeThree, recipeTwo.getNext());
        assertEquals(recipeOne, recipeThree.getNext());
    }

    @Test
    void getBakedGood() {
        // Should return a blank string (i.e. BakedGood's default name value) since there is no BakedGood instance within recipeOne's constructor.
        assertEquals(new BakedGood().getName(), recipeOne.getBakedGood().getName());
        // Should return bakedGoodOne since there is a BakedGood instance (bakedGoodOne) within recipeTwo's constructor.
        assertEquals(bakedGoodOne, recipeTwo.getBakedGood());
        // Should return a blank BakedGood name field since a blank BakedGood constructor was used within recipeThree's constructor.
        assertEquals(new BakedGood().getName(), recipeThree.getBakedGood().getName());
    }

    @Test
    void setBakedGood() {
        // Sets each Recipe instance's BakedGood field as bakedGoodOne.
        recipeOne.setBakedGood(bakedGoodOne);
        recipeTwo.setBakedGood(bakedGoodOne);
        recipeThree.setBakedGood(bakedGoodOne);

        // Uses getBakedGood() method previously tested above to determine if each Recipe instance's BakedGood field is set to bakedGoodOne.

        assertEquals(bakedGoodOne, recipeOne.getBakedGood());
        assertEquals(bakedGoodOne, recipeTwo.getBakedGood());
        assertEquals(bakedGoodOne, recipeThree.getBakedGood());
    }

    @Test
    void getBakedIngredients() {
        // Should return "" since there is no BakedIngredients instance used within recipeOne's constructor.
        assertEquals(new BakedIngredients().getIngredientsName(), recipeOne.getBakedIngredients().getIngredientsName());
        // Should return the name of bakedIngredientsOne since it is used within recipeTwo.
        assertEquals(bakedIngredientsOne.getIngredientsName(), recipeTwo.getBakedIngredients().getIngredientsName());
        // Should return a blank String since the default bakedIngredients constructor was used within recipeThree.
        assertEquals(new BakedIngredients().getIngredientsName(), recipeThree.getBakedIngredients().getIngredientsName());
    }

    @Test
    void setBakedIngredients() {
        // Sets all Recipe instances' bakedIngredients fields as bakedIngredientsOne.
        recipeOne.setBakedIngredients(bakedIngredientsOne);
        recipeTwo.setBakedIngredients(bakedIngredientsOne);
        recipeThree.setBakedIngredients(bakedIngredientsOne);

        // Using the previously tested getBakedIngredients() method to determine the value of each Recipe instance.
        assertEquals(bakedIngredientsOne, recipeOne.getBakedIngredients());
        assertEquals(bakedIngredientsOne, recipeTwo.getBakedIngredients());
        assertEquals(bakedIngredientsOne, recipeThree.getBakedIngredients());
    }
}