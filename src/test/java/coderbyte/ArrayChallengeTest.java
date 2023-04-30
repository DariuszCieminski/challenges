package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayChallengeTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<Integer, int[]> testValue) {
        assertEquals(testValue.getKey(), ArrayChallenge.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<Integer, int[]>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>(0, new int[] {5, 2, 1}),
                new SimpleEntry<>(6, new int[] {1, 20, 2, 5}),
                new SimpleEntry<>(2, new int[] {15, 1, 3}),
                new SimpleEntry<>(11, new int[] {12, 32}),
                new SimpleEntry<>(54, new int[] {76, 1, 13}),
                new SimpleEntry<>(0, new int[] {0})
        );
    }
}