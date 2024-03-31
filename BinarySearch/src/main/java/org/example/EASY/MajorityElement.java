package org.example.EASY;
//leetcode 1150 - Number is said to be majority element
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,4,5,5,5,5,5,6,6}, 7));
    }

    private static boolean majorityElement(int[] nums, int target) {
        //find pivot and find use 2 binary search and get the start and end index
        int startIndex = getIndex(nums, target, true);
        int endIndex = getIndex(nums, target, false);
        return (endIndex - startIndex + 1) > nums.length/2;
    }

    public static int getIndex(int[] nums, int target, boolean startIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (startIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
