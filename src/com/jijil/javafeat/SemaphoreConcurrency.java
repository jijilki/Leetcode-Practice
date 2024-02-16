package com.jijil.javafeat;

import java.util.concurrent.*;
import java.util.stream.IntStream;


//Incomplete
public class SemaphoreConcurrency {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        Semaphore semaphore = new Semaphore(3);


        IntStream.of(1000).forEach(i-> executorService.execute(new Task(semaphore)));

        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.MINUTES);


    }
}


class Task implements Runnable{

    Semaphore semaphore;
    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run(){
        
        semaphore.acquireUninterruptibly();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
        semaphore.release();

    }
}