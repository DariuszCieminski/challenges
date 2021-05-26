package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestWordTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<String, String> testValue) {
        assertEquals(testValue.getKey(), LongestWord.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<String, String>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>("time", "fun&!! time"),
                new SimpleEntry<>("love", "I love dogs"),
                new SimpleEntry<>("Hello", "Hello world123 567"),
                new SimpleEntry<>("seen", "H@ve you 3v3r seen the rain?"),
                new SimpleEntry<>("quick", "The quick brown fox jumps over the lazy dog"),
                new SimpleEntry<>("liquor", "Pack my box with five dozen liquor jugs."),
                new SimpleEntry<>("wizards", "The five boxing wizards jump quickly.")
        );
    }
}