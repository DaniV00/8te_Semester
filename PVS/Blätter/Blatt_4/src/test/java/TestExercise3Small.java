import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExercise3Small {
    private static final Method method = TestUtil.findAnnotatedMethod(3, 'a');
    private static final Method journey = TestUtil.findAnnotatedMethod(3, 'j');


    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        var network = method.invoke(null);
        var result = journey.invoke(network);
        assertEquals(5, TestUtil.findAnnotatedMethod(3, '1').invoke(result),
                () -> "Expected 5 stations to be visited, but was " + result);
        assertEquals(10, TestUtil.findAnnotatedMethod(3, '3').invoke(result),
                () -> "Expected 10 spice left in the train, but was " + result);
        assertEquals(5, TestUtil.findAnnotatedMethod(3, '4').invoke(result),
                () -> "Expected 5 fuel left in the train, but was " + result);

        assertEquals(40, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Ulm"),
                () -> "Expected 40 spice left in the Ulm, but was " + result);
        assertEquals(5, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "München"),
                () -> "Expected 5 spice left in the München, but was " + result);
        assertEquals(35, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Stuttgart"),
                () -> "Expected 35 spice left in the Stuttgart, but was " + result);
    }
}
