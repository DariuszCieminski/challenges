package coderbyte;
/*
Coderbyte Challenge

Have the function coderbyte.LongestWord(sen) take the sen parameter being passed and return the longest word in the string.
If there are two or more words that are the same length, return the first word from the string with that length.
Ignore punctuation and assume sen will not be empty. Words may also contain numbers, for example "Hello world123 567".

Examples:
Input: "fun&!! time"
Output: time

Input: "I love dogs"
Output: love
*/

import java.util.Arrays;
import java.util.Comparator;

public class LongestWord {
    public static String solution(String sen) {
        return Arrays.stream(sen.split(" "))
                .map(str -> str.replaceAll("[\\W+\\d+]", ""))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }
}