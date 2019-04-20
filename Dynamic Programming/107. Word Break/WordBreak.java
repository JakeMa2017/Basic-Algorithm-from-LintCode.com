/**
 * Jake Ma
 * Word Break
 * DP
 * 4/20/2019
 */

public class WordBreak {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
       
       // find the length of the longest word in dictionary
       int maxLength = 0;
       for (String str : dict) {
           maxLength = Math.max(maxLength, str.length());
       }
       
       // there are n + 1 break points in one string, like -h-a-r-d-
       boolean[] canBreak = new boolean[s.length() + 1];
       canBreak[0] = true;
       
       for (int i = 1; i < canBreak.length; i++) {
           for (int j = 1; j <= maxLength && j <= i; j++) {
               // i - j here means the point which starts at j and ends at i
               String cur = s.substring(i - j, i);
               if (dict.contains(cur) && canBreak[i - j]) {
                   canBreak[i] = true;
                   break;
               }
           }
       }
       
       return canBreak[canBreak.length - 1];
    }
}