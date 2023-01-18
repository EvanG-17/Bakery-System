package utils;
// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

// References to resources used to implement features within the BakedGoodUtility class.
public class BakedGoodUtility {
    // Arrays used to provide convenience to the user.
    private static final String[] bakedGoodNames = new String[]{"Cake", "Bread", "Tart", "Pie", "Quiche", "Biscuit"};
    private static final String[] countriesOfOrigin = new String[]{"Ireland", "France", "Spain", "United Kingdom"};

    // Getters and Setters used for the BakedGoods class.
    public static String[] getBakedGoodNames() {
        return bakedGoodNames;
    }

    public static String[] getCountriesOfOrigin() {
        return countriesOfOrigin;
    }
}
