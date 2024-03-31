package org.example.EASY;
//https://leetcode.com/problems/arranging-coins/
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
    public static int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if ((mid * (mid + 1)) / 2 > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) end;
    }
}
