public class PalindromePartitioning {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        List<String> cur = new ArrayList<>();
        dfs(s, 0, cur, result);
        
        return result;
    }
    
    private void dfs(String s, int start, List<String> cur, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(cur));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                cur.add(sub);
                dfs(s, i + 1, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true; 
    }
}