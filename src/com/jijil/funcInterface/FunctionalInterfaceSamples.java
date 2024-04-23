package com.jijil.funcInterface;

import java.security.Provider;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

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

        // ComputeIfAbsent method in Hashmap is example of Function
        Map<String ,Integer> hashMap = new HashMap<>();
        Integer length = hashMap.computeIfAbsent("Jijil", x -> x.length());
        System.out.println(hashMap.get("Jijil") + " " +length);

        //Two arguments - BiFunction
        BiFunction<Integer,Integer,Integer> addAndMul = (x,y)-> x * 10 + y + 5;

        System.out.println(addAndMul.apply(2,3)); // 2 *10 + 3+5 =28

        //Supplier and Consumer

        Supplier<Double> randomSupplier = ()-> Math.random() * 2;
        System.out.println(randomSupplier.get());

        Consumer<String> printStringWithFirstLetterCaps = x-> System.out.println(x.toUpperCase().charAt(0)+x.substring(1,x.length()));
        printStringWithFirstLetterCaps.accept("stackoverflow");


        BiConsumer<String , Integer> printNameAndLength= (name,nameLength) -> System.out.println(name + " is of " + nameLength + " name length ") ;

        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.computeIfAbsent("Roland Regan" , x-> x.length());
        ageMap.computeIfAbsent("Bill Clinton" , x-> x.length());
        ageMap.computeIfAbsent("Narendra Modi" , x-> x.length());
        ageMap.computeIfAbsent("AK Gujral" , x-> x.length());
        ageMap.forEach(printNameAndLength);
        ageMap.forEach((name, nameLength) -> System.out.println("Length of Name of " + name + "is " + nameLength));

        Predicate<Integer> isPositive = x-> x > 0;
        System.out.println(13 + " is a positive number "  + isPositive.test(13));

        // BiPredicate


        BinaryOperator<Integer> binaryOperator = (x,y) -> x+y;
        System.out.println(binaryOperator.apply(10,3));


        /** Identify duplicate from list.*/
        List<Integer> listInteger = Arrays.asList(112,111,118,112,210,118,210);
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> dupElements = listInteger.stream().filter(x -> !hashSet.add(x)).collect(Collectors.toList());
        System.out.println(dupElements);

        /** Make a map with count of occurrence in list */

        Map<Integer, Long> countMap = listInteger.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap);

        /** Print the second-largest Number */
            //Remove duplicates
        Integer secondLargest = listInteger.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).max(Comparator.naturalOrder()).get();
            //Use findFirst
        Integer secondLargest1 = listInteger.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Second largest number ::  " + secondLargest +"  " + secondLargest1);


        //Flat map :: Filter names with J. List<List<String>>

        List<List<String>> name = Arrays.asList(Arrays.asList("John", "Martin"), Arrays.asList("Ram", "Seth"), Arrays.asList("Jack", "Wills"), Arrays.asList("Joe", "Dawn"));


        List<String> j = name.stream().flatMap(x -> x.stream()).filter(x -> x.startsWith("J")).collect(Collectors.toList());
        List<String> j1 = name.stream().flatMap(List::stream).filter(x -> x.startsWith("J")).collect(Collectors.toList());

    }


}
