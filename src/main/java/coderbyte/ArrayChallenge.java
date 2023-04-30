package coderbyte;
/*
Coderbyte Challenge

Have the function ArrayChallenge(arr) take the arr parameter being passed which will be an array of integers
and determine the smallest positive integer (including zero) that can be added to the array to make the sum of all
of the numbers in the array add up to the next closest Fibonacci number. For example: if arr is [15, 1, 3],
then your program should output 2 because if you add up 15 + 1 + 3 + 2 you get 21 which is the closest Fibonacci number.

Examples:
Input: new int[] {5,2,1}
Output: 0

Input: new int[] {1,20,2,5}
Output: 6
*/

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class ArrayChallenge {

    public static int solution(int[] arr) {
        IntSummaryStatistics arrayStats = Arrays.stream(arr).summaryStatistics();
        int arraySum = Long.valueOf(arrayStats.getSum()).intValue();
        int[] fibonacci = new int[arraySum + 1];
        if (arr.length > 1) fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
            if (arraySum == fibonacci[i]) return 0;
            if (arraySum < fibonacci[i]) {
                return fibonacci[i] - arraySum;
            }
        }
        return arr[0];
    }
}