package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class FindBooksByTitleTests {
    private static final Method method = TestUtil.findAnnotatedMethod(2, 'c');

    @ParameterizedTest
    @MethodSource("exercise2.LibraryProvider#provideLibrary")
    void findBooksSorted(Library library) throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 2c");
        }

        // Given
        var impl = TestUtil.generateFunctionalInterfaceImpl("BookComparator", new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Book b1 = (Book)args[0];
                Book b2 = (Book)args[1];
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
        Assertions.assertNotNull(impl, "BookComparator Interface not found!");


        // When
        List<?> result = (List<?>)method.invoke(library, "Test", impl);

        // Then
        Assertions.assertEquals(4, result.size());
        Assertions.assertInstanceOf(Book.class, result.getFirst());
        Assertions.assertEquals(((Book)result.get(0)).getTitle(), "Test Book 1");
        Assertions.assertEquals(((Book)result.get(1)).getTitle(), "Test Book 2");
        Assertions.assertEquals(((Book)result.get(2)).getTitle(), "Test Book 3");
        Assertions.assertEquals(((Book)result.get(3)).getTitle(), "Test Book 4");
    }
}
