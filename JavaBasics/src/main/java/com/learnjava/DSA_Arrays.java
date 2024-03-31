package com.learnjava;

import java.util.*;

public class DSA_Arrays {
    public static void main(String[] args) {
        DSA_Arrays arrays = new DSA_Arrays();
//        System.out.println(Arrays.toString(arrays.buildArray(new int[]{5,0,1,2,3,4})));
//        System.out.println(Arrays.toString(arrays.getConcatenation(new int[]{1, 2, 1})));
//        System.out.println(Arrays.toString(arrays.runningSum(new int[] {1,2,3,4})));
//        System.out.println(arrays.maximumWealth(new int[][] {{1,5},{7,3},{3,5}}));
//        System.out.println(arrays.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(arrays.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(Arrays.toString(arrays.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }

    //leetcode-1920
    /* Without using the extra space, we can calculate using formula
        nums[i] = nums[i] + n*(nums[nums[i]] % n);
        for(int i=0; i<n; i++){
            nums[i] = nums[i]/n;
        }
     */
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    //leetcode-1929
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    //leetcode-1480
    /*
    Without creating an extra space, modify the existing array using the below logic
     */
    public int[] runningSum(int[] nums) {
        int i = 1;
        int sum = nums[0];
        while (i < nums.length) {
            sum = sum + nums[i];
            nums[i] = sum;
            i++;
        }
        return nums;
    }

    /*
    Leetcode-1672
    2D array -
     */
    public int maximumWealth(int[][] accounts) {
        int maxSum = Integer.MIN_VALUE;
        for (int customer = 0; customer < accounts.length; customer++) {
            int sum = 0;
            for (int bank = 0; bank < accounts[customer].length; bank++) {
                sum += accounts[customer][bank];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }


    //leetcode-1431
    /*
    Optimal - Find the MAX from the List and equate it with the total candies
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
//        for(int i =0; i< candies.length; i++){
//            int totalCandie = candies[i] + extraCandies;
//            boolean flag  = true;
//            for (int j = 0; j < candies.length; j++) {
//                if (i != j && totalCandie < candies[j]) {
//                    flag = false;
//                    break;
//                }
//            }
//            result.add(flag);
//        }
//        return result;
        int max = Integer.MIN_VALUE;
        for (int candie : candies) {
            max = Math.max(max, candie);
        }
        for (int candie : candies) {
            result.add(extraCandies + candie >= max);
        }
        return result;
    }

    //leetcode-1512
    public int numIdenticalPairs(int[] nums) {
//Brute Force
        /*int count = 0;
        for (int k = 0; k < nums.length; k++) {
            for (int l = 0; l < nums.length; l++) {
                if(nums[k]==nums[l] && k < l){
                    count++;
                }
            }
        }
        return count;*/
//Optimal Solution using Combinations nCr
        Map<Integer, Integer> hs = new HashMap<>();
        for (int num : nums) {
            hs.put(num, hs.getOrDefault(num, 0) + 1);
        }
        int totalCount = 0;
        for (Map.Entry<Integer, Integer> ms : hs.entrySet()) {
            int value = ms.getValue();
            totalCount += (value) * (value - 1) / 2;
        }
        return totalCount;
    }

    //leetcode-1365
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //BruteForce
        /*int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count = 0;
            for(int j=0; j<nums.length;j++){
                if(i != j && nums[j] < nums[i]){
                    count++;
                }
            }
            result[i] = count;
        }
        return result; */

        //optimal
        int[] buckets = new int[102];
        for (int num : nums) {
            buckets[num]++;
        }
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }
        int[] result = new int[nums.length];
        for(int j =0; j<result.length; j++){
            result[j] = buckets[nums[j] - 1];
        }
        return result;
    }
}
