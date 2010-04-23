/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.junit;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

/**
 * Utility class providing assert-methods,
 * similiar to the {@link Assert} class.
 * 
 * @author schoenborn@cosmocode.de
 */
public final class Asserts extends Assert {

    /**
     * Prevent instantiation.
     */
    private Asserts() {
        
    }

    /**
     * Asserts that the input matches the regex defined by the pattern.
     * 
     * Fails if pattern is null.
     * Fails if input is null.
     * Fails if input does not match pattern.
     * 
     * @param pattern the {@link Pattern} to check against
     * @param input the input to check
     */
    public static void assertMatches(Pattern pattern, CharSequence input) {
        if (pattern == null) {
            fail("Pattern must not be null");
        } else if (input == null) {
            fail("Input must not be null");
        } else {
            final boolean matches = pattern.matcher(input.toString()).matches();
            assertTrue("'" + input + "' doesn't match '" + pattern.pattern() + "'", matches);
        }
    }
    
    /**
     * Asserts that the input does not match the regex defined by the pattern.
     * 
     * Fails if pattern is null.
     * Fails if input is null.
     * Fails if input matches pattern.
     * 
     * @param pattern the {@link Pattern} to check against
     * @param input the input to check
     */
    public static void assertDoesNotMatch(Pattern pattern, CharSequence input) {
        if (pattern == null) {
            fail("Pattern must not be null");
        } else if (input == null) {
            fail("Input must not be null");
        } else {
            final boolean matches = pattern.matcher(input.toString()).matches();
            assertFalse("'" + input + "' matches '" + pattern.pattern() + "'", matches);
        }
    }
    
    /**
     * Asserts two objects are not equals.
     * 
     * Succeed if expected is null.
     * Fails if expected is equals to actual.
     * 
     * @param expected the value to check the other parameter against
     * @param actual the value to check
     */
    public static void assertNotEquals(Object expected, Object actual) {
        if (expected == null) return;
        if (expected.equals(actual)) {
            fail("expected not equals:<" + expected + "> was :<" + actual + ">");
        }
    }
    
    /**
     * Asserts parameter is empty.
     * 
     * See also {@link StringUtils#isEmpty(String)}.
     * 
     * Fails if s is not empty.
     * 
     * @param s the value to check
     */
    public static void assertEmpty(String s) {
        assertTrue("expected empty but was :<" + s + ">", StringUtils.isEmpty(s));
    }
    
    /**
     * Asserts paramter is blank.
     * 
     * See also {@link StringUtils#isBlank(String)}.
     * 
     * Fails if s is not blank.
     * 
     * @param s the value to check
     */
    public static void assertBlank(String s) {
        assertTrue("expected blank but was :<" + s + ">", StringUtils.isBlank(s));
    }
    
}
