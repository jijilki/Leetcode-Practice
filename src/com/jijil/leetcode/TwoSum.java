package com.jijil.leetcode;
//https://leetcode.com/problems/two-sum
public class TwoSum {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] ints = solution1.twoSum(new int[]{3,2,4  }, 6);
        System.out.println(ints[0] + "," + ints[1]);
    }
}


class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        int[] targetArr = new int[2];

        xxx:for(int i = 0;  i < nums.length ;  i ++) {
            for (int j= 0;j < nums.length ; j++){
                System.out.println(i + " : "+ j);
                if(i!=j && nums[i] + nums[j] == target){
                    targetArr[0] = i;
                    targetArr[1] = j;
                    break xxx;
                }

            }
        }

        return targetArr;


    }
}