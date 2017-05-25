public class Solution {
    public int strStr(String haystack, String needle) {
        int[] table = KMP(needle);
        int res = 0;
        int index = 0;
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                index++;
                if (index == needle.length()) {
                    return res;
                }
            } else {
                if (index == 0 || i == 0) {
                    res = i + 1;
                } else {
                    index = table[index - 1];
                    if (haystack.charAt(i) == needle.charAt(index)) {
                        res = i - index;
                        index++;
                    } else {
                        index = 0;
                        res = i;
                        i--;
                    }
                    
                }
                
            }
        }
        return -1;
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
