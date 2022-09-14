import com.jijil.leetcode.LongestPalindrome;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();

        String palindrome = lp.longestPalindrome("malayalam");
        logger.log(Level.INFO, "Longest palindrome in String is {0} " , palindrome);

    }
}