package org.example.EASY;

//leetcode-1064 Premium
public class FixedPoint {
    public static void main(String[] args) {
        System.out.println(fixedPoint(new int[]{1,2,5,8,17}));
    }
    private static int fixedPoint(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
