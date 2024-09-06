package exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.Method;

public class CharStreamTests {
    private static final Method method = TestUtil.findAnnotatedMethod(1, 'b');

    @Test
    void testCountCharOccurrences() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1b");
        }

        // Given
        char[] input = "Hello World".toCharArray();
        char charToCount = 'l';

        // When
        int count = (int)method.invoke(null, input, charToCount);

        // Then
        Assertions.assertEquals(3, count);
    }

    @Test
    void testCountCharNoOccurrences() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1b");
        }

        // Given
        char[] input = "Hello World".toCharArray();
        char charToCount = 'B';

        // When
        int count = (int)method.invoke(null, input, charToCount);

        // Then
        Assertions.assertEquals(0, count);
    }

}
