/**
 * Jake Ma
 * String Permutation II
 * DFS
 * 5/5/2019
 */

public class StringPermutationII {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }
        
        char[] c = str.toCharArray();
        Arrays.sort(c);
        
        boolean[] visited = new boolean[c.length];
        dfs(c, result, "", visited);
        return result;
    }
    
    private void dfs(char[] c, List<String> result, String cur, boolean[] visited) {
        if (cur.length() == c.length) {
            result.add(cur);
            return;
        }
        
        for (int i = 0; i < c.length; i++) {
            if (visited[i] || (i > 0 && c[i] == c[i - 1] && visited[i - 1] == false)) {
                continue;
            }
            
            cur += c[i];
            visited[i] = true;
            dfs(c, result, cur, visited);
            cur = cur.substring(0, cur.length() - 1);
            visited[i] = false;
        }
    }
    
    
}