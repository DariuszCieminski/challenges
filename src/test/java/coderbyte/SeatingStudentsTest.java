package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatingStudentsTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<Integer, int[]> testValue) {
        assertEquals(testValue.getKey(), SeatingStudents.solution(testValue.getValue()));
    }

    //provides map entries containing expected value and input array
    private static Stream<Map.Entry<Integer, int[]>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>(4, new int[] {6, 4}),
                new SimpleEntry<>(6, new int[] {8, 1, 8}),
                new SimpleEntry<>(6, new int[] {12, 2, 6, 7, 11}),
                new SimpleEntry<>(3, new int[] {10, 3, 4, 7, 8}),
                new SimpleEntry<>(9, new int[] {20, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19}),
                new SimpleEntry<>(0, new int[] {8, 1, 2, 3, 4, 5, 6, 7, 8}),
                new SimpleEntry<>(7, new int[] {6}),
                new SimpleEntry<>(13, new int[] {24, 4, 7, 12, 15, 16, 18, 19, 24}),
                new SimpleEntry<>(11, new int[] {22, 1, 2, 4, 6, 7, 8, 14, 15, 21, 22}),
                new SimpleEntry<>(1, new int[] {4, 1, 2})
        );
    }
}