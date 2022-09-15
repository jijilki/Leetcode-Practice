package com.jijil.codility;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
* From given array , return the least missing integer from it
* eg : {2,6 ,1,3, 4, 5, 7} answer is 8
* {2,6 ,1,3, 4, 5, 8} answer is 7
* */
public class MissingInteger {

    public static void main(String[] args) {
        int result = solution1(new int[]{2,6 ,1,3, 4, 5, 7});
        System.out.println(result);
        System.out.println(Integer.toBinaryString(15));

        MissingInteger scratch = new MissingInteger();
        System.out.println(scratch.solution2(new int[] {-1,-3}));

    }

    //Missing Integer
    public static int solution1(int[] A){
        int result = 1;
        List<Integer> sortedList = IntStream.of(A).sorted().boxed().collect(Collectors.toList());




        Integer largestNum = sortedList.get(sortedList.size() - 1);
        // System.out.println("Largest Number in Array is " + largestNum);
        if(largestNum > 0) {
            for (int counter = 1; counter < largestNum; counter++) {

                if (!sortedList.contains(counter)) {
                    return counter;

                }

            }
        }
        else {
            largestNum = 0;
        }
        return largestNum+1;
    }


    public static int solution2(int[] A) {

        TreeSet<Integer> treeSet = IntStream.of(A).boxed().collect(Collectors.toCollection(TreeSet::new));

        int counter = 1;
        while(treeSet.contains(counter)){
            counter++ ;
        }

        return counter;
    }




}
