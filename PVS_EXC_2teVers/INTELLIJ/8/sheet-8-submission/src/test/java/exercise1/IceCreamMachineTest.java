package exercise1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.TestUtil;



public class IceCreamMachineTest {
    private static final Method buyMethod = TestUtil.findAnnotatedMethod(1, 'a');
    private static final Method buyMultipleMethod = TestUtil.findAnnotatedMethod(1, 'd');
    private static final Method maintenanceMethod = TestUtil.findAnnotatedMethod(1, 'e');
    private static final Method errorRecoveryMethod = TestUtil.findAnnotatedMethod(1, 'f');

    private IceCreamMaschine IceCreamMaschine;

    @BeforeEach
    void constructIceCreamMachine(){

        Map<IceCream, Integer> stock = new HashMap<>(){{
            put(IceCream.MELANGE_EIS, 25);
            put(IceCream.OASEN_FRUCHTMIX, 2);
            put(IceCream.SANDDÜNEN_SCHOKOLADE, 1);
        }};

        Map<ComponentType, ElectricalComponent> usedComponents = new HashMap<>(){{
            put(ComponentType.SENSOR, new ElectricalComponent("10", ComponentType.SENSOR));
            put(ComponentType.BATTERY, new ElectricalComponent("01", ComponentType.BATTERY));
        }};

        Set<ElectricalComponent> replacementComponents = new HashSet<>(){{
            add(new ElectricalComponent("11", ComponentType.BATTERY));
            add(new ElectricalComponent("99", ComponentType.SENSOR));
        }};

        IceCreamMaschine = new IceCreamMaschine(stock, usedComponents, replacementComponents);
    }

    @Test
    void testBuyMethod() throws InvocationTargetException, IllegalAccessException {
        if(buyMethod == null){
            Assertions.fail("Method not found to be tested");
        }

        var acceptableExceptions = new ArrayList<>(Arrays.asList(new Class[]{IllegalArgumentException.class, IceCreamNotAvailableException.class}));

        for (var iceCreamType : IceCream.values()) {
            String name = iceCreamType.name();
            Assertions.assertEquals(iceCreamType, buyMethod.invoke(IceCreamMaschine, name));
        }

        Exception exception = Assertions.assertThrows(Exception.class, () -> buyMethod.invoke(IceCreamMaschine, IceCream.SANDDÜNEN_SCHOKOLADE.name()));
        var exceptionClass = exception.getCause().getClass();

        Assertions.assertTrue(acceptableExceptions.contains(exceptionClass));
    }

    @Test
    void testMultipleBuyMethod() throws InvocationTargetException, IllegalAccessException {
        if(buyMultipleMethod == null){
            Assertions.fail("Method not found to be tested");
        }

        var orders = new ArrayList<>(Arrays.asList(IceCream.MELANGE_EIS.name(), IceCream.OASEN_FRUCHTMIX.name(), IceCream.SANDDÜNEN_SCHOKOLADE.name(), IceCream.SANDDÜNEN_SCHOKOLADE.name()));
        var expectedResult = new ArrayList<>(Arrays.asList(IceCream.MELANGE_EIS, IceCream.OASEN_FRUCHTMIX, IceCream.SANDDÜNEN_SCHOKOLADE));
        Assertions.assertEquals(expectedResult, buyMultipleMethod.invoke(IceCreamMaschine, orders));
    }

    @Test
    void testMaintenanceError() throws InvocationTargetException, IllegalAccessException {
        if(maintenanceMethod == null){
            Assertions.fail("Method not found to be tested");
        }

        // try 21 times to use up components -> one time is skipped due to changing
        for(int i = 0; i <= 20; i++){
            buyMethod.invoke(IceCreamMaschine, IceCream.MELANGE_EIS.name());
        }

        // try again, but now the components no longer function with no replacements
        Exception exception=  Assertions.assertThrows(Exception.class, () -> maintenanceMethod.invoke(IceCreamMaschine));
        Assertions.assertEquals(MaintenanceException.class, exception.getCause().getClass());
    }

    @Test
    void testErrorRecoveryMethod() throws InvocationTargetException, IllegalAccessException {
        if(errorRecoveryMethod == null){
            Assertions.fail("Method not found to be tested");
        }

        // replace sensor unit
        Assertions.assertTrue((boolean)errorRecoveryMethod.invoke(IceCreamMaschine, "10"));

        // try to replace again
        Assertions.assertFalse((boolean)errorRecoveryMethod.invoke(IceCreamMaschine, "99"));


        // replace battery unit
        Assertions.assertTrue((boolean)errorRecoveryMethod.invoke(IceCreamMaschine, "01"));

        // try to replace again
        Assertions.assertFalse((boolean)errorRecoveryMethod.invoke(IceCreamMaschine, "11"));

    }
}
