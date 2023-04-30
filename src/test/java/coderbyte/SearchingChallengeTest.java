package coderbyte;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchingChallengeTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void solution(Map.Entry<String, String> testValue) {
        assertEquals(testValue.getKey(), SearchingChallenge.solution(testValue.getValue()));
    }

    private static Stream<Map.Entry<String, String>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>("H--e--llo", "Hello apple pie"),
                new SimpleEntry<>("---1--", "No words"),
                new SimpleEntry<>("Brzęczy--s--zczyki--e----w--icz", "Grzegorz Brzęczyszczykiewicz"),
                new SimpleEntry<>("ringing", "The phone is ringing really loud."),
                new SimpleEntry<>("gr--e----a--t--e----s--t", "Today, is the greatest day ever!")
        );
    }
}