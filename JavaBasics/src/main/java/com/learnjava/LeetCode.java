package com.learnjava;

import java.util.Arrays;

public class LeetCode {

    public static void main(String[] args) {
        moveZeros(new int[]{0});
    }
    public static void moveZeros(int[] numbers) {
        // Two Pointers Approach
        int i = 1;
        int rd = 0;
        while (i < numbers.length) {
            if (numbers[rd] == 0) {
                if (numbers[i] != 0) {
                    numbers[rd] = numbers[i];
                    numbers[i] = 0;
                    rd++;
                }
            } else {
                rd++;
            }
            i++;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
