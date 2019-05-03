public class LetterCombinationsOfAPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    private String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0 || digits == null) {
            return result;
        }
        
        dfs(0, digits.length(), "", digits, result);
        return result;
    }
    
    private void dfs(int start, int length, String cur, String digits, List<String> result) {
        if (start == length) {
            result.add(cur);
            return;
        }
        
        int index = digits.charAt(start) - '0';
        
        for (char c : phone[index].toCharArray()) {
            dfs(start + 1, length, cur + c, digits, result);
        }
    }
}