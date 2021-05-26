package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionsMarksTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<String, String> testValue) {
        assertEquals(testValue.getKey(), QuestionsMarks.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<String, String>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>("true", "arrb6???4xxbl5???eee5"),
                new SimpleEntry<>("false", "aa6?9"),
                new SimpleEntry<>("true", "acc?7??sss?3rr1??????5"),
                new SimpleEntry<>("false", "akk?4sss??np6a?b?c?4"),
                new SimpleEntry<>("true", "ee?xc2?ppp?nra?xs8r3???7p"),
                new SimpleEntry<>("false", "dcc5?fr??lax57pt?ui?q3"),
                new SimpleEntry<>("true", "hk47??oo?3k5???5v4m?pwy??6t1???9"),
                new SimpleEntry<>("false", "aaaw3sds?5jjj??8kr???1")
        );
    }
}