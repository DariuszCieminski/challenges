package leetcode;

/*
LeetCode Challenge

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.

There are six instances where subtraction is used:
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
*/

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    private static final Map<Character, Integer> numerals = new HashMap<>();

    static {
        numerals.put('I', 1);
        numerals.put('V', 5);
        numerals.put('X', 10);
        numerals.put('L', 50);
        numerals.put('C', 100);
        numerals.put('D', 500);
        numerals.put('M', 1000);
    }

    public static String toRoman(int num) {
        String number = String.valueOf(num);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            int digit = Character.getNumericValue(number.charAt(i));
            //get digit position starting from the right
            int digitPosition = number.length() - i;

            switch (digitPosition) {
                case 4:
                    appendMultipliedChar(builder, 'M', digit);
                    break;
                case 3:
                    if (digit == 9) {
                        builder.append("CM");
                    } else if (digit == 4) {
                        builder.append("CD");
                    } else {
                        if (digit >= 5) {
                            builder.append('D');
                            digit -= 5;
                        }
                        appendMultipliedChar(builder, 'C', digit);
                    }
                    break;
                case 2:
                    if (digit == 9) {
                        builder.append("XC");
                    } else if (digit == 4) {
                        builder.append("XL");
                    } else {
                        if (digit >= 5) {
                            builder.append('L');
                            digit -= 5;
                        }
                        appendMultipliedChar(builder, 'X', digit);
                    }
                    break;
                case 1:
                    if (digit == 9) {
                        builder.append("IX");
                    } else if (digit == 4) {
                        builder.append("IV");
                    } else {
                        if (digit >= 5) {
                            builder.append('V');
                            digit -= 5;
                        }
                        appendMultipliedChar(builder, 'I', digit);
                    }
                    break;
            }
        }
        return builder.toString();
    }

    private static void appendMultipliedChar(StringBuilder builder, char c, int multiplier) {
        for (int i = 0; i < multiplier; i++) {
            builder.append(c);
        }
    }

    public static int toInteger(String s) {
        int result = 0;
        int previousValue = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int currentValue = numerals.get(s.charAt(i));
            result += currentValue;

            if (currentValue > previousValue) {
                result -= 2 * previousValue;
            }
            previousValue = currentValue;
        }
        return result;
    }
}