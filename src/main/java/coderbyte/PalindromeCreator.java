package coderbyte;
/*
Coderbyte Challenge

Have the function coderbyte.PalindromeCreator(str) take the str parameter being passed and determine if it is possible to create
a palindromic string of minimum length 3 characters by removing 1 or 2 characters.
For example: if str is "abjchba" then you can remove the characters jc to produce "abhba" which is a palindrome.
For this example your program should return the two characters that were removed with no delimiter and in the order
they appear in the string, so jc. If 1 or 2 characters cannot be removed to produce a palindrome, then return the
string "not possible". If the input string is already a palindrome, your program should return the string "palindrome".

The input will only contain lowercase alphabetic characters. Your program should always attempt to create the longest
palindromic substring by removing 1 or 2 characters (see second sample test case as an example). The 2 characters
you remove do not have to be adjacent in the string.

Examples:
Input: "mmop"
Output: not possible

Input: "kjjjhjjj"
Output: k
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromeCreator {
    public static String solution(String str) {

        //check if the input string is already a palindrome
        if (isPalindrome(str)) {
            return "palindrome";
        }

        List<Integer> fromLeft = createPalindrome(str, false);
        if (fromLeft != null) {
            return printResult(str, fromLeft);
        }

        //if we haven't found palindrome, reverse the string and try again
        List<Integer> fromRight = createPalindrome(str, true);
        if (fromRight != null) {
            return printResult(str, fromRight);
        }

        return "not possible";
    }

    private static List<Integer> createPalindrome(String str, boolean isReversed) {
        StringBuilder sb = new StringBuilder(str);

        //reverse the input string
        if (isReversed) {
            sb.reverse();
        }

        //list of character indexes to remove
        List<Integer> removedChars = new ArrayList<>();

        do {
            if (isPalindrome(sb.toString())) {
                //return list of removed characters
                if (isReversed) {
                    //the string is reversed, so we also need to reverse character indexes
                    return removedChars.stream().map(index -> str.length() - 1 - index).collect(Collectors.toList());
                }
                return removedChars;
            }

            int charToRemove = removeFirstNonRepeatingCharacter(sb) + removedChars.size();
            removedChars.add(charToRemove);
            sb.deleteCharAt(charToRemove);
        } while (removedChars.size() <= 2 && sb.length() >= 3);

        //we can't make a palindrome, so return null value
        return null;
    }

    private static String printResult(String str, List<Integer> removedChars) {
        StringBuilder builder = new StringBuilder();
        removedChars.forEach(removedChar -> builder.append(str.charAt(removedChar)));
        return builder.toString();
    }

    private static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }

    //returns the first character from the string beginning that is not repeating in the back
    private static int removeFirstNonRepeatingCharacter(StringBuilder str) {
        StringBuilder reversed = new StringBuilder(str).reverse();

        int charIndex = 0;
        while (charIndex < str.length()) {
            if (str.charAt(charIndex) == reversed.charAt(charIndex)) {
                charIndex++;
            } else break;
        }
        return charIndex;
    }
}