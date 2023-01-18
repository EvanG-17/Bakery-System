package utils;

// Evan Geary (20098723) - Applied Computing (Computer Forensics and Security), Data Structures and Algorithms.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BakedIngredientsUtilityTest {
    public String[] a;

    @BeforeEach
    void setUp() {
        // Setting up our fields.
        a = new String[]{"Flour", "Eggs", "Milk", "Chocolate", "Sugar", "Alcoholic Spirits", "Fruits","Nuts","Baking Powder","Salt", "Spices","Dairy","Extracts"};
    }

    @AfterEach
    void tearDown() {
        // Setting used fields as null after each test.
        a =  null;
    }

    @Test
    void getBakedIngredientsNames() {
            // Checking to see if the BakedIngredientsUtility class returns the bakedIngredientsName array using a for loop.
            for (int i = 0; i < BakedIngredientsUtility.getBakedIngredientsNames().length; i ++)
                assertEquals(a[i], BakedIngredientsUtility.getBakedIngredientsNames()[i]);
    }
}