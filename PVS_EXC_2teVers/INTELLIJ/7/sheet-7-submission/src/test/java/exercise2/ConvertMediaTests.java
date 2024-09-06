package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class ConvertMediaTests {
    private static final Method method = TestUtil.findAnnotatedMethod(2, 'd');

    @ParameterizedTest
    @MethodSource("exercise2.LibraryProvider#provideLibrary")
    void convertMedia(Library library) throws Exception {
        if(method == null) {
            Assertions.fail("Could not find method for Exercise 2d");
        }

        // Given
        var impl = TestUtil.generateFunctionalInterfaceImpl("MediaConverter", new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Book media = (Book)args[0];
                return new MicroFilm(media.getAuthor(), media.getTitle(), media.getContents(), 42);
            }
        });
        Assertions.assertNotNull(impl, "MediaConverter Interface not found!");

        // When
        List<?> result = (List<?>)method.invoke(library, impl);

        // Then
        Assertions.assertEquals(library.getBooks().size(), result.size());
        for(int i = 0; i < result.size(); i++) {
            Object o = result.get(i);
            Assertions.assertInstanceOf(MicroFilm.class, o);

            MicroFilm actualBook = (MicroFilm)o;
            Book expectedBook = (Book)library.getBooks().toArray()[i];

            Assertions.assertEquals(expectedBook.getTitle(), actualBook.getTitle());
            Assertions.assertEquals(expectedBook.getAuthor(), actualBook.getAuthor());
            Assertions.assertLinesMatch(expectedBook.getContents(), actualBook.getContents());
        }
    }
}
