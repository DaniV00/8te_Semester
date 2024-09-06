package exercise1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class LongStreamTests {
    private static final Method method = TestUtil.findAnnotatedMethod(1, 'a');

    @Test
    void testLongStreamWithNegatives() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1a");
        }

        // Given
        ArrayList<Long> input = new ArrayList<Long>(Arrays.asList(-1L, 0L, 100L, 40000L, -400L));

        // When
        boolean containsNegative = (boolean)method.invoke(null, input);

        // Then
        Assertions.assertTrue(containsNegative);
    }

    @Test
    void testLongStreamWithoutNegatives() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1a");
        }

        // Given
        ArrayList<Long> input = new ArrayList<Long>(Arrays.asList(1L, 0L, 100L, 40000L, 400L));

        // When
        boolean containsNegative = (boolean)method.invoke(null, input);

        // Then
        Assertions.assertFalse(containsNegative);
    }
}
