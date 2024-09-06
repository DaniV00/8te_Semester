package util;

import oop.util.Exercise;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.Method;
import java.util.Set;

public class TestUtil {
    public static Method findAnnotatedMethod(int task, char subtask) {
        Reflections reflections = new Reflections("", new MethodAnnotationsScanner());
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Exercise.class);

        for (Method method : methods) {
            Exercise exercise = method.getAnnotation(Exercise.class);
            if(exercise.task() == task && exercise.subTask() == subtask) {
                method.setAccessible(true);
                return method;
            }
        }

        throw new RuntimeException("Method for Exercise " + task + subtask + " not found! Unable to perform test");
    }


    public static Method findAnnotatedMethod(int task) {
        Reflections reflections = new Reflections("", new MethodAnnotationsScanner());
        Set<Method> methods = reflections.getMethodsAnnotatedWith(Exercise.class);

        for (Method method : methods) {
            Exercise exercise = method.getAnnotation(Exercise.class);
            if(exercise.task() == task) {
                method.setAccessible(true);
                return method;
            }
        }

        throw new RuntimeException("Method for Exercise " + task + " not found! Unable to perform test");
    }
}

