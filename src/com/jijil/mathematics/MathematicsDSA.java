package com.jijil.mathematics;

public class MathematicsDSA {

    public static void main(String[] args) {

        MathematicsDSA math = new MathematicsDSA();
        System.out.println(math.countDigits(13456533)+ " :: No of digits ");
        System.out.println(math.isPalindrome(122) + " :: Is Palindrome");
        System.out.println(math.factorial(8) + " :: Factorial");
        System.out.println(math.noOfZeroInFactorial(1030) + " :: No of zeroes at end of Factorial");
        System.out.println(math.hcf(15,20) + " HCF/GCD of a number");
        System.out.println(math.lcm(15,18) + " LCM of a number");
        System.out.println(math.isPrime(29) + " :: Is Prime no ?");
    }

    private boolean isPrime(int i) {
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
