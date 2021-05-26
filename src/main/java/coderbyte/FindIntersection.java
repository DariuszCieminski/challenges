package coderbyte;
/*
Coderbyte Challenge

Have the function coderbyte.FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements:
the first element will represent a list of comma-separated numbers sorted in ascending order,
the second element will represent a second list of comma-separated numbers (also sorted).

Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
If there is no intersection, return the string 'false'.

Examples:
Input: new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}
Output: 1, 4, 13

Input: new String[] {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}
Output: 1, 9, 10
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersection {
    public static String solution(String[] strArr) {
        List<String> first = new ArrayList<>(Arrays.asList(strArr[0].split(", ")));
        List<String> second = new ArrayList<>(Arrays.asList(strArr[1].split(", ")));

        first.retainAll(second);

        return (first.size() > 0) ? String.join(", ", first) : "false";
    }
}