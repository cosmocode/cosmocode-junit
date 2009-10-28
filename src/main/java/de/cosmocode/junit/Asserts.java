package de.cosmocode.junit;

import java.util.regex.Pattern;

import org.junit.Assert;

public final class Asserts extends Assert {

    /**
     * Prevent instantiation
     */
    private Asserts() {
        
    }
    
    public static void assertMatches(Pattern pattern, Object input) {
        if (pattern == null) {
            fail("Pattern must not be null");
        } else if (input == null) {
            fail("Input must not be null");
        } else {
            assertTrue(input + " doesn't match " + pattern.pattern(), pattern.matcher(input.toString()).matches());
        }
    }
    
    public static void assertDoesNotMatch(Pattern pattern, Object input) {
        if (pattern == null) {
            fail("Pattern must not be null");
        } else if (input == null) {
            fail("Input must not be null");
        } else {
            assertFalse(input + " matches " + pattern.pattern(), pattern.matcher(input.toString()).matches());
        }
    }
    
    public static void assertNotEquals(Object expected, Object actual) {
        if (expected == null) return;
        if (expected.equals(actual)) {
            fail("expected not equals:<" + expected + "> was :<" + actual + ">");
        }
    }
    
}