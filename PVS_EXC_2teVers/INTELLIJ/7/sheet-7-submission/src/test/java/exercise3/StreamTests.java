package exercise3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.TestUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class StreamTests {
    private static final Method sumMethod = TestUtil.findAnnotatedMethod(3, 'a');
    private static final Method concatMethod = TestUtil.findAnnotatedMethod(3, 'b');
    private static final Method minMethod = TestUtil.findAnnotatedMethod(3, 'c');
    private static final Method averageMethod = TestUtil.findAnnotatedMethod(3, 'd');
    private static final Method medianMethod = TestUtil.findAnnotatedMethod(3, 'e');
    private static final Method combineMethod = TestUtil.findAnnotatedMethod(3, 'f');
    private static final Method mostFreqMethod = TestUtil.findAnnotatedMethod(3, 'g');
    private static final Method partitionMethod = TestUtil.findAnnotatedMethod(3, 'h');
    private static final Method countRangeMethod = TestUtil.findAnnotatedMethod(3, 'i');
    private static final Method weightedAvgMethod = TestUtil.findAnnotatedMethod(3, 'j');
    private static final Method kthElementMethod = TestUtil.findAnnotatedMethod(3, 'k');
    private static final Method firstLetterMethod = TestUtil.findAnnotatedMethod(3, 'l');
    private static final Method closestPointsMethod = TestUtil.findAnnotatedMethod(3, 'm');
    private static final Method mergeIntervalMethod = TestUtil.findAnnotatedMethod(3, 'n');

    private static final Constructor<?> kthLargestConstructor = getKthLargestConstructor();
    private static final Method kthAddMethod = getKthAddMethod();
    private static final Method kthLargestMethod = getKthLargestMethod();

    @ParameterizedTest
    @MethodSource("provideSumArguments")
    @DisplayName("Sum of Integers")
    void testSum(List<Integer> list, int expected) throws InvocationTargetException, IllegalAccessException {
        Integer result = (Integer) sumMethod.invoke(null, list);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideSumArguments() {
        return Stream.of(
            Arguments.of(List.of(), 0),
            Arguments.of(List.of(16, 5, 15, -9, 18, -8, -2, 20, 2, -18, 13, -8, 8, -6, -18, -1, -2, 20, 19, 18), 82),
            Arguments.of(List.of(-17), -17),
            Arguments.of(List.of(16, -17, -15, -6, -6, 14, -18, -2, 17, -10, -7, 6, -12, 14, -10, -17, 3), -50),
            Arguments.of(List.of(3, 19, -17, -18, -14, 3, -3, -4, 0, 14, 4), -13),
            Arguments.of(List.of(15, -10), 5),
            Arguments.of(List.of(-14, -8, 13, -13, -10, 1), -31),
            Arguments.of(List.of(-3, -14), -17),
            Arguments.of(List.of(-3, -16, -3, -13, -17, 20, -9, -20, -7, -9, 13, 1, 7), -56),
            Arguments.of(List.of(17, 19, 16, 3, 12, 0, 16, -6, 3, 18, 12, -9, -6, -3, -12), 80),
            Arguments.of(List.of(16), 16),
            Arguments.of(List.of(2, -1, 15, 5, -15, 2, 1, 17, 8, -17, 19, -18, -12, -10, 4, 11, 2, 0), 13),
            Arguments.of(List.of(-4, 20, 1, 8, -6, -15, -3, -10, 19, -8, 6, -18, 1, 6, -14, -18, -5, 6, 4, 10), -20),
            Arguments.of(List.of(4, 17, 5, -4, 6, -2, 13, -17, 9, 1, 0), 32),
            Arguments.of(List.of(-20, 9, 3, 4, 13, 6, 20, -5), 30),
            Arguments.of(List.of(-6, 6, 4, 20, 15, -3, -6, 17, -12, -2, -5, -12, 16, 8, 8, -16, 9), 41),
            Arguments.of(List.of(-16, -12, 18, 19, 13, -20, -9, 11, -19, 8), -7),
            Arguments.of(List.of(-6, 19, 2, 1, -5, 0, 5, 8, 12, 4, 20, -2, -14, 11, 10, -19, -17, -19, -9, -15), -14),
            Arguments.of(List.of(-7, -16, -12, 5, 20, -19, 0, -5), -34),
            Arguments.of(List.of(18, -3, 16), 31)
        );
    }

    @ParameterizedTest
    @MethodSource("provideConcatArguments")
    @DisplayName("Concatenating String")
    void testConcat(List<String> list, String expected) throws InvocationTargetException, IllegalAccessException {
        String result = (String) concatMethod.invoke(null, list);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideConcatArguments() {
        return Stream.of(
            Arguments.of(List.of(), ""),
            Arguments.of(List.of(""), ""),
            Arguments.of(List.of("efX", "VYZFl", "b", "jlZzlVUp", "Hd", "IaHFMFpb", "mf", "VY"), "efXVYZFlbjlZzlVUpHdIaHFMFpbmfVY"),
            Arguments.of(List.of("b", "xBormP", "eaBF", "qIYU", "l"), "bxBormPeaBFqIYUl"),
            Arguments.of(List.of("VFA", "K"), "VFAK"),
            Arguments.of(List.of("Hn", "", "RidqqHIt", "dKOvMj", "XUdUM"), "HnRidqqHItdKOvMjXUdUM"),
            Arguments.of(List.of("TZkTocTC", "QdvgIj", "fFHDKBkz", "SqC", "tGyge", "bHySQV", "h"), "TZkTocTCQdvgIjfFHDKBkzSqCtGygebHySQVh"),
            Arguments.of(List.of("RqdX", "", "UPUZIuXd"), "RqdXUPUZIuXd"),
            Arguments.of(List.of("rMBKiyc", "i", "Lw", "Teclyi", "ZWkJTJL", "NLbGqQb", "", "RGwMKIuq"), "rMBKiyciLwTeclyiZWkJTJLNLbGqQbRGwMKIuq"),
            Arguments.of(List.of("PoYut", "kzh", "A", "ZQmdAS", "lSUDAPhI"), "PoYutkzhAZQmdASlSUDAPhI"),
            Arguments.of(List.of("zeIWLh", "bYHW", "LsGweqT", "cTqpD", "qoVasutb", "Tw", "DVsBb", "SySe"), "zeIWLhbYHWLsGweqTcTqpDqoVasutbTwDVsBbSySe"),
            Arguments.of(List.of("DIZ", "BqBLO"), "DIZBqBLO"),
            Arguments.of(List.of("HTAOgUS", "kZ", "i", "swZHUYFa", "", "ECbrXo", "vOOnOpr", "bZIs", "XeKgUOHf", "onQN"), "HTAOgUSkZiswZHUYFaECbrXovOOnOprbZIsXeKgUOHfonQN"),
            Arguments.of(List.of("uD", "ASPju", "", "SeDKQ", "MSyRqV", "mYWaDA", "GK"), "uDASPjuSeDKQMSyRqVmYWaDAGK"),
            Arguments.of(List.of("T", "jDWl", "", "GKv"), "TjDWlGKv"),
            Arguments.of(List.of("RRjS"), "RRjS"),
            Arguments.of(List.of("mKDtzdCE", "kWOOaT", "z", "KZfme", "sQqxfu", "eiQ"), "mKDtzdCEkWOOaTzKZfmesQqxfueiQ"),
            Arguments.of(List.of("Mel"), "Mel"),
            Arguments.of(List.of("mbOZnfob", "yM", "dWN", "AcQz", "REg", ""), "mbOZnfobyMdWNAcQzREg"),
            Arguments.of(List.of("KPJWDjb", "qAcBwL", "", "wz", "blzWA", "bAPK"), "KPJWDjbqAcBwLwzblzWAbAPK")
        );
    }

    @ParameterizedTest
    @MethodSource("provideMinArguments")
    @DisplayName("Find Minimum")
    void testMinPrice(List<ValuableItem> items, int expected) throws InvocationTargetException, IllegalAccessException {
        Integer result = (Integer) minMethod.invoke(null, items);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideMinArguments() {
        return Stream.of(
            Arguments.of(List.of(randItem(1)), 1),
            Arguments.of(List.of(randItem(19), randItem(3), randItem(7), randItem(1), randItem(19), randItem(7), randItem(6)), 1),
            Arguments.of(List.of(randItem(12), randItem(9), randItem(1), randItem(4)), 1),
            Arguments.of(List.of(randItem(9), randItem(3), randItem(18), randItem(5), randItem(13), randItem(20), randItem(9), randItem(15)), 3),
            Arguments.of(List.of(randItem(1), randItem(17), randItem(19), randItem(14), randItem(19), randItem(12), randItem(17), randItem(6)), 1),
            Arguments.of(List.of(randItem(7), randItem(3), randItem(19), randItem(14), randItem(6), randItem(16), randItem(16)), 3),
            Arguments.of(List.of(randItem(10), randItem(19), randItem(1)), 1),
            Arguments.of(List.of(randItem(4), randItem(20), randItem(8), randItem(9), randItem(3), randItem(19)), 3),
            Arguments.of(List.of(randItem(1), randItem(9), randItem(15), randItem(12), randItem(8)), 1),
            Arguments.of(List.of(randItem(2), randItem(16)), 2),
            Arguments.of(List.of(randItem(7), randItem(7), randItem(3)), 3),
            Arguments.of(List.of(randItem(10), randItem(12), randItem(18), randItem(11)), 10),
            Arguments.of(List.of(randItem(1), randItem(9), randItem(12), randItem(14), randItem(15), randItem(18), randItem(8)), 1),
            Arguments.of(List.of(randItem(17)), 17),
            Arguments.of(List.of(randItem(16), randItem(8), randItem(8), randItem(9), randItem(20)), 8),
            Arguments.of(List.of(randItem(11), randItem(12), randItem(13), randItem(18), randItem(9), randItem(14), randItem(14), randItem(18)), 9),
            Arguments.of(List.of(randItem(17), randItem(20), randItem(2), randItem(20), randItem(14)), 2),
            Arguments.of(List.of(randItem(4), randItem(6), randItem(4), randItem(13), randItem(16), randItem(10)), 4),
            Arguments.of(List.of(randItem(13), randItem(2), randItem(4), randItem(4), randItem(13), randItem(7)), 2),
            Arguments.of(List.of(randItem(14), randItem(12), randItem(17), randItem(1)), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideAverageArguments")
    @DisplayName("Find Average")
    void testAveragePrice(List<ValuableItem> items, double expected) throws InvocationTargetException, IllegalAccessException {
        Double result = (Double) averageMethod.invoke(null, items);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideAverageArguments() {
        return Stream.of(
            Arguments.of(List.of(randItem(1)), 1.0),
            Arguments.of(List.of(randItem(6), randItem(4)), 5.0),
            Arguments.of(List.of(randItem(15), randItem(10), randItem(14), randItem(1)), 10.0),
            Arguments.of(List.of(randItem(9), randItem(8), randItem(4), randItem(5)), 6.5),
            Arguments.of(List.of(randItem(3), randItem(16)), 9.5),
            Arguments.of(List.of(randItem(15), randItem(17), randItem(10), randItem(20), randItem(3), randItem(20), randItem(16)), 14.428571428571429),
            Arguments.of(List.of(randItem(14)), 14.0),
            Arguments.of(List.of(randItem(5), randItem(6), randItem(1), randItem(14), randItem(4), randItem(14), randItem(18)), 8.857142857142858),
            Arguments.of(List.of(randItem(1), randItem(14), randItem(6), randItem(15), randItem(4)), 8.0),
            Arguments.of(List.of(randItem(2), randItem(10), randItem(12), randItem(1), randItem(17), randItem(6)), 8.0),
            Arguments.of(List.of(randItem(17), randItem(16), randItem(1), randItem(1)), 8.75),
            Arguments.of(List.of(randItem(5), randItem(8), randItem(13), randItem(10)), 9.0),
            Arguments.of(List.of(randItem(13), randItem(7)), 10.0),
            Arguments.of(List.of(randItem(7), randItem(15), randItem(3), randItem(17), randItem(4), randItem(18), randItem(1), randItem(19)), 10.5),
            Arguments.of(List.of(randItem(19), randItem(19), randItem(16), randItem(10)), 16.0),
            Arguments.of(List.of(randItem(19), randItem(20), randItem(18), randItem(2), randItem(14), randItem(2)), 12.5),
            Arguments.of(List.of(randItem(15), randItem(10), randItem(7), randItem(18), randItem(18), randItem(12), randItem(17), randItem(13)), 13.75),
            Arguments.of(List.of(randItem(18), randItem(20), randItem(10), randItem(3), randItem(3), randItem(6), randItem(10), randItem(16)), 10.75),
            Arguments.of(List.of(randItem(17), randItem(3), randItem(13), randItem(20), randItem(14), randItem(9), randItem(2), randItem(7)), 10.625),
            Arguments.of(List.of(randItem(18), randItem(13)), 15.5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMedianArguments")
    @DisplayName("Find Median")
    void testMedian(List<Integer> list, double expected) throws InvocationTargetException, IllegalAccessException {
        Double result = (Double) medianMethod.invoke(null, list);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideMedianArguments() {
        return Stream.of(
            Arguments.of(List.of(1), 1),
            Arguments.of(List.of(9, -11, 8, -8, -20, -3), -5.5),
            Arguments.of(List.of(15, -15, -3, 19, 0, 5, -7, 11, 6, -10, -5, -5), -1.5),
            Arguments.of(List.of(1, -11, -15, -1, -5, 4, 2, -18, 8, -20), -3.0),
            Arguments.of(List.of(-18, -16, 11, 12, 18, -15), -2.0),
            Arguments.of(List.of(18, 0, 12, -8, 6, -5, -3, 2, 3, -10, 9), 2.0),
            Arguments.of(List.of(-12, 10, 18, 18, -4, 19, -19, 20, 6, -4, -5, 16, 12, 13, -2, 11, 18, 6, 10, 3), 10.0),
            Arguments.of(List.of(-2, -2, 4, 15, -11, -17, -11, -2, -16, 12, -18, -17, 5, 15, 3, -14), -2.0),
            Arguments.of(List.of(11, 4, -10, 14, -17, 2, 10, -11, -16, 5, -9, -2, 19, -16, -20, -8, -5, 17, 5, -5), -3.5),
            Arguments.of(List.of(-17, -16, -9, 18, 1, 14, 15, -8, -12, -5, -4, 10, 14, 17, 12, -2, 15, -11), -0.5),
            Arguments.of(List.of(15), 15.0),
            Arguments.of(List.of(-11, -6, 16, -6), -6.0),
            Arguments.of(List.of(-12, 6, -10, -13, 12, 19, -6, 2, -19, -16, 9, 19, 12, 12, -15, -15, 9, -3, -5, 15), -0.5),
            Arguments.of(List.of(10, 0), 5.0),
            Arguments.of(List.of(-14, -12, -12, -16, -8, -20), -13.0),
            Arguments.of(List.of(3, -9, -16, -12, -6, 0, 12, -11, 12, -12, -14, 19, -8, 19, 2, -18, -9, -15), -8.5),
            Arguments.of(List.of(13, -3, 16, 16, -15, -19, 20, -13, -2, -6, 11, 17, -17, -17, -14), -3.0),
            Arguments.of(List.of(-16, -3, -18, -16, -8, -8, 9, 7, 8, -8, 4), -8.0),
            Arguments.of(List.of(-5), -5.0),
            Arguments.of(List.of(-7, 10, 19, 9, -15, 17, 20, 1, 6, 6, -9, 20, -6, -20, -18, -3, -9, -9, 15, -16), -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCombineArguments")
    @DisplayName("Collect to List")
    void testCombine(Map<String, Integer> prices, Map<String, String> categories, List<ValuableItem> expected) throws InvocationTargetException, IllegalAccessException {
        List<?> result = (List<?>) combineMethod.invoke(null, prices, categories);
        Assertions.assertTrue(result.stream().allMatch(item -> expected.stream().anyMatch(item::equals)));
    }

    static Stream<Arguments> provideCombineArguments() {
        String item1 = "Item1", item2 = "Item2", item3 = "Item3";
        String type1 = "Category1", type2 = "Category2", type3 = "Category3";

        return Stream.of(
            Arguments.of(Map.of(), Map.of(), List.of()),
            Arguments.of(Map.of(item1, 1), Map.of(), List.of(new ValuableItem(item1, 1, ""))),
            Arguments.of(Map.of(), Map.of(item1, type1), List.of(new ValuableItem(item1, 0, type1))),
            Arguments.of(Map.of(item1, 1), Map.of(item1, type1), List.of(new ValuableItem(item1, 1, type1))),
            Arguments.of(Map.of(item1, 1, item2, 5), Map.of(), List.of(new ValuableItem(item1, 1, ""), new ValuableItem(item2, 5, ""))),
            Arguments.of(Map.of(item1, 1, item2, 5), Map.of(item1, type1), List.of(new ValuableItem(item1, 1, type1), new ValuableItem(item2, 5, ""))),
            Arguments.of(Map.of(item1, 1), Map.of(item1, type1, item2, type2), List.of(new ValuableItem(item1, 1, type1), new ValuableItem(item2, 0, type2))),
            Arguments.of(Map.of(item1, 1, item2, 5), Map.of(item1, type1, item2, type1), List.of(new ValuableItem(item1, 1, type1), new ValuableItem(item2, 5, type1))),
            Arguments.of(Map.of(item1, 1, item2, 5), Map.of(item1, type1, item2, type2, item3, type3), List.of(new ValuableItem(item1, 1, type1), new ValuableItem(item2, 5, type2), new ValuableItem(item3, 0, type3))),
            Arguments.of(Map.of(item1, 1, item2, 5, item3, 12), Map.of(item1, type3, item2, type1), List.of(new ValuableItem(item1, 1, type3), new ValuableItem(item2, 5, type1), new ValuableItem(item3, 12, "")))
        );
    }

    @ParameterizedTest
    @MethodSource("provideMostFreqArguments")
    @DisplayName("Find Most Frequent Element")
    void testMostFrequent(List<String> list, String expected) throws InvocationTargetException, IllegalAccessException {
        String result = (String) mostFreqMethod.invoke(null, list);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideMostFreqArguments() {
        return Stream.of(
            Arguments.of(List.of(""), ""),
            Arguments.of(List.of("GLVtJge", "vBAZnhbL", "eAL", "RamV", "RamV"), "RamV"),
            Arguments.of(List.of("GLVtJge", "eAL", "C", "eAL", "C", "eAL"), "eAL"),
            Arguments.of(List.of("C", "eAL", "C"), "C"),
            Arguments.of(List.of("eAL", "GLVtJge", "RamV", "RamV", "C"), "RamV"),
            Arguments.of(List.of("C", "C", "C", "RamV", "RamV", "eAL"), "C"),
            Arguments.of(List.of("vBAZnhbL", "vBAZnhbL", "eAL", "eAL", "vBAZnhbL"), "vBAZnhbL"),
            Arguments.of(List.of("GLVtJge", "GLVtJge", "RamV", "eAL", "RamV", "vBAZnhbL", "GLVtJge"), "GLVtJge"),
            Arguments.of(List.of("RamV", "vBAZnhbL", "RamV", "C"), "RamV"),
            Arguments.of(List.of("GLVtJge", "C", "GLVtJge", "vBAZnhbL", "vBAZnhbL", "eAL", "vBAZnhbL"), "vBAZnhbL"),
            Arguments.of(List.of("C", "vBAZnhbL", "vBAZnhbL", "RamV"), "vBAZnhbL"),
            Arguments.of(List.of("eAL", "vBAZnhbL", "GLVtJge", "RamV", "RamV", "eAL", "RamV", "GLVtJge", "RamV", "C"), "RamV"),
            Arguments.of(List.of("GLVtJge", "vBAZnhbL", "RamV", "C", "C", "eAL", "RamV", "C"), "C"),
            Arguments.of(List.of("RamV", "C", "RamV", "GLVtJge", "C", "vBAZnhbL", "C", "eAL"), "C"),
            Arguments.of(List.of("GLVtJge", "GLVtJge", "vBAZnhbL", "C"), "GLVtJge"),
            Arguments.of(List.of("RamV"), "RamV"),
            Arguments.of(List.of("C", "GLVtJge", "RamV", "vBAZnhbL", "RamV"), "RamV"),
            Arguments.of(List.of("RamV", "eAL", "GLVtJge", "RamV"), "RamV"),
            Arguments.of(List.of("vBAZnhbL", "eAL", "GLVtJge", "C", "vBAZnhbL", "GLVtJge", "C", "eAL", "GLVtJge"), "GLVtJge"),
            Arguments.of(List.of("RamV", "vBAZnhbL", "RamV", "vBAZnhbL", "eAL", "RamV", "eAL"), "RamV")
        );
    }

    @ParameterizedTest
    @MethodSource("providePartitionArguments")
    @DisplayName("Partition by Threshold")
    void testPartition(List<ValuableItem> items, int threshold, Map<String, List<ValuableItem>> expected) throws InvocationTargetException, IllegalAccessException {
        Map<?, ?> result = (Map<?, ?>) partitionMethod.invoke(null, items, threshold);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> providePartitionArguments() {
        ValuableItem item1 = randItem("Item1", 1);
        ValuableItem item2 = randItem("Item2", 2);
        ValuableItem item3 = randItem("Item3", 5);
        ValuableItem item4 = randItem("Item4", 8);
        ValuableItem item5 = randItem("Item5", 10);
        ValuableItem item6 = randItem("Item6", 12);
        ValuableItem item7 = randItem("Item7", 15);
        ValuableItem item8 = randItem("Item8", 20);

        return Stream.of(
            Arguments.of(List.of(item1, item6), 1, Map.of("BelowOrEqual", List.of(item1), "Above", List.of(item6))),
            Arguments.of(List.of(item8, item1, item4, item7, item2, item4), 9, Map.of("BelowOrEqual", List.of(item1, item4, item2, item4), "Above", List.of(item8, item7))),
            Arguments.of(List.of(item2), 2, Map.of("BelowOrEqual", List.of(item2), "Above", List.of())),
            Arguments.of(List.of(item4, item4, item7, item7, item3), 4, Map.of("BelowOrEqual", List.of(), "Above", List.of(item4, item4, item7, item7, item3))),
            Arguments.of(List.of(item4, item3, item1, item8, item7, item5, item4), 17, Map.of("BelowOrEqual", List.of(item4, item3, item1, item7, item5, item4), "Above", List.of(item8))),
            Arguments.of(List.of(item1, item8), 16, Map.of("BelowOrEqual", List.of(item1), "Above", List.of(item8))),
            Arguments.of(List.of(item3, item3), 10, Map.of("BelowOrEqual", List.of(item3, item3), "Above", List.of())),
            Arguments.of(List.of(item6, item2, item6), 17, Map.of("BelowOrEqual", List.of(item6, item2, item6), "Above", List.of())),
            Arguments.of(List.of(item8, item3, item8), 11, Map.of("BelowOrEqual", List.of(item3), "Above", List.of(item8, item8))),
            Arguments.of(List.of(item1, item4, item6, item5), 20, Map.of("BelowOrEqual", List.of(item1, item4, item6, item5), "Above", List.of())),
            Arguments.of(List.of(item7, item6, item3), 1, Map.of("BelowOrEqual", List.of(), "Above", List.of(item7, item6, item3))),
            Arguments.of(List.of(item6, item7, item5), 20, Map.of("BelowOrEqual", List.of(item6, item7, item5), "Above", List.of())),
            Arguments.of(List.of(item8, item4, item8, item1, item6), 7, Map.of("BelowOrEqual", List.of(item1), "Above", List.of(item8, item4, item8, item6))),
            Arguments.of(List.of(item3, item6, item7, item8, item7), 3, Map.of("BelowOrEqual", List.of(), "Above", List.of(item3, item6, item7, item8, item7))),
            Arguments.of(List.of(item3, item2), 6, Map.of("BelowOrEqual", List.of(item3, item2), "Above", List.of())),
            Arguments.of(List.of(item5), 10, Map.of("BelowOrEqual", List.of(item5), "Above", List.of())),
            Arguments.of(List.of(item1, item5, item7, item5, item1, item7, item7, item5), 6, Map.of("BelowOrEqual", List.of(item1, item1), "Above", List.of(item5, item7, item5, item7, item7, item5))),
            Arguments.of(List.of(item6, item3, item3, item3), 1, Map.of("BelowOrEqual", List.of(), "Above", List.of(item6, item3, item3, item3))),
            Arguments.of(List.of(item5, item8, item3, item1, item3, item5, item2, item4), 15, Map.of("BelowOrEqual", List.of(item5, item3, item1, item3, item5, item2, item4), "Above", List.of(item8))),
            Arguments.of(List.of(item5, item1, item3, item1, item1), 20, Map.of("BelowOrEqual", List.of(item5, item1, item3, item1, item1), "Above", List.of()))
        );
    }

    @ParameterizedTest
    @MethodSource("provideCountRangeArguments")
    @DisplayName("Count Items by Price Range")
    void testCountRanges(List<ValuableItem> items, Map<String, List<ValuableItem>> expected) throws InvocationTargetException, IllegalAccessException {
        Map<?, List<?>> result = (Map<?, List<?>>) countRangeMethod.invoke(null, items);
        Assertions.assertTrue(result.values().stream().allMatch(list1 -> expected.values().stream().anyMatch(list2 -> Set.copyOf(list1).equals(Set.copyOf(list2)))));
    }

    static Stream<Arguments> provideCountRangeArguments() {
        ValuableItem item1 = randItem("Item1", 0);
        ValuableItem item2 = randItem("Item2", 50);
        ValuableItem item3 = randItem("Item3", 80);
        ValuableItem item4 = randItem("Item4", 100);
        ValuableItem item5 = randItem("Item5", 150);
        ValuableItem item6 = randItem("Item6", 200);
        ValuableItem item7 = randItem("Item7", 300);
        ValuableItem item8 = randItem("Item8", 400);

        return Stream.of(
            Arguments.of(List.of(), Map.of()),
            Arguments.of(List.of(item1, item7, item6), Map.of("0-100", List.of(item1), "101-200", List.of(item6), "201-300", List.of(item7))),
            Arguments.of(List.of(item2, item6, item8), Map.of("0-100", List.of(item2), "101-200", List.of(item6), "301-400", List.of(item8))),
            Arguments.of(List.of(item4, item6, item8, item2, item4, item5, item5), Map.of("0-100", List.of(item2, item4, item4), "101-200", List.of(item5, item5, item6), "301-400", List.of(item8))),
            Arguments.of(List.of(item3, item4, item2, item2, item4), Map.of("0-100", List.of(item2, item2, item3, item4, item4))),
            Arguments.of(List.of(item7, item1, item4, item6), Map.of("0-100", List.of(item1, item4), "101-200", List.of(item6), "201-300", List.of(item7))),
            Arguments.of(List.of(item5, item4, item4, item5, item2, item5, item7), Map.of("0-100", List.of(item2, item4, item4), "101-200", List.of(item5, item5, item5), "201-300", List.of(item7))),
            Arguments.of(List.of(item3, item1, item5, item5, item4, item2, item3, item2), Map.of("0-100", List.of(item1, item2, item2, item3, item3, item4), "101-200", List.of(item5))),
            Arguments.of(List.of(item5, item7, item8, item7), Map.of("101-200", List.of(item5), "201-300", List.of(item7, item7), "301-400", List.of(item8))),
            Arguments.of(List.of(item3, item1, item8, item8, item8, item2), Map.of("0-100", List.of(item1, item2, item3), "301-400", List.of(item8, item8, item8)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideWeightedAvgArguments")
    @DisplayName("Compute Weighted Average Price")
    void testWeightedAverage(List<ValuableItem> items, Map<String, Double> weights, double expected) throws InvocationTargetException, IllegalAccessException {
        Double result = (Double) weightedAvgMethod.invoke(null, items, weights);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideWeightedAvgArguments() {
        return Stream.of(
            Arguments.of(List.of(randItem("Item1", 1)), Map.of("Item1", 1.0), 1.0),
            Arguments.of(List.of(randItem("Item1", 9)), Map.of("Item1", 1.5), 9.0),
            Arguments.of(List.of(randItem("Item1", 11)), Map.of("Item1", 1.5), 11.0),
            Arguments.of(List.of(randItem("Item1", 18), randItem("Item2", 17), randItem("Item3", 20), randItem("Item4", 3)), Map.of("Item1", 1.5, "Item2", 2.0, "Item3", 1.5, "Item4", 2.0), 13.857142857142858),
            Arguments.of(List.of(randItem("Item1", 12), randItem("Item2", 5), randItem("Item3", 2), randItem("Item4", 20), randItem("Item5", 6)), Map.of("Item1", 1.5, "Item2", 1.5, "Item3", 1.5, "Item4", 1.0, "Item5", 2.0), 8.066666666666666),
            Arguments.of(List.of(randItem("Item1", 7), randItem("Item2", 20), randItem("Item3", 5), randItem("Item4", 10), randItem("Item5", 12)), Map.of("Item1", 1.5, "Item2", 1.0, "Item3", 1.0, "Item4", 0.5, "Item5", 1.5), 10.636363636363637),
            Arguments.of(List.of(randItem("Item1", 2), randItem("Item2", 16)), Map.of("Item1", 0.5, "Item2", 2.0), 13.2),
            Arguments.of(List.of(randItem("Item1", 12), randItem("Item2", 1), randItem("Item3", 17), randItem("Item4", 19), randItem("Item5", 20)), Map.of("Item1", 0.5, "Item2", 0.5, "Item3", 2.0, "Item4", 1.5, "Item5", 1.5), 16.5),
            Arguments.of(List.of(randItem("Item1", 19), randItem("Item2", 9), randItem("Item3", 20), randItem("Item4", 8)), Map.of("Item1", 1.0, "Item2", 1.0, "Item3", 1.5, "Item4", 1.5), 14.0),
            Arguments.of(List.of(randItem("Item1", 15), randItem("Item2", 5)), Map.of("Item1", 1.0, "Item2", 0.5), 11.666666666666666),
            Arguments.of(List.of(randItem("Item1", 4)), Map.of("Item1", 1.5), 4.0),
            Arguments.of(List.of(randItem("Item1", 20)), Map.of("Item1", 1.5), 20.0),
            Arguments.of(List.of(randItem("Item1", 6)), Map.of("Item1", 1.0), 6.0),
            Arguments.of(List.of(randItem("Item1", 2), randItem("Item2", 10), randItem("Item3", 12), randItem("Item4", 10)), Map.of("Item1", 0.5, "Item2", 0.5, "Item3", 1.5, "Item4", 0.5), 9.666666666666666),
            Arguments.of(List.of(randItem("Item1", 3)), Map.of("Item1", 0.5), 3.0),
            Arguments.of(List.of(randItem("Item1", 8), randItem("Item2", 10)), Map.of("Item1", 1.5, "Item2", 0.5), 8.5),
            Arguments.of(List.of(randItem("Item1", 18), randItem("Item2", 11), randItem("Item3", 1)), Map.of("Item1", 1.5, "Item2", 1.0, "Item3", 1.0), 11.142857142857142),
            Arguments.of(List.of(randItem("Item1", 4), randItem("Item2", 5), randItem("Item3", 8), randItem("Item4", 20), randItem("Item5", 19)), Map.of("Item1", 0.5, "Item2", 1.0, "Item3", 0.5, "Item4", 2.0, "Item5", 1.5), 14.454545454545455),
            Arguments.of(List.of(randItem("Item1", 2), randItem("Item2", 20), randItem("Item3", 12), randItem("Item4", 6), randItem("Item5", 16)), Map.of("Item1", 0.5, "Item2", 1.0, "Item3", 1.0, "Item4", 0.5, "Item5", 0.5), 12.571428571428571),
            Arguments.of(List.of(randItem("Item1", 15), randItem("Item2", 8), randItem("Item3", 9), randItem("Item4", 11), randItem("Item5", 20)), Map.of("Item1", 0.5, "Item2", 1.5, "Item3", 1.5, "Item4", 0.5, "Item5", 1.5), 12.454545454545455)
        );
    }

    @ParameterizedTest
    @MethodSource("provideKthLargestArguments")
    @DisplayName("K-th Largest Element in Stream")
    void testKthLargestElement(List<Integer> list, int k, int expected) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Object kthLargest = kthLargestConstructor.newInstance(k);

        for (int value : list) {
            kthAddMethod.invoke(kthLargest, value);
        }
        int result = (int) kthLargestMethod.invoke(kthLargest);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideKthLargestArguments() {
        return Stream.of(
            Arguments.of(List.of(1), 1, 1),
            Arguments.of(List.of(5, 6, 1, 9), 2, 6),
            Arguments.of(List.of(1, 20, 9, 17), 2, 17),
            Arguments.of(List.of(1, 17, 13, 1, 7, 9, 13, 6), 8, 1),
            Arguments.of(List.of(20, 20, 19, 4, 11, 16, 8, 1, 16, 7, 10), 4, 16),
            Arguments.of(List.of(9, 20, 16, 7), 4, 7),
            Arguments.of(List.of(9, 15, 19, 16, 8, 20, 5, 18, 17, 13, 7, 2, 1, 14, 6, 16, 15), 14, 6),
            Arguments.of(List.of(12, 17, 19, 3, 10, 14, 7, 16, 6), 6, 10),
            Arguments.of(List.of(10, 13, 15, 7, 19, 17, 11, 9, 10, 5, 14, 17, 2, 20, 1, 13, 9, 13, 14), 12, 10),
            Arguments.of(List.of(5, 3, 11, 19, 7, 19, 9, 5), 5, 7),
            Arguments.of(List.of(15, 17), 2, 15),
            Arguments.of(List.of(19, 18, 5, 8, 19, 15, 4, 5, 7, 9, 12, 8, 15, 12, 13), 3, 18),
            Arguments.of(List.of(3, 10, 4, 12, 1, 10, 3), 7, 1),
            Arguments.of(List.of(6, 10, 13, 5, 4, 11, 7, 20, 5, 1, 6, 3, 15), 13, 1),
            Arguments.of(List.of(18, 15, 18, 3, 3, 9, 13, 1, 17, 16, 1, 10, 2, 16, 18, 11, 7), 16, 1),
            Arguments.of(List.of(4, 1, 4, 4, 5, 2, 11, 17, 20, 3, 17), 7, 4),
            Arguments.of(List.of(17, 7, 7, 18, 8, 8, 20), 3, 17),
            Arguments.of(List.of(14, 6, 19, 2, 15, 18, 11, 12, 1, 9), 2, 18),
            Arguments.of(List.of(2, 15, 3, 4, 18, 11, 15, 13, 12, 13, 13, 11, 3, 11, 10, 9, 14, 16, 6, 17), 20, 2),
            Arguments.of(List.of(6, 6, 6, 3, 13, 14, 13, 20, 5, 16, 16, 6, 12, 2, 17, 13, 17, 20), 18, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideFirstLetterArguments")
    @DisplayName("Group by First Letter and Sort")
    void testGroupFirstLetter(List<ValuableItem> items, Map<Character, List<ValuableItem>> expected) throws InvocationTargetException, IllegalAccessException {
        Map<?, ?> result = (Map<?, ?>) firstLetterMethod.invoke(null, items);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideFirstLetterArguments() {
        ValuableItem item1 = randItem("A_Item1", 1);
        ValuableItem item2 = randItem("A_Item2", 5);
        ValuableItem item3 = randItem("A_Item3", 12);
        ValuableItem item4 = randItem("B_Item4", 5);
        ValuableItem item5 = randItem("B_Item5", 8);
        ValuableItem item6 = randItem("C_Item6", 1);
        ValuableItem item7 = randItem("C_Item7", 10);
        ValuableItem item8 = randItem("D_Item8", 2);

        return Stream.of(
            Arguments.of(List.of(), Map.of()),
            Arguments.of(List.of(item8, item2, item7, item6, item7, item7, item8), Map.of('D', List.of(item8, item8), 'A', List.of(item2), 'C', List.of(item6, item7, item7, item7))),
            Arguments.of(List.of(item2, item1, item8, item8, item1), Map.of('A', List.of(item1, item1, item2), 'D', List.of(item8, item8))),
            Arguments.of(List.of(item4, item4, item1, item3, item3), Map.of('B', List.of(item4, item4), 'A', List.of(item1, item3, item3))),
            Arguments.of(List.of(item1, item1, item2, item8, item1, item2), Map.of('A', List.of(item1, item1, item1, item2, item2), 'D', List.of(item8))),
            Arguments.of(List.of(item5, item7, item1, item5, item8, item4, item4), Map.of('B', List.of(item4, item4, item5, item5), 'C', List.of(item7), 'A', List.of(item1), 'D', List.of(item8))),
            Arguments.of(List.of(item4, item7, item2, item7), Map.of('B', List.of(item4), 'C', List.of(item7, item7), 'A', List.of(item2))),
            Arguments.of(List.of(item4, item4), Map.of('B', List.of(item4, item4))),
            Arguments.of(List.of(item2, item6, item5, item6), Map.of('A', List.of(item2), 'C', List.of(item6, item6), 'B', List.of(item5))),
            Arguments.of(List.of(item8, item3, item7), Map.of('D', List.of(item8), 'A', List.of(item3), 'C', List.of(item7))),
            Arguments.of(List.of(item5, item7, item4, item4, item1, item4, item5, item8), Map.of('B', List.of(item4, item4, item4, item5, item5), 'C', List.of(item7), 'A', List.of(item1), 'D', List.of(item8))),
            Arguments.of(List.of(item4, item7, item1), Map.of('B', List.of(item4), 'C', List.of(item7), 'A', List.of(item1))),
            Arguments.of(List.of(item2, item6, item4, item1, item6, item5), Map.of('A', List.of(item1, item2), 'C', List.of(item6, item6), 'B', List.of(item4, item5))),
            Arguments.of(List.of(item1, item8, item2, item2, item1), Map.of('A', List.of(item1, item1, item2, item2), 'D', List.of(item8))),
            Arguments.of(List.of(item6, item6, item1, item5, item2, item6, item6), Map.of('C', List.of(item6, item6, item6, item6), 'A', List.of(item1, item2), 'B', List.of(item5))),
            Arguments.of(List.of(item2, item1, item2, item8, item6, item7), Map.of('A', List.of(item1, item2, item2), 'D', List.of(item8), 'C', List.of(item6, item7))),
            Arguments.of(List.of(item1, item7, item2), Map.of('A', List.of(item1, item2), 'C', List.of(item7))),
            Arguments.of(List.of(item4, item6, item2, item2), Map.of('B', List.of(item4), 'C', List.of(item6), 'A', List.of(item2, item2))),
            Arguments.of(List.of(item7, item4), Map.of('C', List.of(item7), 'B', List.of(item4))),
            Arguments.of(List.of(item6, item1, item7, item2, item1, item2, item2, item6), Map.of('C', List.of(item6, item6, item7), 'A', List.of(item1, item1, item2, item2, item2)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideClosestPointsArguments")
    @DisplayName("Find the Closest Pair of Points")
    void testFindClosestPairs(List<Point> points, Pair<Point, Point> expected) throws InvocationTargetException, IllegalAccessException {
        Pair<?, ?> result = (Pair<?, ?>) closestPointsMethod.invoke(null, points);
        Assertions.assertTrue(
            (result.first() == expected.first() && result.second() == expected.second()) ||
                (result.first() == expected.second() && result.second() == expected.first())
        );
    }

    static Stream<Arguments> provideClosestPointsArguments() {
        Point point1 = new Point(6, 7), point2 = new Point(-4, 0), point3 = new Point(1, 0), point4 = new Point(6, 10),
            point5 = new Point(0, -2), point6 = new Point(-9, -8), point7 = new Point(-5, 8), point8 = new Point(2, -5);

        return Stream.of(
            Arguments.of(List.of(point1, point2), new Pair<>(point1, point2)),
            Arguments.of(List.of(point6, point2, point8, point3), new Pair<>(point2, point3)),
            Arguments.of(List.of(point8, point2, point3, point1, point7, point6, point5, point4), new Pair<>(point3, point5)),
            Arguments.of(List.of(point3, point5, point8, point2, point6, point7, point4), new Pair<>(point3, point5)),
            Arguments.of(List.of(point8, point1, point4, point2), new Pair<>(point1, point4)),
            Arguments.of(List.of(point7, point4, point2, point3, point5, point6, point8, point1), new Pair<>(point3, point5)),
            Arguments.of(List.of(point2, point4, point5, point7, point6, point3, point8), new Pair<>(point3, point5)),
            Arguments.of(List.of(point6, point5, point2), new Pair<>(point2, point5)),
            Arguments.of(List.of(point7, point5, point6, point4), new Pair<>(point5, point6)),
            Arguments.of(List.of(point2, point3, point1, point7, point5), new Pair<>(point3, point5)),
            Arguments.of(List.of(point7, point3, point8, point4, point2, point6, point1), new Pair<>(point1, point4)),
            Arguments.of(List.of(point7, point5, point4, point1, point6, point2), new Pair<>(point1, point4)),
            Arguments.of(List.of(point8, point1), new Pair<>(point1, point8)),
            Arguments.of(List.of(point1, point7, point5, point4, point8, point2), new Pair<>(point1, point4)),
            Arguments.of(List.of(point7, point3, point5, point4, point8, point1, point2, point6), new Pair<>(point3, point5)),
            Arguments.of(List.of(point6, point4, point2, point3), new Pair<>(point2, point3)),
            Arguments.of(List.of(point5, point6, point7), new Pair<>(point5, point6)),
            Arguments.of(List.of(point2, point6, point4, point8), new Pair<>(point2, point8)),
            Arguments.of(List.of(point1, point7), new Pair<>(point1, point7)),
            Arguments.of(List.of(point5, point7, point4, point1, point2), new Pair<>(point1, point4))
        );
    }

    @ParameterizedTest
    @MethodSource("provideMergeIntervalsArguments")
    @DisplayName("Merge Intervals")
    void testMergeIntervals(List<Interval> intervals, List<Interval> expected) throws InvocationTargetException, IllegalAccessException {
        List<?> result = (List<?>) mergeIntervalMethod.invoke(null, intervals);
        Assertions.assertEquals(result, expected);
    }

    static Stream<Arguments> provideMergeIntervalsArguments() {
        Interval int1 = new Interval(-10, -8), int2 = new Interval(-7, -4), int3 = new Interval(-5, -1), int4 = new Interval(0, 3),
            int5 = new Interval(2, 5), int6 = new Interval(4, 5), int7 = new Interval(8, 10), int8 = new Interval(7, 12);

        return Stream.of(
            Arguments.of(List.of(), List.of()),
            Arguments.of(List.of(int8, int1, int6, int7, int5, int4, int2), List.of(new Interval(-10, -8), new Interval(-7, -4), new Interval(0, 5), new Interval(7, 12))),
            Arguments.of(List.of(int2, int3, int1), List.of(new Interval(-10, -8), new Interval(-7, -1))),
            Arguments.of(List.of(int6, int4, int8, int5, int3, int2), List.of(new Interval(-7, -1), new Interval(0, 5), new Interval(7, 12))),
            Arguments.of(List.of(int8, int5, int4, int6, int1), List.of(new Interval(-10, -8), new Interval(0, 5), new Interval(7, 12))),
            Arguments.of(List.of(int2, int3, int6, int8), List.of(new Interval(-7, -1), new Interval(4, 5), new Interval(7, 12))),
            Arguments.of(List.of(int1, int6, int3, int7, int8, int4, int2, int5), List.of(new Interval(-10, -8), new Interval(-7, -1), new Interval(0, 5), new Interval(7, 12))),
            Arguments.of(List.of(int7, int4, int6, int1, int3, int5, int2), List.of(new Interval(-10, -8), new Interval(-7, -1), new Interval(0, 5), new Interval(8, 10))),
            Arguments.of(List.of(int2, int6), List.of(new Interval(-7, -4), new Interval(4, 5))),
            Arguments.of(List.of(int3, int1, int8, int7, int4), List.of(new Interval(-10, -8), new Interval(-5, -1), new Interval(0, 3), new Interval(7, 12))),
            Arguments.of(List.of(int3, int5, int6, int1, int4, int7), List.of(new Interval(-10, -8), new Interval(-5, -1), new Interval(0, 5), new Interval(8, 10))),
            Arguments.of(List.of(int3), List.of(new Interval(-5, -1))),
            Arguments.of(List.of(int5, int7, int2, int6, int1), List.of(new Interval(-10, -8), new Interval(-7, -4), new Interval(2, 5), new Interval(8, 10))),
            Arguments.of(List.of(int7, int6, int1, int3, int2, int5, int8), List.of(new Interval(-10, -8), new Interval(-7, -1), new Interval(2, 5), new Interval(7, 12))),
            Arguments.of(List.of(int5, int4, int6, int1, int2), List.of(new Interval(-10, -8), new Interval(-7, -4), new Interval(0, 5))),
            Arguments.of(List.of(int7, int6, int5), List.of(new Interval(2, 5), new Interval(8, 10))),
            Arguments.of(List.of(int7, int1, int2, int6, int5, int8), List.of(new Interval(-10, -8), new Interval(-7, -4), new Interval(2, 5), new Interval(7, 12))),
            Arguments.of(List.of(int2, int5, int3, int4, int7, int6), List.of(new Interval(-7, -1), new Interval(0, 5), new Interval(8, 10))),
            Arguments.of(List.of(int8, int3, int2, int6, int1, int5, int7), List.of(new Interval(-10, -8), new Interval(-7, -1), new Interval(2, 5), new Interval(7, 12))),
            Arguments.of(List.of(int1, int4, int3, int7), List.of(new Interval(-10, -8), new Interval(-5, -1), new Interval(0, 3), new Interval(8, 10)))
        );
    }

    private static Constructor<?> getKthLargestConstructor() {
        if (kthElementMethod == null) {
            return null;
        }
        try {
            return kthElementMethod.getDeclaringClass().getConstructor(int.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static Method getKthAddMethod() {
        if (kthElementMethod == null) {
            return null;
        }
        for (Method method : kthElementMethod.getDeclaringClass().getDeclaredMethods()) {
            if (method.getReturnType() == void.class && method.getParameterTypes().length == 1 && method.getParameterTypes()[0] == int.class) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    private static Method getKthLargestMethod() {
        if (kthElementMethod == null) {
            return null;
        }
        for (Method method : kthElementMethod.getDeclaringClass().getDeclaredMethods()) {
            if (method.getReturnType() == int.class && method.getParameterTypes().length == 0) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    private static ValuableItem randItem(int price) {
        return randItem("", price);
    }

    private static ValuableItem randItem(String name, int price) {
        return new ValuableItem(name, price, "");
    }
}
