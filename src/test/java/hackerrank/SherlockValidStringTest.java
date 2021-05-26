package hackerrank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SherlockValidStringTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<String, String> testValue) {
        assertEquals(testValue.getKey(), SherlockValidString.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<String, String>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>("YES", "abc"),
                new SimpleEntry<>("YES", "abcc"),
                new SimpleEntry<>("NO", "abccc"),
                new SimpleEntry<>("NO", "aabbcd"),
                new SimpleEntry<>("NO", "aabbccddeefghi"),
                new SimpleEntry<>("YES", "abcdefghhgfedecba"),
                new SimpleEntry<>("YES", "zzzbebebebeza"),
                new SimpleEntry<>("NO", "abacbdeebdffg"),
                new SimpleEntry<>("NO", "aaaabbbbccccddd"),
                new SimpleEntry<>("NO", "aaaabbbbcccdddeee"),
                new SimpleEntry<>("YES", "xxyayzz"),
                new SimpleEntry<>("YES", "aaaaaa"),
                new SimpleEntry<>("NO", "xyyyzzzz"),
                new SimpleEntry<>("YES", "xyyyyzzzz"),
                new SimpleEntry<>("YES", "aabbbcc"),
                new SimpleEntry<>("NO", "aaabbbbb")
        );
    }
}