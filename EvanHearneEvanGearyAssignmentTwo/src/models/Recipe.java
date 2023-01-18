package models;

// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

import java.io.Serializable;

public class Recipe implements Serializable {

    // Fields used within the class.
    // "next" field allows linked list implementation.
    private Recipe next;

    private BakedGood bakedGood = new BakedGood();

    private BakedIngredients bakedIngredients = new BakedIngredients();


    // Getters and Setters.
    public Recipe getNext() {
        return next;
    }

    public void setNext(Recipe next) {
        this.next = next;
    }

    public BakedGood getBakedGood() {
        return bakedGood;
    }

    public void setBakedGood(BakedGood bakedGood) {
        this.bakedGood = bakedGood;
    }

    public BakedIngredients getBakedIngredients() {
        return bakedIngredients;
    }

    // Ensures that there is a quantity above zero within the BakedIngredients field.
    public void setBakedIngredients(BakedIngredients bakedIngredients) {
        if (bakedIngredients.getQuantity() > 0)
            this.bakedIngredients = bakedIngredients;
    }

    // Constructors
    public Recipe(BakedGood bakedGood, BakedIngredients bakedIngredients) {
        setBakedGood(bakedGood);
        setBakedIngredients(bakedIngredients);
    }
    public Recipe(){}
}
