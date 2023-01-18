package utils;

// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

// References to resources used to implement features within the RegexUtility class.
// Implementing Regex validation for URLs --> https://www.geeksforgeeks.org/check-if-an-url-is-valid-or-not-using-regular-expression/

import java.util.regex.*;

public class RegexUtility {

    // Method that implements URL regex checks, which is important for loading.

    public static boolean isValidURL(String url) {
        // String which contains the regex for our URL.
        String regex = "((http|https)://)(www.)?" + "[a-zA-Z0-9@:%._+~#?&/=]" + "{2,256}\\.[a-z]" + "{2,6}\\b([-a-zA-Z0-9@:%" + "._+~#?&/=]*)";

        // Regex pattern is compiled.
        Pattern p = Pattern.compile(regex);

        // Compares the URL with the regex using Matcher.
        Matcher m = p.matcher(url);

        // Returns true/false depending on whether the String matches the URL regex.
        return m.matches();
    }

}
