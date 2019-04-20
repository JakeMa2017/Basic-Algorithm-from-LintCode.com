/**
 * Jake Ma
 * Word Break III
 * DP
 * 4/20/2019
 */

public class WordBreakIII {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        if (s.length() == 0 || s == null || dict.size() == 0 || dict == null) {
            return 0;
        }
        s = s.toLowerCase();
        Set<String> set = new HashSet<>();
        for (String str : dict) {
            set.add(str.toLowerCase());
        }
        
        int strLen = s.length();
        int[] count = new int[strLen + 1];
        count[strLen] = 1;
        
        for (int i = strLen - 1; i >= 0; i--) {
            for (int j = i + 1; j <= strLen; j++) {
                String cur = s.substring(i, j);
                
                if (set.contains(cur)) {
                    count[i] += count[j];
                }
            }
        }
        
        return count[0];
    }
}