package exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StandardDeviationStreamTests {
    private static final Method method = TestUtil.findAnnotatedMethod(1, 'd');

    @Test
    void testStandardDeviationVerySimple() throws Exception {
        if (method == null) {
            Assertions.fail("Could not find method for Exercise 1d");
        }

        // Given
        ArrayList<Double> input = new ArrayList<Double>(Arrays.asList(1.0, 1.0, 1.0, 1.0));

        // When
        double standardDeviation = (double) method.invoke(null, input);

        // Then
        Assertions.assertEquals(0.0, standardDeviation, 0.01);
    }

    @Test
    void testStandardDeviationSimple() throws Exception {
        if (method == null) {
            Assertions.fail("Could not find method for Exercise 1d");
        }

        // Given
        ArrayList<Double> input = new ArrayList<Double>(Arrays.asList(1.0, -1.0, 1.0, -1.0));

        // When
        double standardDeviation = (double) method.invoke(null, input);

        // Then
        Assertions.assertEquals(1.0, standardDeviation, 0.01);
    }

    double calculateStnadrdDeviation(ArrayList<Double> values) {
        double sum = 0.0;
        for(double d : values) {
            sum += d;
        }

        double average = sum / values.size();
        double variance = 0.0;
        for(double d : values) {
            variance += Math.pow(d - average, 2);
        }

        return Math.sqrt(variance / values.size());
    }

    @Test
    void testStandardDeviationComplex() throws Exception {
        if (method == null) {
            Assertions.fail("Could not find method for Exercise 1d");
        }

        // Given
        Random rnd = new Random();
        ArrayList<Double> input = (ArrayList<Double>)DoubleStream.generate(rnd::nextDouble).limit(100).boxed().collect(Collectors.toList());

        // When
        double standardDeviation = (double) method.invoke(null, input);

        // Then
        Assertions.assertEquals(calculateStnadrdDeviation(input), standardDeviation, 0.01);
    }
}
