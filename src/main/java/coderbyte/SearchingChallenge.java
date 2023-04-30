package coderbyte;
/*
Coderbyte Challenge

Have the function SearchingChallenge(str) take the str parameter being passed and return the first word with
the greatest number of repeated letters. For example: "Today, is the greatest day ever!" should return greatest because
it has 2 e's (and 2 t's) and it comes before ever which also has 2 e's. If there are no words with repeating letters
return -1. Words will be separated by spaces. Once your function is working, take the final output string and replace
all characters that appear in your ChallengeToken with --[CHAR]--.

Your ChallengeToken: uehmswj41ad

Examples:
Input: "Hello apple pie"
Output: Hello
Final Output: H--e--llo

Input: "No words"
Output: -1
Final Output: ---1--
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SearchingChallenge {

    public static String solution(String str) {
        String[] words = str.split(" ");
        String greatestWord = "";
        int maxReps = -1;

        for (String word : words) {
            Map<Character, Integer> letterOccurrences = new HashMap<>();
            for (Character letter : word.toCharArray()) {
                letterOccurrences.merge(letter, 1, Integer::sum);
            }
            int mostReps = Collections.max(letterOccurrences.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
            if (mostReps > maxReps) {
                maxReps = mostReps;
                greatestWord = word;
            }
        }
        if (maxReps == 1) {
            greatestWord = "-1";
        }

        String challengeToken = "uehmswj41ad";
        StringBuilder stringBuilder = new StringBuilder(greatestWord);
        for (Character tokenLetter : challengeToken.toCharArray()) {
            int letterIndex = 0;
            int indexOffset = 0;
            while (letterIndex != -1) {
                letterIndex = stringBuilder.indexOf(tokenLetter.toString(), indexOffset);
                indexOffset = letterIndex + 1;
                if (letterIndex != -1) {
                    stringBuilder.replace(letterIndex, letterIndex + 1, "--" + tokenLetter + "--");
                    indexOffset += 4;
                }
            }
        }

        return stringBuilder.toString();
    }
}