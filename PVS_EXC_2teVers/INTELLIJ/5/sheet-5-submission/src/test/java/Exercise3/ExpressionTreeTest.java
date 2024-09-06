package Exercise3;

import exercise3.AdditionNode;
import exercise3.ExpressionNode;
import exercise3.MultiplicationNode;
import exercise3.ValueNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTreeTest {
    Constructor<?> valueConstructor = Class.forName("exercise3.ValueNode").getConstructor(int.class);
    Constructor<?> additionConstructor = Class.forName("exercise3.AdditionNode").getConstructor(ExpressionNode.class, ExpressionNode.class);
    Constructor<?> multiplicationConstructor = Class.forName("exercise3.MultiplicationNode").getConstructor(ExpressionNode.class, ExpressionNode.class);
    private static final Method leapYearMethod = TestUtil.findAnnotatedMethod(2, 'c');

    public ExpressionTreeTest() throws ClassNotFoundException, NoSuchMethodException {

    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    public void evaluateTest(int a, int b, int c, int d) throws Exception {
        ValueNode va = (ValueNode) valueConstructor.newInstance(a);
        ValueNode vb = (ValueNode) valueConstructor.newInstance(b);
        ValueNode vc = (ValueNode) valueConstructor.newInstance(c);
        ValueNode vd = (ValueNode) valueConstructor.newInstance(d);

        AdditionNode addAB = (AdditionNode) additionConstructor.newInstance(va, vb);
        AdditionNode addBC = (AdditionNode) additionConstructor.newInstance(vb, vc);
        AdditionNode addCD = (AdditionNode) additionConstructor.newInstance(vc, vd);
        AdditionNode addDA = (AdditionNode) additionConstructor.newInstance(vd, va);
        AdditionNode addABCD = (AdditionNode) additionConstructor.newInstance(addAB, addCD);

        MultiplicationNode mulAB = (MultiplicationNode) multiplicationConstructor.newInstance(va, vb);
        MultiplicationNode mulBC = (MultiplicationNode) multiplicationConstructor.newInstance(vb, vc);
        MultiplicationNode mulCD = (MultiplicationNode) multiplicationConstructor.newInstance(vc, vd);
        MultiplicationNode mulDA = (MultiplicationNode) multiplicationConstructor.newInstance(vd, va);
        MultiplicationNode mulABCD = (MultiplicationNode) multiplicationConstructor.newInstance(mulAB, mulCD);

        MultiplicationNode mulApBCpD = (MultiplicationNode) multiplicationConstructor.newInstance(addAB, addCD);
        AdditionNode addAmBCmD = (AdditionNode) additionConstructor.newInstance(mulAB, mulCD);
        MultiplicationNode mulBCpD = (MultiplicationNode) multiplicationConstructor.newInstance(vb, addCD);
        AdditionNode addABCpD = (AdditionNode) additionConstructor.newInstance(va, mulBCpD);

        assertTrue(addABCD.evaluate().isPresent());
        assertEquals(a+b+c+d, addABCD.evaluate().get());
        assertTrue(mulABCD.evaluate().isPresent());
        assertEquals(a*b*c*d, mulABCD.evaluate().get());
        assertTrue(mulApBCpD.evaluate().isPresent());
        assertEquals((a+b)*(c+d), mulApBCpD.evaluate().get());
        assertTrue(addAmBCmD.evaluate().isPresent());
        assertEquals((a*b) + (c*d), addAmBCmD.evaluate().get());
        assertTrue(addABCpD.evaluate().isPresent());
        assertEquals(a + (b * (c + d)), addABCpD.evaluate().get());
    }

    @Test
    public void edgeCasesEvaluateTest() throws Exception {
        ExpressionNode emptyNode = new ExpressionNode() {
            @Override
            public Optional<Integer> evaluate() { return Optional.empty(); }
            @Override
            public String prettyPrint() { return "";}
        };

        int intValue = 123456;
        ValueNode value = (ValueNode) valueConstructor.newInstance(intValue);

        AdditionNode empty1 = (AdditionNode) additionConstructor.newInstance(null, null);
        AdditionNode empty2 = (AdditionNode) additionConstructor.newInstance(emptyNode, value);
        AdditionNode empty3 = (AdditionNode) additionConstructor.newInstance(value, emptyNode);
        AdditionNode empty4 = (AdditionNode) additionConstructor.newInstance(emptyNode, emptyNode);
        AdditionNode singleChild1 = (AdditionNode) additionConstructor.newInstance(null, value);
        AdditionNode singleChild2 = (AdditionNode) additionConstructor.newInstance(value, null);

        MultiplicationNode empty5 = (MultiplicationNode) multiplicationConstructor.newInstance(null, null);
        MultiplicationNode empty6 = (MultiplicationNode) multiplicationConstructor.newInstance(emptyNode, value);
        MultiplicationNode empty7 = (MultiplicationNode) multiplicationConstructor.newInstance(value, emptyNode);
        MultiplicationNode empty8 = (MultiplicationNode) multiplicationConstructor.newInstance(emptyNode, emptyNode);
        MultiplicationNode singleChild3 = (MultiplicationNode) multiplicationConstructor.newInstance(null, value);
        MultiplicationNode singleChild4 = (MultiplicationNode) multiplicationConstructor.newInstance(value, null);

        assertTrue(empty1.evaluate().isEmpty());
        assertTrue(empty2.evaluate().isEmpty());
        assertTrue(empty3.evaluate().isEmpty());
        assertTrue(empty4.evaluate().isEmpty());
        assertTrue(empty5.evaluate().isEmpty());
        assertTrue(empty6.evaluate().isEmpty());
        assertTrue(empty7.evaluate().isEmpty());
        assertTrue(empty8.evaluate().isEmpty());
        assertTrue(singleChild1.evaluate().isPresent());
        assertTrue(singleChild2.evaluate().isPresent());
        assertTrue(singleChild3.evaluate().isPresent());
        assertTrue(singleChild4.evaluate().isPresent());
        assertEquals(intValue, singleChild1.evaluate().get());
        assertEquals(intValue, singleChild2.evaluate().get());
        assertEquals(intValue, singleChild3.evaluate().get());
        assertEquals(intValue, singleChild4.evaluate().get());
    }

    public static Stream<Arguments> provideNumbers() {
        long arrayCount = 100;
        Random rnd = new Random();

        return Stream.generate(() -> {
            return Arguments.of(
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100));
        }).limit(arrayCount);
    }

}
