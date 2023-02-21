package com.jijil.interviwQns;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class RunTwoTaskInDiffThreads extends Thread{




    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Print Even numbers from 1 to 100
                for (int i = 1 ;i < 100 ;i++){
                    if(i%2 == 0) {
                        //Added sleep
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                        System.out.println(Thread.currentThread()+ "  " + i + " Even No");
                }
            }
        },"EvenNumPrintThread");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer i= 10; i<1000 ;i++){

                    char[] charArr =   String.valueOf(i).toCharArray();
                    StringBuilder sb = new StringBuilder();
                    for (int j = charArr.length -1 ; j>=0 ;j --){
                        sb.append(charArr[j]);
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    if(i==Integer.valueOf(sb.toString())){
                        System.out.println(Thread.currentThread()+ " "+ i + " Palindrome number");
                    }

                }

            }
        },"PalindromeNumPrintThread");


        t1.start();

        t2.start();

    }


}

class  RunTwoTaskInDiffThreads2 extends Thread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new EvenNumberCheck(),"evenNoThread");
        Thread t2 = new Thread(new PrimeNumberCheck(),"primeNoThread");

        t1.start();
        t2.start();
    }


}

class EvenNumberCheck implements Runnable {


        @Override
        public void run() {
        //Print Even numbers from 1 to 100
        for (int i = 1 ;i < 100 ;i++){
            if(i%2 == 0) {
                //Added sleep
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread()+ "  " + i + " Even No");
        }
    }

}

class PrimeNumberCheck implements  Runnable {


    @Override
    public void run() {



        //Print Prime numbers from 10 to 100
        for (int i = 10 ;i < 100 ;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            boolean isPrime =false;
            for( int j = i-1 ; j > 1 ; j--){
                if(i%j == 0){
                    break;
                }

                if(j==2){
                    System.out.println(Thread.currentThread() + " "+ i + " is Prime no");
                }

            }
            isPrime =false;
        }

    }
}