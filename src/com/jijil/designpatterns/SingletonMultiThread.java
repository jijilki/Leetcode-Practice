package com.jijil.designpatterns;

import java.util.logging.Logger;

public class SingletonMultiThread {

    //Static Class variable
    //Make it volatile =  The volatile keyword now ensures that multiple threads handle the singleton instance correctly.
    private static volatile  SingletonMultiThread instance ;

    public String value;


    //private constructor
    private SingletonMultiThread(String value) {

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.value = value;


    }

    //Static method to get Instance of object. Returns existing instance if any
    public static SingletonMultiThread getInstance(String val){
        //For Double Check lock introducing this local variable
        SingletonMultiThread result = instance;
        if(result != null) {
            return result;
        }

        synchronized (SingletonMultiThread.class){
            if(instance == null ){
                instance= new  SingletonMultiThread(val);
            }
            return instance;
        }

    }


}

class TestClient1 {

    static Logger logger = Logger.getLogger(TestClient.class.getName());

    public static void main(String[] args) {



        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonMultiThread singleton = SingletonMultiThread.getInstance("Foo");

                logger.info("Value is ::" + singleton.value);
            }
        });
        t1.setName("Thread-1");



        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonMultiThread anotherSingleton = SingletonMultiThread.getInstance("Boo");

                logger.info("Value is ::" + anotherSingleton.value);
            }
        });
        t2.setName("Thread-2");


        t1.start();
        t2.start();


    }

}