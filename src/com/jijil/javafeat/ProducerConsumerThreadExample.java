package com.jijil.javafeat;

import java.util.LinkedList;

public class ProducerConsumerThreadExample {

    LinkedList<Double> list = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {

        ProducerConsumerThreadExample sce = new ProducerConsumerThreadExample();
        Thread producerT = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sce.producerMethod();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "ProducerThread");


        Thread consumerT = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    sce.consumerMethod();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "ConsumerThread");


        producerT.start();
        consumerT.start();

        /*producerT.join(10000);
        consumerT.join(10000);*/


       // System.out.println(Thread.currentThread().getName() + " ::  Main thread");


    }

    public void producerMethod() throws InterruptedException {

        int capacity = 10;

        while (true) {
            synchronized (this) {
                while (list.size() == capacity) {
                    wait();
                }
                Double d = Math.random();
                System.out.println(Thread.currentThread().getName() + " :: Producer  produced : " + d);
                list.add(d);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consumerMethod() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                Double e = list.removeFirst();
                System.out.println(Thread.currentThread().getName() + " :: Consumer Consumed : " + e);


            }
        }
    }


}
