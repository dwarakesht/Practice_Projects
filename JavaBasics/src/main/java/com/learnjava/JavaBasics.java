package com.learnjava;

/**
 * Hello world!
 */
public class JavaBasics {
    public static void main(String[] args) {
        JavaBasics jb = new JavaBasics();
//        System.out.println(jb.primeNumber(22));
//        jb.typeConversion();
        jb.typePromotion();

    }

    /* logic is to find the factors of the number
    // Number - 18
    // 1*18
    // 2*9
    // 3*6
    // 6*3
    // 9*2
    // 18*1
    // to check condition for square of the number */
    private String primeNumber(int num) {
        int i = 2;
        boolean flag = true;
        while(i*i < num){
            if(num%i==0){
                return num + " is not Prime";
            }
            i++;
        }
        return num + " is Prime";
    }
    private void typeConversion(){
        int d = (int) (5*2.0);
        System.out.println(d);
    }

    private void typePromotion(){
        int d = 257;
        byte b = (byte) d;
        System.out.println(b);
    }
}
