package com.jijil.mathematics;

import java.math.*;
public class MathematicsDSA {

    public static void main(String[] args) {

        MathematicsDSA math = new MathematicsDSA();
        System.out.println(math.countDigits(13456533)+ " :: No of digits ");
        System.out.println(math.isPalindrome(122) + " :: Is Palindrome");
        System.out.println(math.factorial(8) + " :: Factorial");
        System.out.println(math.noOfZeroInFactorial(1030) + " :: No of zeroes at end of Factorial");
        System.out.println(math.hcf(15,20) + " HCF/GCD of a number");
        System.out.println(math.lcm(15,18) + " LCM of a number");
       /* for (int i=1;i<100;i++){
            if(math.isPrime(i)){
                System.out.println("Prime number: " + i + " ");
            }
        }*/
        System.out.println(math.isPrime(5) + " ::Prime no or not");

        /**https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/exactly-3-divisors */

        System.out.println(math.exactlyThreeDivisors(12)); // 4,9 are the only numbers having exactly 3 divisors. 4-> 1,2,4 9->1,3,9




    }

    private int exactlyThreeDivisors(int N) {
        //4,9 are the only numbers having exactly 3 divisors. 4-> 1,2,4 9->1,3,9
        //Means These numbers are squares of the prime numbers below that.
        // So only need to check Input/2 nos. Check if they are prime. Also , check i*i< input , that is the i < square root of input number
        int counter = 0;

        for(int i= 0; i*i<=N ;i++){
            if(isPrime(i)) {
                System.out.println(i);
                counter++;
            }
        }
        return counter;
    }

    private boolean isPrime(int input) {

        // Naive method - For loop increment from 2 to number-1. if its reminder 0 for divsion with i break . not a prime
        // Effective method no need to check up to n. instead check only upto sqrt of n.  that is for loop ::   i*i<n ; i+1
        // Also skip cases for factors of 2/3 . start with 5 , increment with 6 , check for i ,i+2

        if (input == 1) return false;
        if (input == 2 || input == 3) return true;
        if (input % 2 == 0 || input % 3 == 0) {
            return false;
        } else {
            //// Check from 5 to square root of n / or i*i <n , checking 5,7 together hence incrementing with 6
            for (int i = 5; i * i <= input; i = i + 6) {

                if (input % i == 0 || input % (i + 2) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int lcm(int a, int b) {
        // a*b = HCF(a,b) * LCM (a,b) Hence divide with hcf from a*b gets LCM
        return a*b / hcf(a,b);
    }

    private int hcf(int a , int b) {

        //euclidean algorithm to find HCF. Recursive strategy instead of continuous substraction

        if(b==0){
            return a;
        }else {
          return  hcf(b,a%b);
        }

    }

    private int noOfZeroInFactorial(int input) {

        int count =0;

        /**
         * 5 1
         * 10 2
         * 20 4
         * 26 6
         *
         */

        for(int i=5; i<input ; i =i*5){
            count = count + input / i;
            //System.out.println(i);
        }

        return count;

    }


    private int factorial(int x){
        int factorial= 1;
        while(x >1){
            factorial = factorial* x;
            x= x-1;
        }
        return factorial;
    }



    private boolean isPalindrome(int inputNumber){
        int temp =inputNumber;
        int reverseNumber = 0;
        while(temp > 0){
            reverseNumber=  reverseNumber*10 +temp%10;
            temp=temp/10;
        }
        return reverseNumber==inputNumber;
    }
    private int countDigits(int x) {
        int increment = 0;
        while(x > 0){
            x = x/10;
            increment++;
        }
        return increment;
    }



}
