package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeCreatorTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<String, String> testValue) {
        assertEquals(testValue.getKey(), PalindromeCreator.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<String, String>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>("not possible", "mmop"),
                new SimpleEntry<>("k", "kjjjhjjj"),
                new SimpleEntry<>("jc", "abjchba"),
                new SimpleEntry<>("palindrome", "abba"),
                new SimpleEntry<>("b", "banana"),
                new SimpleEntry<>("not possible", "aaabcdcec"),
                new SimpleEntry<>("s", "ananas"),
                new SimpleEntry<>("s", "selfless"),
                new SimpleEntry<>("or", "liveordevil"),
                new SimpleEntry<>("e", "raececar"),
                new SimpleEntry<>("palindrome", "kobylamamalybok"),
                new SimpleEntry<>("dn", "tdttnrttt"),
                new SimpleEntry<>("zy", "xxzxyxxxx")
        );
    }
}