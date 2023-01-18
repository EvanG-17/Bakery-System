package models;
// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

// References to resources used to implement features within the BakedGood class.

import utils.BakedGoodUtility;
import utils.RegexUtility;

import java.io.Serializable;

public class BakedGood implements Serializable {

    // "next" allows us to access the next item within the list.
    private BakedGood next;

    // Fields to be used within the constructor(s).
    private String name = "";
    private String country = "";
    private String description = "";
    private String imageURL = "";

    // Getters and setters with appropriate restrictions for the BakedGood ADT.
    public BakedGood getNext() {
        return next;
    }

    public void setNext(BakedGood next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Checks to see if the name of the baked good is within the array list bakedGoodNames.
        for (String bakedGoodName: BakedGoodUtility.getBakedGoodNames()){
            if (name.equals(bakedGoodName)) {
                this.name = name;
                break;
            }
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        // Checks to see if the name of the country is within the array list countriesOfOrigin.
        for (String countryOfOrigin: BakedGoodUtility.getCountriesOfOrigin()) {
            if (country.equals(countryOfOrigin)) {
                this.country = country;
                break;
            }
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        // Ensures a blank description is not used - no assigned array list used as the description may be unique.
        if (!description.equals(""))
            this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        // Uses the isValidURL() method within the RegexUtility class to determine where the URL within the string matches the regex expression.
        if (RegexUtility.isValidURL(imageURL))
            this.imageURL = imageURL;
    }

    // Constructors for the BakedGood ADT

    public BakedGood(String name, String country, String description, String imageURL) {
        // Setters used within the constructor to take advantage of previously assigned validation.
        setName(name);
        setCountry(country);
        setDescription(description);
        setImageURL(imageURL);
    }

    public BakedGood(){}
}
