/**
 * Valid Palindrome
 * Two Pointers
 * Jake Ma
 * 11-20-2018
 */

public class ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (!isValid(s.charAt(left)) && left < right) {
                left++;
            }
            while (!isValid(s.charAt(right)) && left < right) {
                right--;
            }
            
            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}