package com.jijil.funcInterface;

import java.util.function.Function;

public class FunctionalInterfaceSamples {

    public static void main(String[] args) {

        //Functions - apply , compose and andThen examples

        Function<Integer,Integer> addThree = x -> x +3 ;
        Function<Integer,Integer> mulWithTen = x -> x * 10 ;
        Function<Integer,Double>  makeToDouble = x-> (double) x;

        Function<Integer, Integer>  mulTenAndAddThree= addThree.compose(mulWithTen);
        Function<Integer, Integer>  addThreeAndMulTen= addThree.andThen(mulWithTen);


        System.out.println(mulTenAndAddThree.apply(5)); // 5*10 ; + 3 = 53
        System.out.println(addThreeAndMulTen.apply(5)); // 5+3 ; *10 = 80


    }


}
