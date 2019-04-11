/**
 * Jake Ma
 * Split String
 * DFS
 * 4/11/2019
 */

public class SplitString {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> results = new ArrayList<>();
        
        if (s == null) {
            return results;
        }
        
        List<String> result = new ArrayList<>();
        dfs(s, result, results);
        
        return results;
    }
    
    private void dfs(String s, List<String> result, List<List<String>> results) {
        if (s.equals("")) {
            results.add(new ArrayList<String>(result));
            return;
        }
        
        for (int i = 1; i <= 2; i++) {
            if (i <= s.length()) { // in case string index out of bound
                result.add(s.substring(0, i));
                dfs(s.substring(i, s.length()), result, results);
                result.remove(result.size() - 1);
            }
        }
    }
}