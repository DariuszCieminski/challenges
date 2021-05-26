package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumbersTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void toRoman(Map.Entry<Integer, String> testValue) {
        assertEquals(testValue.getValue(), RomanNumbers.toRoman(testValue.getKey()));
    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void toInteger(Map.Entry<Integer, String> testValue) {
        assertEquals(testValue.getKey(), RomanNumbers.toInteger(testValue.getValue()));
    }

    private static Stream<Map.Entry<Integer, String>> valuesProvider() {
        return Stream.of(
                new SimpleEntry<>(3, "III"),
                new SimpleEntry<>(4, "IV"),
                new SimpleEntry<>(9, "IX"),
                new SimpleEntry<>(58, "LVIII"),
                new SimpleEntry<>(1994, "MCMXCIV"),
                new SimpleEntry<>(49, "XLIX"),
                new SimpleEntry<>(1999, "MCMXCIX"),
                new SimpleEntry<>(19, "XIX"),
                new SimpleEntry<>(1410, "MCDX"),
                new SimpleEntry<>(1370, "MCCCLXX"),
                new SimpleEntry<>(3883, "MMMDCCCLXXXIII"),
                new SimpleEntry<>(0, "")
        );
    }
}