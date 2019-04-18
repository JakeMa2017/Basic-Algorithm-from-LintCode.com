/**
 * Jake Ma
 * Valid Parentheses
 * Data Structure
 * 4/18/2019
 */

public class ValidParentheses {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() < 1) {
            return false;
        }
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}