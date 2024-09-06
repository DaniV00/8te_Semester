package exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.Method;
import java.util.Random;

public class BooleanStreamTests {
    private static final Method method = TestUtil.findAnnotatedMethod(1, 'e');

    @Test
    void testDisjunctionSimpleTrue() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1e");
        }

        // Given
        boolean[] input = {false, true, false, false};

        // When
        boolean disjunction = (boolean)method.invoke(null, input);

        // Then
        Assertions.assertTrue(disjunction);
    }

    @Test
    void testDisjunctionSimpleFalse() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1e");
        }

        // Given
        boolean[] input = {false, false, false, false};

        // When
        boolean disjunction = (boolean)method.invoke(null, input);

        // Then
        Assertions.assertFalse(disjunction);
    }

    @Test
    void testDisjunctionComplex() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1e");
        }

        // Given
        Random rnd = new Random();
        boolean[] input = new boolean[100];
        boolean expectedDisjunction = false;
        for(int i = 0; i < input.length; i++) {
            input[i] = rnd.nextBoolean();
            expectedDisjunction = expectedDisjunction || input[i];
        }

        // When
        boolean actualDisjunction = (boolean)method.invoke(null, input);

        // Then
        Assertions.assertEquals(expectedDisjunction, actualDisjunction);
    }
}
