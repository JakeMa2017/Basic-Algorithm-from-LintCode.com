public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (k == 0 || n == 0 || k > n) {
            return results;
        }
        
        List<Integer> result = new ArrayList<>();
        helper(n, k, results, result, 1);
        return results;
        
    }
    
    private void helper(int n, int k, List<List<Integer>> results, List<Integer> result, int start) {
        if (result.size() == k) {
            results.add(new ArrayList(result));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            result.add(i);
            helper(n, k, results, result, i + 1);
            result.remove(result.size() - 1);
        }
    }
}