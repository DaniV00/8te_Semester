package exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class IntSumStreamTests {
    private static final Method method = TestUtil.findAnnotatedMethod(1, 'c');

    @Test
    void testSumStreamSimple1() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1c");
        }

        // Given
        int[] input = new int[] {1, 2, 3};

        // When
        int sum = (int)method.invoke(null, input);

        // Then
        Assertions.assertEquals(6, sum);
    }

    @Test
    void testSumStreamSimple2() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1c");
        }

        // Given
        int[] input = new int[] {42, 100, 81};

        // When
        int sum = (int)method.invoke(null, input);

        // Then
        Assertions.assertEquals(16, sum);
    }

    @Test
    void testSumStreamComplex() throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 1c");
        }

        // Given
        Random rnd = new Random();
        int[] input = IntStream.generate(rnd::nextInt).limit(100).toArray();
        int expectedSum = Arrays.stream(input)
                .map(v -> {
                    int sum = 0;
                    while(v > 0) {
                        int digit = v % 10;
                        sum += digit;
                        v /= 10;
                    }
                    return sum;
                })
                .sum();


        // When
        int actualSum = (int)method.invoke(null, input);

        // Then
        Assertions.assertEquals(expectedSum, actualSum);
    }
}
