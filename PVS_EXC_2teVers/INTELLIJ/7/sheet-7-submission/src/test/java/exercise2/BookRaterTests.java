package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;

public class BookRaterTests {
    private static final Method method = TestUtil.findAnnotatedMethod(2, 'a');

    @ParameterizedTest
    @MethodSource("exercise2.LibraryProvider#provideLibrary")
    void processBookTest(Library library) throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 2a");
        }

        // Given
        var impl = TestUtil.generateFunctionalInterfaceImpl("BookRater", new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return 42.0;
            }
        });
        Assertions.assertNotNull(impl, "BookRater Interface not found!");

        library.addBook(new DataCube(Collections.singletonList(new ElectronicBook("Test", "yee", Collections.singletonList("This sentence is false")))));

        // When
        method.invoke(library, impl);

        // Then
        for (Book b : library.getBooks()) {
            Assertions.assertEquals(42.0, b.getRating());
        }
    }
}
