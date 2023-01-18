package main;

import models.BakedGood;
import models.BakedIngredients;
import models.GoodsList;
import models.Recipe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GoodsListTest {
    GoodsList<BakedGood> a;
    GoodsList<BakedIngredients> b;
    GoodsList<Recipe> c;
    BakedGood bakedGoodOne = new BakedGood("Cake", "Ireland", "A very delicious cake, all the way from the Emerald Isle!", "https://www.biggerbolderbaking.com/wp-content/uploads/2019/08/Apple-cake1.png");
    BakedIngredients bakedIngredientsOne = new BakedIngredients("Flour", "A powder made by grinding raw grains, Very important for baking!", 200);
    Recipe recipeOne = new Recipe(bakedGoodOne, bakedIngredientsOne);
    @BeforeEach
    void setUp() {
        a = new GoodsList<>();
        b = new GoodsList<>();
        c = new GoodsList<>();
    }

    @AfterEach
    void tearDown() {
        a = null;
        b = null;
        c = null;
    }

    @Test
    void addElement() {
        a.addElement(bakedGoodOne);
        b.addElement(bakedIngredientsOne);
        c.addElement(recipeOne);

        assertEquals(bakedGoodOne.getName(), a.head.getContents().getName());
        assertEquals(bakedIngredientsOne.getIngredientsName(), b.head.getContents().getIngredientsName());
        assertEquals(recipeOne.getBakedGood().getName(), c.head.getContents().getBakedGood().getName());
    }

    @Test
    void resetSystem() {
        a.resetSystem();
        b.resetSystem();
        c.resetSystem();

        assertNull(a.head);
        assertNull(b.head);
        assertNull(c.head);
    }

    @Test
    void delete() {
        for (int i = 0; i < 3; i++) {
            a.addElement(bakedGoodOne);
            b.addElement(bakedIngredientsOne);
            c.addElement(recipeOne);
        }

        for (int i = 2; i > -1; i--) {
            a.delete(i);
            b.delete(i);
            c.delete(i);
        }

        assertNull(a.head);
        assertNull(b.head);
        assertNull(c.head);
    }

    @Test
    void testToString() {
        a.addElement(bakedGoodOne);
        System.out.println(a.toString());
    }
}