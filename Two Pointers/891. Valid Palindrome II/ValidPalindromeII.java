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
            if (left + 1 <= right && s.charAt(left + 1) == s.charAt(right)) {
                return isPar(s, ++left, right);
            } else if (right  - 1 >= left && s.charAt(right - 1) == s.charAt(left)) {
                return isPar(s, left, --right);
            }
        }
        
        return true;
    }
    
    private boolean isPar(String s, int start, int end) {
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