package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindIntersectionTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<String, String[]> testValue) {
        assertEquals(testValue.getKey(), FindIntersection.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<String, String[]>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>("1, 4, 13", new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}),
                new SimpleEntry<>("1, 9, 10", new String[] {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}),
                new SimpleEntry<>("5, 7", new String[] {"1, 2, 4, 5, 7, 10", "3, 5, 7, 9, 11"}),
                new SimpleEntry<>("1, 2, 3, 4, 5",
                        new String[] {"1, 2, 3, 4, 5, 6, 7, 8, 9, 10", "1, 2, 3, 4, 5, 11, 15, 17, 19"}),
                new SimpleEntry<>("6", new String[] {"1, 3, 5, 6, 7, 9", "2, 4, 6, 8, 10"}),
                new SimpleEntry<>("false", new String[] {"1, 3, 5, 7, 9", "2, 4, 6, 8, 10"})
        );
    }
}