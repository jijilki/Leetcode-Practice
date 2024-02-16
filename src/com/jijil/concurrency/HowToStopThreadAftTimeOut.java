package com.jijil.concurrency;

import javax.management.monitor.MonitorSettingException;
import java.sql.Time;
import java.util.concurrent.*;

/**
 * https://www.youtube.com/watch?v=_RSAS-gIjGo&t=10s
 *
 */
public class HowToStopThreadAftTimeOut {


    public static void main(String[] args) {
        HowToStopThreadAftTimeOut obj = new HowToStopThreadAftTimeOut();
        obj.process();
    }

    public  void process() {

        /**USING SCHEDULED EXECUTOR SERVICE TO RUN A TASK WITH DELAY**/

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        task1();
        //Runnable task 2
        Runnable task2 =  ()-> System.out.println("Running task 2:: Printing after 10 seconds!");
        executorService.schedule(task2,10,TimeUnit.SECONDS);

        //Callable task 4
        Callable<Integer> task4 = ()-> {
            System.out.println("Running task 4");
            return 143;
        };
        ScheduledFuture<Integer> future = executorService.schedule(task4, 15, TimeUnit.SECONDS);


        task3();

        //BLOCK and get result

        try {
            Integer returnFromCallable = future.get();
            System.out.println("Returned value from Callable task(After 15 seconds) ::: " + returnFromCallable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }



        // Now stop your task after 10 Seconds using SchedulerExecutor Service.
        MyTask myTask = new MyTask();
        Future<Integer> future2 = executorService.submit(myTask);


        executorService.schedule(()->{
            System.out.println("About to stop My Task");
            //Updating volatile variable as False.
            myTask.keepRunning =false;
            System.out.println("My task stopped");
        },10,TimeUnit.SECONDS);


        //BLOCKING CALL.
        try {
            Integer fut2Out = future2.get();
            System.out.println("Returned value from callable task : My Task :: " + fut2Out) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        // Now stop your task after 20 Seconds using SchedulerExecutor Service.
        MyTask myTask2 = new MyTask();
        Future fut3 = executorService.submit(myTask2);
        try {
            fut3.get(20,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            System.err.println("Time out happened as it exceeds 20 Seconds");
            //fut3.cancel(true);
            myTask2.keepRunning = false;
            /**throw new RuntimeException(e); */
        }


        //Shutting down executor service
        executorService.shutdown();





    }

    class MyTask implements Callable{

        //Volatile variable
       private volatile boolean keepRunning =true;


        @Override
        public Integer call() throws Exception {
            int i= 0;
            while (keepRunning){
                    i++;
                    System.out.println("Printing i value ::: " + i);
                    Thread.sleep(2*1000);
                }


            return i;
        }

    }

    private static void task3() {

        System.out.println("Running task3");
    }

    private static void task1() {
        System.out.println("Running task1");
    }


}


