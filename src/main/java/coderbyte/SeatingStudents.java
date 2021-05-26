package coderbyte;
/*
Coderbyte Challenge

Have the function coderbyte.SeatingStudents(arr) read the array of integers stored in arr which will be in the
following format: [K, r1, r2, r3, ...] where K represents the number of desks in a classroom,
and the rest of the integers in the array will be in sorted order and will represent the desks
 that are already occupied. All of the desks will be arranged in 2 columns,
 where desk #1 is at the top left, desk #2 is at the top right, desk #3 is below #1, desk #4 is below #2, etc.
 Your program should return the number of ways 2 students can be seated next to each other.
 This means 1 student is on the left and 1 student on the right, or 1 student is directly above or below the other student.
For example: if arr is [12, 2, 6, 7, 11] then this classrooms looks like the following picture (occupied seats in brackets):

1    (2)
3     4
5    (6)
(7)   8
9    10
(11) 12

Based on above arrangement of occupied desks, there are a total of 6 ways to seat 2 new students next to each other.
The combinations are: [1, 3], [3, 4], [3, 5], [8, 10], [9, 10], [10, 12]. So for this input your program should return 6.
K will range from 2 to 24 and will always be an even number. After K, the number of occupied desks in the array can range from 0 to K.

Sample Test Cases:
Input: [6, 4]
Output: 4

Input: [8, 1, 8]
Output: 6
*/

import java.util.Arrays;

public class SeatingStudents {
    public static int solution(int[] arr) {
        //mark occupied seats
        int numberOfSeats = arr[0];
        boolean[] isSeatFree = new boolean[numberOfSeats];
        Arrays.fill(isSeatFree, true);
        for (int i = 1; i < arr.length; i++) {
            isSeatFree[arr[i] - 1] = false;    //-1 because desk numeration starts with 1
        }

        int counter = 0;
        //loop for each row except last
        for (int i = 0; i < numberOfSeats - 2; i += 2) {
            //check free seats horizontally
            if (isSeatFree[i] && isSeatFree[i + 1]) counter++;
            //check free seats vertically in left column
            if (isSeatFree[i] && isSeatFree[i + 2]) counter++;
            //check free seats vertically in right column
            if (isSeatFree[i + 1] && isSeatFree[i + 3]) counter++;
        }
        //check seats in the last row
        if (isSeatFree[numberOfSeats - 1] && isSeatFree[numberOfSeats - 2]) counter++;

        return counter;
    }
}