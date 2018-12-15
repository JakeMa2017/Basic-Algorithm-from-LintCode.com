public class LCR {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {

        int n = A.length();
        int m = B.length();
        if (n == 0 || m == 0) {
            return 0;
        }
        /**
         * results[i][j] means the length of LCR before A.charAt[i] and B.charAt[j].
         * Therefore, we need the length of array to be n + 1 and m + 1.
         */
        int[][] results = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            results[i][0] = 0;
        }
        for (int j = 1; j <= m; j++) {
            results[0][j] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    results[i][j] = results[i - 1][j - 1] + 1;
                } else if (results[i - 1][j] >= results[i][j - 1]) {
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = results[i][j - 1];
                }
            }
        }
        return results[n][m];
    }
}