package util;

import oop.util.Exercise;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Set;

public class TestUtil {
    public static Object generateFunctionalInterfaceImpl(String interfaceName, InvocationHandler handler) {
        try {
            Reflections reflections = new Reflections("", new TypeAnnotationsScanner(), new SubTypesScanner());
            Set<Class<?>> classes = reflections.getTypesAnnotatedWith(FunctionalInterface.class);
            var reflectedInterface = classes.stream()
                    .filter(Class::isInterface)
                    .filter(x -> x.getSimpleName().equals(interfaceName))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("Interface not found!"));
            return Proxy.newProxyInstance(reflectedInterface.getClassLoader(), new Class<?>[] {reflectedInterface}, handler);
        } catch (Exception e) {
            throw new RuntimeException("Could not generate functional interface implementation", e);
        }
    }

    public static Method findAnnotatedMethod(int task, char subtask, Class<?> returnType, Class<?>... parameterTypes) {
        Reflections reflections = new Reflections("", new MethodAnnotationsScanner());
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Exercise.class);

        for (Method method : methods) {
            Exercise exercise = method.getAnnotation(Exercise.class);

            if (exercise.task() == task && exercise.subTask() == subtask &&
                    method.getReturnType() == returnType && Arrays.equals(method.getParameterTypes(), parameterTypes)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
        //throw new RuntimeException("Method for Exercise " + task + subtask + " not found! Unable to perform test");
    }

    public static Method findAnnotatedMethod(int task, char subtask) {
        Reflections reflections = new Reflections("", new MethodAnnotationsScanner());
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Exercise.class);

        for (Method method : methods) {
            Exercise exercise = method.getAnnotation(Exercise.class);

            if (exercise.task() == task && exercise.subTask() == subtask) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
        //throw new RuntimeException("Method for Exercise " + task + subtask + " not found! Unable to perform test");
    }

    public static Method findAnnotatedMethod(int task) {
        Reflections reflections = new Reflections("", new MethodAnnotationsScanner());
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Exercise.class);

        for (Method method : methods) {
            Exercise exercise = method.getAnnotation(Exercise.class);

            if (exercise.task() == task) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
        // throw new RuntimeException("Method for Exercise " + task + " not found! Unable to perform test");
    }
}

