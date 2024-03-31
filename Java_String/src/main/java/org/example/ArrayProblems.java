package org.example;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class ArrayProblems {


    public void test() {
        int arr[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int temp[] = new int[arr.length];

        int rd = 0;
        temp[rd] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != temp[rd]) {
                rd++;
                temp[rd] = arr[i];
            }
        }

        System.out.println(Arrays.toString(temp));
    }

    public void removeElement() {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int rd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[rd] = nums[i];
                rd++;
            }
        }
        System.out.println(Arrays.toString(nums) + rd);
    }

    public void plus_one() {
        int[] digits = {4, 3, 2, 1};
        String value = "";
        for (int i = 0; i < digits.length; i++) {
            value += String.valueOf(digits[i]);
        }
        int plus_one = Integer.parseInt(value) + 1;
        System.out.println(plus_one);
        String s = String.valueOf(plus_one);
        int[] output = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            output[i] = Integer.parseUnsignedInt(String.valueOf(s.charAt(i)));
        }
        System.out.println(Arrays.toString(output));
    }

    public void pascalTriangle(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    rowList.add(1);
                } else {
                    List<Integer> prevRow = pascal.get(i - 2);
                    rowList.add(prevRow.get(j - 1) + prevRow.get(j - 2));
                }
            }
            pascal.add(rowList);
        }
        System.out.println(pascal.get(3));
    }

    public void singleNumber(int[] nums) {
        Map<Integer, Integer> hs = new HashMap<>();
        for (int num : nums) {
            hs.put(num, hs.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (hs.get(num) == 1) {
                System.out.println(num);
                break;
            }
        }
    }


    public void groupAnagram(String[] strs) {
        List<List<String>> finalResult = new ArrayList<>();
        Map<String, List<String>> hs = new HashMap<>();
        for (String temp : strs) {
            char[] array = temp.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            if(hs.containsKey(sorted)){
                hs.get(sorted).add(temp);
            }
            else{
                List<String> tempList = new ArrayList<>();
                tempList.add(temp);
                hs.put(sorted, tempList);
            }
        }

        for(Map.Entry<String, List<String>> mp : hs.entrySet()){
            finalResult.add(mp.getValue());
        }
        System.out.println(finalResult);
//        List<String> visited = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            Map<Character, Integer> hs1 = new HashMap<>();
//            List<String> groupList = new ArrayList<>();
//            if (!visited.contains(strs[i])) {
//                visited.add(strs[i]);
//                groupList.add(strs[i]);
//                char[] strCharsI = strs[i].toCharArray();
//                for (char ch1 : strCharsI) {
//                    hs1.put(ch1, hs1.getOrDefault(ch1, 0) + 1);
//                }
//                for (int j = i + 1; j < strs.length; j++) {
//                    Map<Character, Integer> hs2 = new HashMap<>();
//                    char[] strCharsJ = strs[j].toCharArray();
//                    for (char ch2 : strCharsJ) {
//                        hs2.put(ch2, hs2.getOrDefault(ch2, 0) + 1);
//                    }
//                    if (hs1.equals(hs2)) {
//                        visited.add(strs[j]);
//                        groupList.add(strs[j]);
//                    }
//                }
//                finalResult.add(groupList);
//            }
//        }
    }

    public void summaryRanges(int[] nums){
        int t = 0;
        int i = 1;
        List<String> result = new ArrayList<>();
        while(t<=i){
            if(nums[i] - nums[i - 1] == 1){
                // String str = String.valueOf(t) + "->" + String.valueOf(i);
                i++;
            }
            else{

                String str = nums[t] + "->" + nums[i - 1];
                t = i;
                i++;
            }
        }
    }

    public void frequencySort(String s){
        Map<Character, Integer> hs = new HashMap<>();
        Map<Integer, List<Character>> tree = new TreeMap<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        //add character with it's frequency
        for (int i = 0; i < s.length(); i++) {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
        }
        //add freq as key and chracters as value list
        for(Map.Entry<Character, Integer> entry : hs.entrySet()){
            if(tree.containsKey(entry.getValue())){
                tree.get(entry.getValue()).add(entry.getKey());
            }
            else{
                List<Character> l = new ArrayList<>();
                l.add(entry.getKey());
                tree.put(entry.getValue(), l);
            }
        }
        //create string from tree
        for(Map.Entry<Integer, List<Character>> st : tree.entrySet()){
            int freq = st.getKey();
            for(char ch : st.getValue()){
                for(int j =0; j< freq; j++){
                    sb.append(ch);
                }
            }
        }
    }

    private void perfectSquares(int n) {
        int pq = 0;
        int i = 1;
        List<Integer> pqList =  new ArrayList<>();
        while(pq <= n){
            pq = i * i;
            if(pq<=n){
                pqList.add(pq);
            }
            i++;
        }
        System.out.println(pqList);
    }

    public static void main(String[] args) {
        ArrayProblems arr = new ArrayProblems();
//        arr.plus_one();
//        arr.pascalTriangle(5);
//        arr.singleNumber(new int[] {4,1,2,1,2});
        arr.groupAnagram(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
//        arr.summaryRanges(new int[] {0,2,3,4,6,8,9});
//        arr.frequencySort("tree");
//        arr.perfectSquares(12);
    }



}