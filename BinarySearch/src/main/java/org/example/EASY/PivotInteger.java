package org.example.EASY;

public class PivotInteger {
    public static void main(String[] args) {
        System.out.println(pivotInteger(4));
    }
    public static int pivotInteger(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum1 = mid * (mid + 1) / 2;
            int sum2 = (int) (((float) (n - mid + 1)/2) * (mid + n));
            if (sum1 == sum2) {
                return mid;
            } else if (sum1 < sum2) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
