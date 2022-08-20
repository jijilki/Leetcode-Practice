package pattern;

public class LongestPalindrome {

    public String longestPalindrome(String s) {

        String longestPalendrome = "";
        // System.out.println(s.length());
        //Iterate from 1 to length of the string : For length of SubStr
        for(int i= 1;  i <= s.length() ; i++ ){
            //Iterate from 1 to length - 1 for moving the starting index from Left to right
            for(int j= 0; j <= s.length() -1 ; j++){
                if(j+i  <= s.length()){

                    // Generate string using sub str
                    String subStr = s.substring(j,j+i);
                    //Store in a class variable
                    longestPalendrome= checkPalendrome(subStr)? subStr : longestPalendrome;
                }

            }

        }

        //Longest String will be available in class variable at end of execution
        //System.out.println(longestPalendrome);

        return longestPalendrome;


    }

    private boolean checkPalendrome(String subStr) {

        char[] chars = subStr.toCharArray();
        char[] newChars = new char[chars.length];
        for(int i = 0 ;i< chars.length; i++){

            newChars[i] = chars[chars.length -i -1 ];

        }

        return new String(newChars).equalsIgnoreCase(subStr);

    }

}
