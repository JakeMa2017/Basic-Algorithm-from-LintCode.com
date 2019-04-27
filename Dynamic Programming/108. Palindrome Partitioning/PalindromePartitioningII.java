/**
 * Jake Ma
 * Palindrome Partitioning II
 * DP
 * 4/27/2019
 */

public class PalindromePartitioning {
    /**
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        boolean[][] isPalindrome = getPalindrome(s);
        
        // f[i] means the minimum cuts for s.substring[0, i + 1] to be a palindrome
        int[] f = new int[s.length() + 1];
        f[0] = 0;
        for (int i = 1; i < f.length; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        
        return f[s.length()] - 1;
    }
    
    private boolean[][] getPalindrome(String s) {
        // isPalindrome[i][j] means if i...j is a palindrome
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        
        
        isPalindrome[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            // a character is palindrome by itself
            isPalindrome[i][i] = true;
            // if two adjacent character is the same => palindrome
            if (s.charAt(i) == s.charAt(i - 1)) {
                isPalindrome[i - 1][i] = true;
            }
        }
        
        // in between two same character, see if this part is palindrome
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        
        return isPalindrome;
    }
}