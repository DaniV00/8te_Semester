package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Optional;

public class BookProcessingTests {
    private static final Method method = TestUtil.findAnnotatedMethod(2, 'f');

    @ParameterizedTest
    @MethodSource("exercise2.LibraryProvider#provideLibrary")
    void processBookTest(Library library) throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 2f");
        }

        // Given
        var impl = TestUtil.generateFunctionalInterfaceImpl("BookProcessor", new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return new ElectronicBook("MAGIC", "VALUE", Collections.singletonList("Hello World"));
            }
        });
        Assertions.assertNotNull(impl, "BookProcessor Interface not found!");

        // When
        method.invoke(library, impl);
        library.addBook(new ElectronicBook("Legit", "Book", Collections.singletonList("Welcome to my book")));

        // Then
        Optional<Book> book = library.getBooks().stream().filter($ -> $.getTitle().equals("VALUE")).findFirst();
        Assertions.assertTrue(book.isPresent());
    }
}
