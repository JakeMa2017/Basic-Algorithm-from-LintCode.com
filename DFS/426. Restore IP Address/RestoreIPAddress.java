/**
 * Jake Ma
 * Restore IP Address
 * DFS
 * 4/18/2019
 */

public class RestoreIpAddress {
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        
        if (s == null || s.length() < 4 || s.length() > 12) {
            return results;
        }
        
        List<String> ip = new ArrayList<>();
        dfs(s, 0, results, ip);
        return results;
        
    }
    
    private void dfs(String s, int start, List<String> results, List<String> ip) {
        // exit when ip is built
        if (ip.size() == 4) {
            if (start != s.length()) {
                return;
            }
            
            StringBuilder sb = new StringBuilder();
            for (String str : ip) {
                sb.append(str);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            results.add(sb.toString());
            return;
        }
        
        for (int i = start; i < s.length() && i < start + 3; i++) {
            String temp = s.substring(start, i + 1);
            if (isValid(temp)) {
                ip.add(temp);
                dfs(s, i + 1, results, ip);
                ip.remove(ip.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        // eliminate cases like "01"
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        
        int n = Integer.valueOf(s);
        return n >= 0 && n <= 255;
    }
}