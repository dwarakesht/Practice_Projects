package org.example.EASY;
//https://leetcode.com/problems/valid-perfect-square/
public class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
    public static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        boolean isPS = false;
        while(start <= end){
            int mid = start + (end-start)/2;
            if((long) mid * mid == num){
                isPS = true;
                break;
            }
            else if((long) mid * mid > num){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return isPS;
    }
}
