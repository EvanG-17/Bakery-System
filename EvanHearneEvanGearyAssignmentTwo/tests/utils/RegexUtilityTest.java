package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexUtilityTest {

    // Setting up fields to be used within test.
    String s1, s2, s3;

    @BeforeEach
    void setUp() {
        // Setting up strings to be tested, before each test.
        // Should return true within the isValidURL() method since it should be in the correct format.
        s1 = "https://www.google.ie";

        // Should also return true within the isValidURL() method since it should be in the correct format.
        s2 = "http://www.google.ie";

        // Should return false within the isValidURL() method since it should not be in the correct format.
        s3 = "www.google.com";
    }

    @AfterEach
    void tearDown() {
        // Re-assigning all fields to null after each test.
        s1 = s2 = s3 = null;
    }

    @Test
    void isValidURL() {
        // Should return true since it is within the correct format.
        assertTrue(RegexUtility.isValidURL(s1));

        // Should return true since it is within the correct format.
        assertTrue(RegexUtility.isValidURL(s2));

        // Should return false since it is not within the correct format.
        assertFalse(RegexUtility.isValidURL(s3));
    }
}