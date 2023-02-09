package com.jijil.leetcode;
//https://leetcode.com/problems/palindrome-number/submissions/
public class IntegerPalindrome {

    public static void main(String[] args) {
        Solution sol =  new Solution();
        System.out.println(sol.isPalindrome(12341
        ));

    }
}

class Solution {
    public boolean isPalindrome(int x) {



        /*

        Reminder with 10 gives 1's place = y
        y*10;
        Divide by 10 gives the remaining no.

        Do this till Division value returns 0


        */
        if (x < 0) {
            return false;
        }

        long y = 0 ;
        long i = x ;

        while(i != 0 ){
//12341
            y = 10 * (i%10 + y) ;
            i = i/10;

            System.out.println("y : " + y + " :: i :"  + i);
        }

        return x == y/10 ;



    }



}