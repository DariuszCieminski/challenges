package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BracketMatcherTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<String, String> testValue) {
        assertEquals(testValue.getKey(), BracketMatcher.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<String, String>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>("0", "(coder)(byte))"),
                new SimpleEntry<>("1", "(c(oder)) b(yte)"),
                new SimpleEntry<>("1", "(hello (world))"),
                new SimpleEntry<>("0", "((hello (world))"),
                new SimpleEntry<>("1", "(bra(cket( ma)tch)er)"),
                new SimpleEntry<>("0", "(brac(ket( mat)cher)"),
                new SimpleEntry<>("1", "((()))"),
                new SimpleEntry<>("1", "()()()()"),
                new SimpleEntry<>("0", "(wro))ng"),
                new SimpleEntry<>("0", ")hello world"),
                new SimpleEntry<>("0", "hello world("),
                new SimpleEntry<>("1", "text without brackets")
        );
    }
}