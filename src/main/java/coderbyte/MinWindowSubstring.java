package coderbyte;
/*
Coderbyte Challenge

Have the function coderbyte.MinWindowSubstring(strArr) take the array of strings stored in strArr, which will contain only two
strings, the first parameter being the string N and the second parameter being a string K of some characters,
and your goal is to determine the smallest substring of N that contains all the characters in K.
For example: if strArr is ["aaabaaddae", "aed"] then the smallest substring of N that contains the characters a, e,
and d is "dae" located at the end of the string. So for this example your program should return the string dae.

Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring of N that contains all of the
characters in K is "aabd" which is located at the beginning of the string. Both parameters will be strings ranging
in length from 1 to 50 characters and all of K's characters will exist somewhere in the string N.
Both strings will only contains lowercase alphabetic characters.

Examples:
Input: new String[] {"ahffaksfajeeubsne", "jefaa"}
Output: aksfaje

Input: new String[] {"aaffhkksemckelloe", "fhea"}
Output: affhkkse
*/

public class MinWindowSubstring {
    public static String solution(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];
        char[] chars = K.toCharArray();

        String smallestSubstr = N;

        //iterate for each character of N,
        //then create substrings with increasing length and check if they contain characters from K
        for (int i = 0; i < N.length(); i++) {
            for (int j = i + K.length(); j <= N.length(); j++) {
                String substr = N.substring(i, j);
                if (doesStringContainAllChars(substr, chars) && substr.length() < smallestSubstr.length()) {
                    smallestSubstr = substr;
                }
            }
        }
        return smallestSubstr;
    }

    private static boolean doesStringContainAllChars(String str, char[] chars) {
        String copy = str;
        for (char ch : chars) {
            if (copy.indexOf(ch) == -1) {
                return false;
            }
            //remove the already found char in case of repeating characters
            copy = copy.replaceFirst(String.valueOf(ch), "");
        }
        return true;
    }
}