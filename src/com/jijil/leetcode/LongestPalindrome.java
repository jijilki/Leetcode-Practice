package com.jijil.leetcode;

 class LongestPalindrome1 {

    public String longestPalindrome(String s) {

        String longestPalindrome = "";
        exit  :
        for(int i= s.length();  i >= 0 ; i-- ){
            //Iterate from 1 to length - 1 for moving the starting index from Left to right
            for(int j= s.length()-1; j >= 0 ; j--){
                if(j+i  <= s.length()){

                    // Generate string using sub str
                    String subStr = s.substring(j,j+i);
                    if(checkPalindrome((subStr))){
                        longestPalindrome =subStr;
                        break exit;
                    }
                }

            }

        }

        return longestPalindrome;


    }

    private boolean checkPalindrome(String subStr) {


        char[] chars = subStr.toCharArray();
        char[] newChars = new char[chars.length];
        for(int i = 0 ;i< chars.length; i++){

            newChars[i] = chars[chars.length -i -1 ];

        }

        return new String(newChars).equalsIgnoreCase(subStr);

    }

}


public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                System.out.println(s.substring(start, end +1));
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}