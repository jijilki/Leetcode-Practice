package com.jijil.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafety {

    public static void main(String[] args) throws InterruptedException {

        //Synchronized testing
        TestSynchronized ts = new TestSynchronized();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                ts.printNumbers(15);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ts.printNumbers(10);

            }
        });

        t1.start();
        t2.start();

        //Atomic variable as a counter with Thread safety. One thread access it then other pick it up.
        TestAtomicVariable tav = new TestAtomicVariable();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100 ; i++){
                    tav.increment();
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100 ; i++){
                    tav.increment();
                }
            }
        });
        System.out.println(tav.count);
        t3.start();
        System.out.println(tav.count);
        t4.start();
        System.out.println(tav.count);

        t3.join();
        System.out.println(tav.count);// <=200
        t4.join();
        System.out.println(tav.count);//200

    }


}


class TestAtomicVariable{

    AtomicInteger count = new AtomicInteger();

    public  void increment(){
        count.incrementAndGet();
    }


}

class TestSynchronized{

    private int id ;

    void printNumbers(int n){

        synchronized (this){

            while(n>0){
                System.out.println(Thread.currentThread() + " :: " + n);
                n--;
            }

        }

    }


}

