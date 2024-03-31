package org.example.EASY;
//https://leetcode.com/problems/guess-number-higher-or-lower/
public class GuessNumber {
    public static void main(String[] args) {
        System.out.println(guessNumber(8));
    }
    public static int guessNumber(int n) {
        int start = 1;
        int end = n;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
    private static int guess(int mid) {
        //Logic to return random number
        return 0;
    }
}
