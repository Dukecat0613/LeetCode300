public class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        String temp = s + "*" + new StringBuilder(s).reverse().toString();
        int table = KMP(s);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    
    }
    
    public int[] KMP(String s) {
        int len = s.length();
        int[] res = new int[len];
        int i = 0;
        int j = 0;
        while (i < len - 1) {
            i++;
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                res[i] = j;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = res[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                    res[i] = j;
                }
            }
        }
        return res;
    }
}
