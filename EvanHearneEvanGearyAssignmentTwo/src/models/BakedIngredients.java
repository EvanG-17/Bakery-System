package models;

// Evan Geary (20098723) - Applied Computing (Computer Forensics and Security), Data Structures and Algorithms.

import utils.BakedIngredientsUtility;

import java.io.Serializable;

public class BakedIngredients implements Serializable {

    // "next" allows us to access the next item within the list.
    private BakedIngredients nextIngredients;

    // Fields to be used within the constructor(s).
    private String ingredientsName = "";
    private int ingredientsCalories = 0, quantity = 0; // Quantity is in grams.
    private String ingredientsDescription = "";

    public BakedIngredients getNextIngredients() {
        return nextIngredients;
    }

    public void setNextIngredients(BakedIngredients nextIngredients) {
        this.nextIngredients = nextIngredients;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        // Checks to see if the name of the Baked Ingredient is within the array list baked.
        for (String bakedIngredientsNames: BakedIngredientsUtility.getBakedIngredientsNames()){
            if (ingredientsName.equals(bakedIngredientsNames)) {
                this.ingredientsName = ingredientsName;
                break;
            }
        }
    }

    public int getIngredientsCalories() {
        return ingredientsCalories;
    }

    //Ensures Calorie input is not higher than 3000, A unrealistic amount.
    public void setIngredientsCalories(int ingredientsCalories) {
        if (ingredientsCalories <=3000) {
            this.ingredientsCalories = ingredientsCalories;
        }
    }


    public String getIngredientsDescription() {
        return ingredientsDescription;
    }

    public void setIngredientsDescription(String ingredientsDescription) {
        // Ensures a blank description is not used - no assigned array list used as the description may be unique.
        if (!ingredientsDescription.equals(""))
            this.ingredientsDescription = ingredientsDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        // Ensures we have a set quantity (in grams) greater than zero.
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    // Constructors for the BakedIngredients ADT

    public BakedIngredients(String ingredientsName, String ingredientsDescription, int ingredientsCalories) {
        // Setters used within the constructor to take advantage of previously assigned validation.
        setIngredientsName(ingredientsName);
        setIngredientsDescription(ingredientsDescription);
        setIngredientsCalories(ingredientsCalories);
    }

    public BakedIngredients(String ingredientsName, String ingredientsDescription, int ingredientsCalories, int quantity){
        // Setters used within the constructor to take advantage of previously assigned validation.
        setIngredientsName(ingredientsName);
        setIngredientsDescription(ingredientsDescription);
        setIngredientsCalories(ingredientsCalories);
        setQuantity(quantity);
    }

    BakedIngredients() {
    }

}
