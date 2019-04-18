public class FindTheMissingNumberII {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    private int result = -1;
    public int findMissing2(int n, String str) {
        boolean[] isFound = new boolean[n + 1];
        dfs(n, str, 0, isFound);
        return result;
    }
    
    private void dfs(int n, String str, int start, boolean[] isFound) {
        // found the answer
        if (result != -1) {
            return;
        }
        
        // end stage
        if (start == str.length()) {
            for (int i = 1; i < isFound.length; i++) {
                if (isFound[i] == false) {
                    result = i;
                    return;
                }
            }
        }
        
        // skip unnecessary steps
        if (str.charAt(start) == '0') {
            return;
        }
        
        // main stage
        for (int ch = 1; ch <= 2 && start + ch <= str.length(); ch++) {
            int num = Integer.parseInt(str.substring(start, start + ch));
            
            if (num <= n && !isFound[num]) {
                isFound[num] = true;
                dfs(n, str, start + ch, isFound);
                isFound[num] = false;
            }
        }
    }
}