package com.jijil.codility;

import java.util.Arrays;
import java.util.Collections;
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
        int[] arr = {2,6 ,1,3, 4, 5, 7};
        List<int[]> arr1 = List.of(arr);
        System.out.println(result);
        System.out.println(Integer.toBinaryString(15));

        MissingInteger scratch = new MissingInteger();
        System.out.println(scratch.solution2(new int[] {-1,-3}));
        System.out.println(scratch.solution2(new int[] {2,6 ,1,3, 4, 5, 8,1,2,3}));


        System.out.println(scratch.optimalSolution(new int[]{2, 6, 1, 3, 4, 5, 8, 1, 2, 3}));
        System.out.println(scratch.optimalSolution(new int[]{3,2,1}));
        System.out.println(scratch.optimalSolution(new int[]{-2,-1}));

    }

    /**
     * Time complexity O(n), space complexity O(n) , space complexity can be reduced with cyclic search.
     * @param A
     * @return
     */
    private int optimalSolution(int[] A) {

        int length = A.length;
        boolean[] boolArray = new boolean[length + 1];

        // fill true for elements which are in correct positions.
        for (int number : A) {
            if (number > 0 && number <= length) {
                boolArray[number] = true;
            }

        }
        for (int i = 1; i <= length; i++) {
            if (!boolArray[i]) {
                return i;
            }
        }

        return length + 1;
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

        System.out.println(treeSet);
        int counter = 1;
        while(treeSet.contains(counter)){
            counter++ ;
        }

        return counter;
    }




}
