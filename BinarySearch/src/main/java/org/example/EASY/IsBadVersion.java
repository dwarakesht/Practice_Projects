package org.example.EASY;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/first-bad-version/
public class IsBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;

            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private static boolean isBadVersion(int mid) {
        //logic has to be implemented
        Map<Integer, Boolean> hs = new LinkedHashMap<>();
        hs.put(1, false);
        hs.put(2, true);
        hs.put(3, true);
        hs.put(4, true);
        hs.put(5, true);
        return hs.get(mid);
    }
}
