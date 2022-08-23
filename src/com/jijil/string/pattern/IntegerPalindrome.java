package com.jijil.string.pattern;

public class IntegerPalindrome {

    public static void main(String[] args) {
        Solution sol =  new Solution();
        System.out.println(sol.isPalindrome(145411));
    }
}


class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;
        int reversedNumber = 0;
        int u = x;
        int rem = x;
        //121
        while (u > 10) {

            rem = u % 10; //1 //2 // 1

            u = (u - rem) / 10; //12 //1 // 0

            reversedNumber = (rem + reversedNumber) * 10; //10 //120 // 1210


        }


        return x == reversedNumber + u;

    }

}