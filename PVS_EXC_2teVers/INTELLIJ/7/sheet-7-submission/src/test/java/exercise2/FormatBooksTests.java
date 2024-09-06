package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class FormatBooksTests {
    private static final Method method = TestUtil.findAnnotatedMethod(2, 'b');

    @ParameterizedTest
    @MethodSource("exercise2.LibraryProvider#provideLibrary")
    void formatBooks(Library library) throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 2b");
        }

        // Given
        var impl = TestUtil.generateFunctionalInterfaceImpl("BookFormatter", new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return "MAGIC VALUE";
            }
        });
        Assertions.assertNotNull(impl, "BookFormatter Interface not found!");

        // When
        List<?> result = (List<?>)method.invoke(library, impl);

        // Then
        Assertions.assertEquals(library.getBooks().size(), result.size());
        Assertions.assertInstanceOf(Book.class, result.getFirst());
        for (Object o : result) {
            Assertions.assertEquals("MAGIC VALUE", ((Book)o).getContents().getFirst());
        }
    }
}
