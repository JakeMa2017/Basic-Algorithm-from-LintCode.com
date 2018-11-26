/**
 * Valid Palindrome II
 * Two Pointers
 * Jake Ma
 * 11-25-2018
 */
public class ValidPalindromeII {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindromeII(String s) {
        if (s.length() == 0 || s == null) {
            return false;
        }
        
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }

            return isPalin(s, left + 1, right) || isPalin(s, left, right - 1);
        }
        
        return true;
    }
    
    private boolean isPalin(String s, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}