package org.example.MEDIUM;

import static java.util.Arrays.binarySearch;

public class SortedRotatedArray {
    public static void main(String[] args) {
        System.out.println(searchElementInSortedRotatedArray(new int[]{1}, 3));
    }

    private static int searchElementInSortedRotatedArray(int[] nums, int target) {
        //logic
        //The array is in increasing order
        //Decreasing order
        //increasing order
        //use the logic to find the peak element
        //using the peak as PIVOT use 2 binary search
        int pivot = findPeakElement(nums);
        int firstTry = binarySearch(nums, target, 0, pivot);
        if(firstTry == -1){
            firstTry = binarySearch(nums, target, pivot+1, nums.length-1);
        }
        return firstTry;

    }

    private static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                //increasing
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end; // Note all the three 'start', 'end' and 'mid' will point to peak element.
    }

    private static int binarySearch(int[] arr, int target,
                                    int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;

            }
        }
        return -1;
    }

}
