package org.example;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{6, 1, 2, 8, 3, 4, 7, 10, 5}));
    }

    private static int missingNumber(int[] nums) {
        System.out.println(System.getProperty("user.dir") + "/src");

        return 0;
    }

    private static int minimumNum(int[] nums) {
        int minimum = Integer.MAX_VALUE;
        for (int num : nums) {
            minimum = StrictMath.min(num, minimum);
        }
        return minimum;

    }

    private static int maximumNum() {
        int rowCount = 6;
        int colCount = 4;
        for (int i = 1; i < rowCount; i++) {

        }
        return 0;
    }
}
