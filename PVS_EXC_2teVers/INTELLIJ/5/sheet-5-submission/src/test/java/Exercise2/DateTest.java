package Exercise2;

import exercise2.Date;
import exercise2.DayOfWeek;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
    Constructor<?> dateConstructor = Class.forName("exercise2.Date").getConstructor(int.class, int.class, int.class);
    private static final Method leapYearMethod = TestUtil.findAnnotatedMethod(2, 'c');
    private static final Method dayOfWeekMethod = TestUtil.findAnnotatedMethod(2, 'd');

    public DateTest() throws ClassNotFoundException, NoSuchMethodException {
    }

    @ParameterizedTest
    @MethodSource("provideLeapYears")
    public void leapYearTest(int expected) throws Exception {
        Date date = (Date) dateConstructor.newInstance(expected, 1, 1);
        assertTrue((boolean) leapYearMethod.invoke(date));
    }

    @ParameterizedTest
    @MethodSource("provideLeapYears")
    public void invalidLeapYearTest(int expected) throws Exception {
        Date date1 = (Date) dateConstructor.newInstance(expected + 1, 1, 1);
        Date date2 = (Date) dateConstructor.newInstance(expected + 2, 1, 1);
        Date date3 = (Date) dateConstructor.newInstance(expected + 3, 1, 1);
        assertFalse((Boolean) leapYearMethod.invoke(date1));
        assertFalse((Boolean) leapYearMethod.invoke(date2));
        assertFalse((Boolean) leapYearMethod.invoke(date3));
    }

    public static Stream<Integer> provideLeapYears() {
        return Stream.of(
                1804, 1808, 1812, 1816, 1820, 1824, 1828, 1832, 1836, 1840, 1844, 1848, 1852, 1856, 1860, 1864, 1868, 1872, 1876, 1880, 1884, 1888, 1892, 1896,
                1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000,
                2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096,
                2104, 2108, 2112, 2116, 2120, 2124, 2128, 2132, 2136, 2140, 2144, 2148, 2152, 2156, 2160, 2164, 2168, 2172, 2176, 2180, 2184, 2188, 2192, 2196,
                2204, 2208, 2212, 2216, 2220, 2224, 2228, 2232, 2236, 2240, 2244, 2248, 2252, 2256, 2260, 2264, 2268, 2272, 2276, 2280, 2284, 2288, 2292, 2296,
                2304, 2308, 2312, 2316, 2320, 2324, 2328, 2332, 2336, 2340, 2344, 2348, 2352, 2356, 2360, 2364, 2368, 2372, 2376, 2380, 2384, 2388, 2392, 2396, 2400
        );
    }

    @ParameterizedTest
    @MethodSource("provideDayOfWeek")
    public void getDayOfWeekTest(int year, int month, int day, int expectedDayOfWeek) throws Exception {
        Date date = (Date) dateConstructor.newInstance(year, month, day);
        DayOfWeek dayOfWeek = (DayOfWeek) dayOfWeekMethod.invoke(date);
        assertEquals(expectedDayOfWeek, dayOfWeek.ordinal());
    }

    public static Stream<Arguments> provideDayOfWeek() {
        long arrayCount = 100;
        Random rnd = new Random();

        return Stream.generate(() -> {
            int year = rnd.nextInt(1800, 2100);
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(Calendar.YEAR, year);
            int dayOfYear = rnd.nextInt(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
            gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
            int weekday = gc.getTime().getDay(); // 0 SUN, 1 MON, ... , 6 SAT
            return Arguments.of(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH) + 1, gc.get(Calendar.DAY_OF_MONTH), weekday);
        }).limit(arrayCount);
    } // returns year, month, day, dayOfWeek


}
