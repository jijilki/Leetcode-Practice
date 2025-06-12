package com.jijil.codility;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CodilitySamples {

    public static void main(String[] args) {
        int[] pairedArray = {9, 3, 9, 3, 9, 7, 9};
        int[] leaderArray = {6,5,6,7,6,3,6};
        int[] stockArray1 = {5,7,3,1,3,4,5};
        int[] stockArray2 = {10,5,4,3};
        // Write a method: public int findUnpaired(int[] A)
        System.out.println(findUnpaired(pairedArray));
        System.out.println(findLeader(leaderArray));
        System.out.println(findLeaderBoyerMooreAlgo(leaderArray));
        System.out.println("max profit :: for "+ Arrays.toString(stockArray1) +"is "  + findMaxProfitFromStock(stockArray1));
        System.out.println("max profit :: for "+ Arrays.toString(stockArray2) +"is "  +findMaxProfitFromStock(stockArray2));
    }

    private static int findMaxProfitFromStock(int[] stockArray) {
        int minValue = Integer.MAX_VALUE;
        int profit = 0;
        for(int price :stockArray){
            //if price < minValue assign it
            if(price < minValue) {
                minValue = price;
            }

            //find max profit
            profit =  Math.max(profit, price -minValue);

        }
        return profit;
    }


    /**
     * A leader is a value that occurs in more than half of the elements, if none exists return -1
     * @param A
     * @return
     */
    private static int findLeader(int[] A) {
        Map<Integer, Long> freqMap = Arrays.stream(A).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        return freqMap.entrySet().stream()
                .filter(e -> e.getValue() > A.length / 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);

    }

    private static int findLeaderBoyerMooreAlgo(int[] A) {
        int candidate = 0;
        int size = 0;
        // Find the possible leader.
        for(int value :A){
            if(size == 0){
                candidate = value;
            }

            if (value == candidate ){
                size++;
            }else {
                size--;
            }
        }

        //verify leader
        int counter = 0;
        for( int value :A){
            if(value == candidate ) {
                counter++;
            }
        }

        //check and return
        return counter > A.length/2 ? candidate : -1;
    }


    //Boyer-Moore Majority Vote Algorithm

    public static int findUnpaired(int[] A){
        int result = 0;
        for(int x : A){
            result ^= x ;
        }
        return result;
    }


}
