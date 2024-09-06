package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

public class LendBooksTests {
    private static final Method method = TestUtil.findAnnotatedMethod(2, 'e');

    @ParameterizedTest
    @MethodSource("exercise2.LibraryProvider#provideLibrary")
    void lendBookTest(Library library) throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 2e");
        }

        // Given
        var impl = TestUtil.generateFunctionalInterfaceImpl("LendingValidator", new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                LibraryMember member = (LibraryMember)args[0];
                Book book = (Book)args[1];
                return member.getAccessLevel() == LibraryUser.AccessLevel.FULL;
            }
        });
        Assertions.assertNotNull(impl, "LendingValidator Interface not found!");

        library = Library.class.getConstructor(Set.class, Set.class, Class.forName("exercise2.LendingValidator")).newInstance(library.getUsers(), library.getBooks(), impl);

        // When
        List<Book> books = library.getBooks().stream().toList();
        List<LibraryUser> users = library.getUsers().stream().toList();

        boolean canLend1 = (boolean)method.invoke(library, books.getFirst(), users.getFirst());
        boolean canLend2 = (boolean)method.invoke(library, books.getFirst(), users.getLast());

        // Then
        Assertions.assertEquals(users.getFirst().getAccessLevel() == LibraryUser.AccessLevel.FULL, canLend1);
        Assertions.assertEquals(users.getLast().getAccessLevel() == LibraryUser.AccessLevel.FULL, canLend2);
    }
}
