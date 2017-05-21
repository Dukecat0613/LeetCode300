public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len == 0) {
            return true;
        }
        
        for (int i = 1; i <= len/2; i++) {
            String strPrev = num.substring(0, i);
            if (strPrev.length() > 1 && strPrev.startsWith("0")) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                String strPost = num.substring(i, j);
                if (strPost.length() > 1 && strPost.startsWith("0")) {
                    continue;
                }
                if (dfs(num.substring(j), Long.valueOf(strPrev), Long.valueOf(strPost))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(String str, long prev, long post) {
        if (str.length() == 0) {
            return true;
        }
        if (str.startsWith(String.valueOf(prev + post))) {
            return dfs(str.substring(String.valueOf(prev + post).length()), post, prev + post);
        }
        return false;
    
    }
}
