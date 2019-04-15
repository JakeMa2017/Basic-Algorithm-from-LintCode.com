public class Factorization {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (n <= 0 || n == 1) {
            return results;
        }
        
        List<Integer> result = new ArrayList();
        helper(n, results, result, 2);
        return results;
        
    }
    
    private void helper(int n, List<List<Integer>> results, List<Integer> result, int start) {
        if (n <= 1) {
            if (result.size() > 1) {
                results.add(new ArrayList<Integer>(result));
            }
            return;
        }
        
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result.add(i);
                helper(n / i, results, result, i);
                result.remove(result.size() - 1);
            }
        }
        
        /**
         * If the last factor is greater than Math.sqrt(n), this step can add that factor to result.
         * However, if n is a prime number this also add n itself to result.
         * At line 21, we only add result list to results when there are two factors. So result list
         * with only itself will not be added to results list.
         */
        if (n >= start) {
            result.add(n);
            helper(1, results, result, n);
            result.remove(result.size() - 1);
        }
    }
}