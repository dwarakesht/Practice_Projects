package org.example.HARD;

import java.util.Arrays;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3}, new int[]{2, 4})));
    }

    static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[index] = nums1[i];
                i++;
            } else {
                result[index] = nums2[j];
                j++;
            }
            index++;
        }
        while(i<nums1.length){
            result[index] = nums1[i];
            i++;
            index++;
        }
        while(j<nums2.length){
            result[index] = nums2[j];
            j++;
            index++;
        }
        return result;
    }


}
