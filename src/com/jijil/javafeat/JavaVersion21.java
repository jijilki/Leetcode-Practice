package com.jijil.javafeat;

import java.lang.module.FindException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.divideExact;

public class JavaVersion21 {


    public static void main(String[] args) {


        var message = "Hello world , I am Jijil , I am a software engineer";
       /* var messageIndex=  message.indexOf("0", 5,15);
        System.out.println(messageIndex);*/
        //java: no suitable method found for indexOf(java.lang.String,int,int)

        String line = "1;1362;Jijil Kakkadathu;10000";
        String line1 = "1;New York;8 336 817";



        Pattern pattern = Pattern.compile("""
                (?<index>\\d+);\
                (?<empId>\\d+);\
                (?<empName>[ a-zA-Z]+);\
                (?<salary>[ \\d]+)$""");

        Matcher matcher= pattern.matcher(line);
        if(matcher.matches()){
            var index = matcher.group("index");
            var empId = matcher.group("empId");
            var empName = matcher.group("empName");
            var salary = matcher.group("salary");
            System.out.println(index + " :index ");
            System.out.println(empId + " :empId ");
            System.out.println(empName + " :empName ");
            System.out.println(salary + " :salary ");
        }

        var map = HashMap.newHashMap(100);
        var set = HashSet.newHashSet(100);
        var linkedHashMap = LinkedHashMap.newLinkedHashMap(100);
        var linkedHashSet = LinkedHashSet.newLinkedHashSet(100);


        int i = Math.ceilDivExact(10, 3);
        int i1 = divideExact(10, 3);
       // int clamp1 =  Math.clamp(5L, 4, 10);

        System.out.println(i + " " +i1 +" " +
               /* clamp1 +*/
                 "clamp1" );


        Thread t = new Thread();
       // t.isVirtual(); /** use --enable-preview to enable preview APIs */

        //New Ways to create threads
        //Thread.ofPlatform();
        //Thread.ofVirtual();
        /*ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();



        Future<Integer> future= (Future<Integer>) executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });

        Integer integer = future.resultNow();
        future.exceptionNow();
        Future.State state = future.state();*/
    }

        //AutoCloseble method. HttpClient etc are implementing this autoCloseble
    class MyConnection implements AutoCloseable{

        @Override
        public void close() throws Exception {

        }
    }


}
