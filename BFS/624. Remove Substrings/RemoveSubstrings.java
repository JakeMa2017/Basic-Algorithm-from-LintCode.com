/**
 * Jake Ma
 * Remove Substrings
 * BFS
 * 4/4/2019
 */

public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return s.length();
        }
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> hash = new HashSet<>();
        int min = s.length();
        
        queue.offer(s);
        hash.add(s);
        
        while(!queue.isEmpty()) {
            String str = queue.poll();
            for (String sub : dict) {
                int found = str.indexOf(sub); // get the index of first substring
                
                while (found != -1) {
                    String newStr = str.substring(0, found) + str.substring(found + sub.length(), str.length());

                    if (!hash.contains(newStr)) {
                        if (newStr.length() < min) {
                            min = newStr.length();
                            if (min == 0) {
                                return 0;
                            }
                        }
                        
                        hash.add(newStr);
                        queue.offer(newStr);
                    }
                    found = str.indexOf(sub, found + 1);
                }
            }
        }
        
        return min;
    }
}