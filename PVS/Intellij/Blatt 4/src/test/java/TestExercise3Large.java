import org.junit.jupiter.api.Test;
import util.TestUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExercise3Large {
    private static final Method method = TestUtil.findAnnotatedMethod(3, 'b');
    private static final Method journey = TestUtil.findAnnotatedMethod(3, 'j');

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        var network = method.invoke(null);
        var result = journey.invoke(network);
        assertEquals(7, TestUtil.findAnnotatedMethod(3, '1').invoke(result),
                () -> "Expected 7 stations to be visited, but was " + result);
        assertEquals(5, TestUtil.findAnnotatedMethod(3, '3').invoke(result),
                () -> "Expected 5 spice left in the train, but was " + result);
        assertEquals(15, TestUtil.findAnnotatedMethod(3, '4').invoke(result),
                () -> "Expected 15 fuel left in the train, but was " + result);

        assertEquals(50, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Hamburg"),
                () -> "Expected 50 spice left in the Hamburg, but was " + result);
        assertEquals(60, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Frankfurt"),
                () -> "Expected 60 spice left in the Frankfurt, but was " + result);
        assertEquals(20, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Köln"),
                () -> "Expected 20 spice left in the Köln, but was " + result);
        assertEquals(10, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Düsseldorf"),
                () -> "Expected 15 spice left in the Düsseldorf, but was " + result);
        assertEquals(0, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Dresden"),
                () -> "Expected 0 spice left in the Dresden, but was " + result);
        assertEquals(115, TestUtil.findAnnotatedMethod(3, '5').invoke(result, "Berlin"),
                () -> "Expected 115 spice left in the Berlin, but was " + result);
    }
}
