package org.example;

//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

public class Strings {
    //Java Program to Find the First Non-repeated Character in a String
    public void firstNonRepeatedCharacter(String inputStr) {
        String s1 = inputStr.toLowerCase();
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            int count = 1;
            for (int j = i + 1; j < s1.length(); j++) {
                if (s1.charAt(i) == s1.charAt(j)) {
                    count += 1;
                    s1 = s1.replace(s1.charAt(j), '0');
                    break;
                }
            }
            if (count == 1 && s1.charAt(i) != '0') {
                System.out.println("The first non repeating character is '" + s1.charAt(i) + "'");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("$");
        }

    }

    //To check the character in a string is digit
    public void isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                System.out.println(c);
            }
            if (Character.isLetter(c)) {
                System.out.println(c);
            }
        }
    }

    public void newString(String s) {
        String str1 = "", str2 = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {

                str1 += c;
            } else if (Character.isLetter(c)) {
                str2 += c;
            }
        }
        System.out.println(str1 + str2);

    }


    private void occurrenceOfChar(String s) {

        int maxOcc = 0;
        char ch = 0;
        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count += 1;
                }
            }

            if (s.charAt(i) != '0') {
                ch = s.charAt(i);
                s = s.replace(s.charAt(i), '0');
//                System.out.println(count);
                if (count > maxOcc) {
                    maxOcc = count;
                }
            }
        }
        System.out.println(ch + " " + maxOcc);
    }


    private void removeDuplicates() {
        String s = "geeksforgeeks";
//        Set<Character> se = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        s.chars().distinct().forEach(c -> sb.append((char) c));
        System.out.println(sb);
//        char[] ss = s.toCharArray();
//        for(char c : ss){
//            se.add(c);
//        }
//        for(char q : se){
//            m+=q;
//        }
//        System.out.println(m);
//            for(int i=0; i<s.length();i++){
//                char charAtIndex = s.charAt(i);
//                if(m.indexOf(charAtIndex) <0){
//                    m+=charAtIndex;
//                    System.out.println(m);
//                }
//            }


    }

    private void repeatingChar() {
        String s = "geeksforgeeks";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && s.charAt(i) != '0') {
                    System.out.println("The repeating character is " + s.charAt(i));
                    s = s.replace(s.charAt(i), '0');
                    break;
                }
            }
        }
    }

    private void removeCharString() {
        String str1 = "India is great";
        String str2 = "in";
        String strResult = "";


        for (int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.toLowerCase().charAt(i)) < 0) {
                strResult += str1.charAt(i);
            }
        }

        System.out.println(strResult);
    }

    private void rotation() {
        String str1 = "IndiaUSAEngland";
        String str2 = "IndiaEnglandUSA";

        String str3 = str1 + str1;
        if (str1.length() == str2.length() && str3.contains(str2)) {
            System.out.println("True");
        } else {
            System.out.println("False");


        }
    }

    public void reverseWords() {
        String s1 = "Java is best";
        List<String> words = Arrays.asList(s1.split("\\s"));
        Collections.reverse(words);
        System.out.println(words);
//        String[] s2 = s1.split(" ");
//        List<String> arr = new ArrayList<>();
//        StringBuilder s3= new StringBuilder();
//        for(int i=s2.length-1;i>=0;i--) {
//            arr.add(s2[i]);
//            arr.add(" ");
//        }
//
//        for(String s5: arr){
//            s3.append(s5);
//        }
//        System.out.println(s3.toString().trim());

    }

    public void anagram() {
        String s1 = "Mary";
        String s2 = "arma";
        boolean flag = false;

        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                flag = s2.toLowerCase().indexOf(s1.toLowerCase().charAt(i)) >= 0;
            }
        }

        if (flag) {
            System.out.println("The strings are anagrams");
        } else {
            System.out.println("NO");
        }
    }

    public void charOcc() {
        String str = "hello";
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> mp = new LinkedHashMap<>();

        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) + 1);
            } else {
                mp.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        System.out.println(sb.toString());
    }

//    public void longestSubString(){
//        String a = "geeksforgeeks";
////        StringBuilder longestss = new StringBuilder();
//        int lengthof = 0;
//        StringBuilder sb =new StringBuilder();
//
//        for(int i=0;i<a.length();i++){
//
//            for(int j=i;j<a.length();j++){
//                String b ="";
//                if(b.indexOf(a.charAt(j)) < 0){
//                    b+=a.charAt(j);
//                }
//                else{
////                    String ss = a.substring(i, j+1);
//                    System.out.println(b);
//                    if(b.length() > lengthof){
//                        lengthof = b.length();
//                    }
//                    i = j;
//                    break;
//                }
//            }
//
//        }
//
////        System.out.println("Longest SS is " + longestss);
//    }

    public void lastOccurChar() {
        String s = "makesthepeerr";
        Character ch = null;
        Map<Character, Integer> mp = new LinkedHashMap<>();
        Map<Character, Integer> mp1 = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!mp.containsKey(c)) {
                mp.put(c, 1);
            } else {
                mp.put(c, mp.get(c) + 1);
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (mp.get(s.charAt(i)) == 1) {
                ch = s.charAt(i);
                break;
            }
        }

        System.out.println(ch);
    }

    public void longestSubString() {
        String s = "pwwkew";
        List<String> ls = new ArrayList<>();
        int i = 0;
        int j = 0;

        for (i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (j = i; j < s.length(); j++) {
                if (sb.indexOf(String.valueOf(s.charAt(j))) < 0) {
                    sb.append(s.charAt(j));
                    if (j == s.length() - 1) {
                        ls.add(sb.toString());
                    }
                } else {
                    ls.add(sb.toString());
                    break;
                }
            }
        }

        int longestLength = 0;
        for (String st : ls) {
            if (st.length() > longestLength) {
                longestLength = st.length();
            }
        }

        System.out.println(longestLength);
    }

    public static void main(String[] args) {
        Strings strings = new Strings();
//            app.occurrenceOfChar("mmssdddffff");
//        app.removeDuplicates();
//        app.repeatingChar();
//        app.removeCharString();
//        app.rotation();
//        strings.reverseWords();
//        app.anagram();
//        strings.charOcc();
//        strings.longestSubString();
//        strings.lastOccurChar();
//        strings.longestSubString();
//        strings.longestPalindrome();
        strings.reverseString();
    }

    private void longestPalindrome() {
        String s = "babad";
        int i = 0;
        int j = 0;
        List<String> ls = new ArrayList<>();
        for (i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
//                String reverse = sb.reverse().toString();
                if (sb.length() > 1 && sb.reverse().equals(sb)) {
                    ls.add(sb.toString());
                }
            }
        }

        System.out.println(ls);
    }

    public void reverseString() {
        int a = 12345;
        String str = String.valueOf(a);
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
        }
        System.out.println(Integer.parseInt(result));
    }
}

//List<WebElement> = driver.findElements(By.xpath("bbvf"));
