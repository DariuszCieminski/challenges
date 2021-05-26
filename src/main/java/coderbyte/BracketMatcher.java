package coderbyte;
/*
Coderbyte Challenge

Have the function coderbyte.BracketMatcher(str) take the str parameter being passed and return 1 if the brackets are correctly
matched and each one is accounted for. Otherwise return 0. For example: if str is "(hello (world))", then the output
should be 1, but if str is "((hello (world))" the the output should be 0 because the brackets do not correctly match up.
Only "(" and ")" will be used as brackets. If str contains no brackets return 1.

Examples:
Input: "(coder)(byte))"
Output: 0

Input: "(c(oder)) b(yte)"
Output: 1
 */

public class BracketMatcher {
    public static String solution(String str) {
        int openingBrackets = 0;
        int closingBrackets = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                openingBrackets++;
            } else if (c == ')') {
                if (closingBrackets == openingBrackets) {
                    //there is no bracket to close, so return 0
                    return "0";
                }
                closingBrackets++;
            }
        }
        //when counters are equal, all brackets are correctly matched up
        return openingBrackets == closingBrackets ? "1" : "0";
    }
}