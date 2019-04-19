/**
 * Jake Ma
 * Generate Parentheses
 * DFS
 * 4/19/2019
 */

public class GenerateParenthesis {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return result;
        }
        
        dfs(0, 0, n, "");
        return result;
    }
    
    private void dfs(int nleft, int nright, int n, String cur) {
        if (nleft == n && nright == n) {
            result.add(cur);
            return;
        }
        
        if (nleft < n) {
            dfs(nleft + 1, nright, n, cur + "(");
        }
        
        // the number of ) must strictly less than the number of ( at any time
        if (nright < nleft) {
            dfs(nleft, nright + 1, n, cur + ")");
        }

        /**
         * Note Here:
         * Trace back is achieved by cur is not changed.
         * We simply passed a new cur to next recursion. When this recursion is finished, we are still using 
         * the old cur to do next next recursion.
         */
    }
}