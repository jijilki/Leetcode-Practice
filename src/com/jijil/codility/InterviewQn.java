package com.jijil.codility;

import java.util.ArrayList;
import java.util.List;

public class InterviewQn {
    public static void main(String[] args) {
        InterviewQn scratch = new InterviewQn();
        boolean result = scratch.solution("abbbab"); //true
        System.out.println(result);

        int solution = scratch.solution(new int[]{119221});
        System.out.println(solution);


        int wordSplitCount = scratch.solution1("abbcdaaad");
        System.out.println(wordSplitCount);


    }

    /**
     *
     * abba returns false , if there is b beyond last a in String return true else false.
     */
    public boolean solution(String S) {
        // write your code in Java SE 8
        //return (!S.contains("ba")) || S.contains("ab");

        char[] chars = S.toCharArray();
        boolean result;

        if (S.endsWith("b")) {
            result = true;
        } else {
            if (!S.contains("b")) {
                result = true;
            } else if (!S.contains("a")) {
                result = true;
            } else {
                result = false;
            }

        }

        return result;
    }

    /**
     *
     *
     * From given integer array return the max single digit from the list, assuming there is atleast one digit no
     */
    public int solution(int[] A) {

        int maxSingleDigitNumber = -9;
        for (int digit : A) {
            if (Math.abs(digit) < 10 && digit > maxSingleDigitNumber) {
                maxSingleDigitNumber = digit;
            }


        }

        return maxSingleDigitNumber;

    }


    /**
     *
     * if input string is abbcdaaad =>  no repeat elements form seperate String list, eg
     * ab , bcda , a, ad  => return count of it = 4
     */
    public int solution1(String S) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        List<String> strList = new ArrayList<>();
        for ( String str : S.split("")){


            if(sb.indexOf(str) == -1 ){
                sb.append(str);
                System.out.println(sb.toString());
            } else {
                strList.add(sb.toString());
                sb = new StringBuilder();
                sb.append(str);
                System.out.println(sb.toString());
            }



        }
        System.out.println(strList); // This list will not have the final string builder added , hence +1 to get the actual result
        return strList.size()+1;
    }
}

