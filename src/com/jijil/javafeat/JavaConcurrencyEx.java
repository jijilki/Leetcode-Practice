package com.jijil.javafeat;

import java.util.concurrent.*;
import java.util.function.ToIntBiFunction;

//Using Extends Thread
public class JavaConcurrencyEx extends Thread{

    public static void main(String[] args) {

        JavaConcurrencyEx ex = new JavaConcurrencyEx();
        ex.start();
        System.out.println("Back in main thread");
        System.out.println("In main Thread ::" + Thread.currentThread().getName());


    }

    public void run(){
        System.out.println("Run method called from main method using start");
        String name = Thread.currentThread().getName();
        System.out.println("Thread name ::" + name);
        try {
            System.out.println("Sleeping for 5 second");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}


//Impl using Runnable Interface
class JavaConcurrencyEx2 implements Runnable {

    public static void main(String[] args) {
        JavaConcurrencyEx2 ex2 = new JavaConcurrencyEx2();
        Thread t1 = new Thread(ex2);
        t1.start();
        System.out.println("In Main thread , with thread name ::: " + Thread.currentThread().getName());

        Thread t2 = new Thread(ex2);
        t2.start();

        t2.setPriority(10);
    }

    @Override
    public void run() {
        try{

            System.out.println("Inside run method :: with thread name" + Thread.currentThread().getName());
            Thread.sleep(5000);
        }
        catch (InterruptedException ex) {

            System.out.println("Caught Interrupted Exception");
        }

    }
}


class JavaConcurrencyEx3Future  {

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        // Instantiate Callable Class

     /*   ArithmeticExtService sumService = new SumExternalService(args[0], args[1]);
        ArithmeticExtService productService = new ProductExternalService(args[0], args[1]);
*/
        ArithmeticExtService sumService = new SumExternalService("1", "10");
        ArithmeticExtService productService = new ProductExternalService("2", "3");


        // Create Object for Future Task

        FutureTask<Integer> sumExtServiceFutTask = new FutureTask<>(sumService); //Object is something which implements Callable.
        FutureTask<Integer> productExtServiceFutTask = new FutureTask<>(productService);

        //Executor service Object

        Executor executor = Executors.newFixedThreadPool(2);

        // Call using Executor service.

        executor.execute(sumExtServiceFutTask);
        executor.execute(productExtServiceFutTask);



        // Checks for future task completion and further processing

        while (true) {
            if (sumExtServiceFutTask.isDone() && productExtServiceFutTask.isDone()) {
                System.out.println("Completed executor service");
                System.out.println("Sum results :: " + sumExtServiceFutTask.get());
                System.out.println("Product results :: " + productExtServiceFutTask.get());
                return;
            }
            if(sumExtServiceFutTask.isCancelled() || productExtServiceFutTask.isCancelled() ){
                System.out.println("One or more Executor service is cancelled");
            }



        }




    }

}

abstract class ArithmeticExtService implements Callable {

    Integer num1 =0 ;
    Integer num2 = 0;
    public ArithmeticExtService(String arg, String arg1) {
        this.num1 = Integer.parseInt(arg);
        this.num2 = Integer.parseInt(arg1);
    }

}

class SumExternalService extends ArithmeticExtService {


    public SumExternalService(String arg, String arg1) {
        super(arg, arg1);
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(15000);
        return num1+num2;
    }
}

class ProductExternalService extends ArithmeticExtService {


    public ProductExternalService(String arg, String arg1) {
        super(arg, arg1);
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(10000);
        return num1 * num2;
    }
}

class Test implements Runnable {


    public static void main(String[] args) throws InterruptedException {
        //Static Methods
        Thread.sleep(1000); // Put the current Thread to sleep , Thread wont lose monitors
        Thread.yield(); // A hint to the scheduler that the current thread is willing to yield its current use of a processor . Stop currently running
        //..thread and will give chance to other waiting threads of same priority

        //Methods other static methods , act on Object

        // Below lines will throw error IllegalMonitorState Exception
        /*
        Test test = new Test();
        Thread t1 = new Thread(test);
        t1.wait();// Causes current thread to wait indefinitely until notify/ notifyAll called
        t1.wait(1000); // Causes current thread to wait for millsecond , automatically wake up after mentioned millisecond
        t1.notify();//Wakes up single random thread
        t1.notifyAll();//Wakes up all waiting threads waiting on this objects monitor

         */





    }



    @Override
    public void run() {
        System.out.println("Start method called");
    }
}