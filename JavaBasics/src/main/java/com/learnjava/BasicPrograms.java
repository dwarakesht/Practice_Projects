package com.learnjava;


import java.util.*;

public class BasicPrograms {
    public static void main(String[] args) {
        BasicPrograms bs = new BasicPrograms();
//        bs.leapYear(2016);
//        bs.reverseInteger(121);
//        bs.oddOrEven();
//        bs.greetingMessage();
//        bs.simpleInterestCalculator();
//        bs.largestNumber();
//        bs.INRtoUSD();
//        bs.fibonacci(10);
//        bs.palindrome("malayalam");
//        bs.amstrongNumber(999);
//        bs.generateRandomDigits(14);
//        bs.varArgs(1,2,3,4,5);
        System.out.println(bs.missingNumber( new int[] {9,6,4,2,3,5,7,0,1}));
    }

    private int missingNumber(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for(int num : nums){
            numsList.add(num);
        }
        int missingNum = 0;
        for (int i = 0; i <= nums.length ; i++) {
            if (!numsList.contains(i)) {
                missingNum = i;
                return missingNum;
            }
        }
        return -1;
    }

    private void amstrongNumber(int limit) {
        int num = 1;
        while(num <= limit){
            int lenOfDigit = String.valueOf(num).length();
            if(calculateSumOfDigits(lenOfDigit, num) == num){
                System.out.println(num);
            }
            num++;
        }
    }

    private int calculateSumOfDigits(int lenOfDigit, int num) {
        int sum = 0;
        while(num>0){
            int rem = num % 10;
            sum += (int) StrictMath.pow(rem, lenOfDigit);
            num = num / 10;
        }
//        System.out.println(sum);
        return sum;
    }

    private void fibonacci(int n) {
        int a = 0;
        int b = 1;
        int count = 2;

        while(count <= n){
            int newNum = a + b;
            a = b;
            b = newNum;
            System.out.println(newNum);
            count++;
        }

    }

    private void INRtoUSD() {

        Scanner sc = new Scanner(System.in);
        double inr = sc.nextDouble();
        double usd = inr * 0.0120440;
        System.out.println(usd);
    }

    private void largestNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNum = sc.nextInt();
        System.out.print("Enter the second number: ");
        int secondNum = sc.nextInt();

        int max = firstNum;
        if(secondNum > max){
            max = secondNum;
        }
        System.out.println("The largest number is: " + max);
    }


    private void simpleInterestCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the principal amount: ");
        long principal = sc.nextLong();
        System.out.print("Enter the rate of interest: ");
        double rate = sc.nextDouble();
        System.out.print("Enter the tenure: ");
        int years = sc.nextInt();

        double si = (principal * years * rate) / 100;
        System.out.println("Simple Interest = " + si);

    }


    private void oddOrEven() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int userInput = input.nextInt();
        if(userInput % 2 == 0){
            System.out.println(userInput + " is EVEN");
        }
        else{
            System.out.println(userInput + " is ODD");
        }
    }

    private void greetingMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name: ");
        System.out.println("Welcome ! ! " + sc.nextLine());
    }

    private void palindrome(String word) {
        StringBuilder sb = new StringBuilder(word);

    }

    private void reverseInteger(int x){
        int rev = 0;
        int org = x;
        while(x>0){
            int lastDigit = x % 10;
            rev = rev * 10 + lastDigit;
            x = x/10;
        }
        System.out.println(rev + " " + org);
    }

    private void generateRandomDigits(int length){
        long value = (long) Math.pow(10, length -1);
        long num = value + new Random().nextInt(Math.toIntExact(9 * value));
        System.out.println(num);
    }
}
