package hackerrank;

/*
Hackerrank Challenge
https://www.hackerrank.com/challenges/sherlock-and-valid-string

Sherlock considers a string to be valid if all characters of the string appear the same number of times.
It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters will occur
the same number of times. Given a string, determine if it is valid. Print YES if string is valid, otherwise print NO.
 */

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockValidString {
    public static String solution(String s) {
        Map<Character, Integer> letterCounters = new HashMap<>();

        // loop for all characters and store their occurrences in the map
        for (char c : s.toCharArray()) {
            letterCounters.merge(c, 1, Integer::sum);
        }

        // count how many characters (value) occurs certain number of times (key)
        Map<Integer, Integer> occurFrequencies = new HashMap<>();
        letterCounters.forEach((letter, counter) -> occurFrequencies.merge(counter, 1, Integer::sum));

        boolean isValid = true;

        // We can only remove 1 letter. So if there are more than 2 occurrence frequencies, the string is invalid.
        if (occurFrequencies.size() > 2) {
            isValid = false;
        } else if (occurFrequencies.size() == 2 && !occurFrequencies.getOrDefault(1, -1).equals(1)) {
            // if the string does not contain unique letter we can remove, then we need to compare letter frequencies
            IntSummaryStatistics freqStats = occurFrequencies.keySet().stream()
                    .collect(Collectors.summarizingInt(Integer::intValue));
            int freqDifference = freqStats.getMax() - freqStats.getMin();
            if (freqDifference > 1) {
                isValid = false;
            } else {
                int minFreqValue = occurFrequencies.get(freqStats.getMin());
                int maxFreqValue = occurFrequencies.get(freqStats.getMax());
                // There must be less characters with higher frequency. If not, max frequency must have only 1 char.
                if (maxFreqValue >= minFreqValue || maxFreqValue != 1) {
                    isValid = false;
                }
            }
        }
        return isValid ? "YES" : "NO";
    }
}