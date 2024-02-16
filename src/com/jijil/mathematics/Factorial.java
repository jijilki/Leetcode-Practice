package com.jijil.mathematics;

public class Factorial {


    public static void main(String[] args) {
        int factorial = getFactorial(10);
        System.out.println(factorial);

        int zeroesInFactorial = getZeroesInFactorial(20);
        System.out.println(zeroesInFactorial);


    }

    static int getFactorial(int n){

        int result = 1;

        while(n>1){
            result = result*n;
            n--;
        }

        return result;
    }
    
    
    static int getZeroesInFactorial(int n){

        // Only Fives produces 0. 5*2 , and in 25 there are two fives. 125 there are three fives. so divide number with 5 , 25 etc and add the sum to counter

        int result = 0;
        
        for(int i=5; i <=n ; i=i*5){
             result =result + n / i;
        }
        
        return result;
    }

}
