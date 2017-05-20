public class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0);
    }
    public boolean dfs(String s, String p, int i, int j) {
        if (i == s.length() || j == p.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                return dfs(s, p, i, j + 2);
            }
            return i == s.length() && j == p.length();
        }
      
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                return dfs(s, p, i, j + 2) || dfs(s, p, i + 1, j);
            } else {
                return dfs(s, p, i, j + 2);
            }
        } else {
            if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                return dfs(s, p, i + 1, j + 1);
            } 
        }
        return false;
    }
}
