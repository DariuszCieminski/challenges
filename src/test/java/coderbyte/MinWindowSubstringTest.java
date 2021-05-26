package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinWindowSubstringTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<String, String[]> testValue) {
        assertEquals(testValue.getKey(), MinWindowSubstring.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<String, String[]>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>("aksfaje", new String[] {"ahffaksfajeeubsne", "jefaa"}),
                new SimpleEntry<>("affhkkse", new String[] {"aaffhkksemckelloe", "fhea"}),
                new SimpleEntry<>("dae", new String[] {"aaabaaddae", "aed"}),
                new SimpleEntry<>("aabd", new String[] {"aabdccdbcacd", "aad"}),
                new SimpleEntry<>("remipsu", new String[] {"loremipsum", "pur"}),
                new SimpleEntry<>("jbtghguhj", new String[] {"putjbtghguhjjjanika", "jugbtjh"}),
                new SimpleEntry<>("vqerchhsd", new String[] {"yutthasxcvqerchhsdfitoixcv", "vqcds"}),
                new SimpleEntry<>("vbnmlakjhgfdsa", new String[] {"asfgtqwafpzjyiurzxcvbnmlakjhgfdsaqwerty", "java"})
        );
    }
}