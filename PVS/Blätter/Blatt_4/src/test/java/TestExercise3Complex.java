import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExercise3Complex {
    private static final Method method = TestUtil.findAnnotatedMethod(3, 'c');
    private static final Method journey = TestUtil.findAnnotatedMethod(3, 'j');

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        var network = method.invoke(null);
        var result = journey.invoke(network);
        assertEquals(6, TestUtil.findAnnotatedMethod(3, '1').invoke(result),
                () -> "Expected 6 stations to be visited, but was " + result);
        assertEquals(10, TestUtil.findAnnotatedMethod(3, '3').invoke(result),
                () -> "Expected 10 spice left in the train, but was " + result);
        assertEquals(10, TestUtil.findAnnotatedMethod(3, '4').invoke(result),
                () -> "Expected 10 fuel left in the train, but was " + result);

        assertEquals(35, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Graz"),
                () -> "Expected 35 spice left in the Graz, but was " + result);
        assertEquals(25, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Linz"),
                () -> "Expected 25 spice left in the Linz, but was " + result);
        assertEquals(20, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Salzburg"),
                () -> "Expected 20 spice left in the Salzburg, but was " + result);
        assertEquals(15, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Innsbruck"),
                () -> "Expected 15 spice left in the Innsbruck, but was " + result);
        assertEquals(63, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Wien"),
                () -> "Expected 63 spice left in the Wien, but was " + result);
    }
}


