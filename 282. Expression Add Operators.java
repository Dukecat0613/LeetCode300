public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= num.length(); i++) {
            String tmp = num.substring(0, i);
            if (tmp.length() > 1 && tmp.startsWith("0")) continue;
            dfs(res, num, 0, i, target, tmp, '*', Long.valueOf(tmp));
        }
        return res;
    }
    public void dfs(List<String> res, String num, long left, int i, int target, String cur, char op, long val) {
        if (val < Integer.MAX_VALUE && (int)val == target && i == num.length()) {
            res.add(cur);
            return;
        }
        if (i >= num.length()) {
            return;
        }
        
        for (int j = i + 1; j <= num.length(); j++) {
            String tmp = num.substring(i, j);
            if (tmp.length() > 1 && tmp.startsWith("0")) continue;
            long curVal = long.valueOf(tmp);
            // +
            dfs(res, num, curVal, j, target, cur + "+" + tmp, '+', val + curVal);
            // -
            dfs(res, num, curVal, j, target, cur + "-" + tmp, '-', val - curVal);
            // *
            if (op == '+') {
                dfs(res, num, left * curVal, j, target, cur + "*" + tmp, '+', val - left + left * curVal);
            } else if (op == '-') {
                dfs(res, num, left * curVal, j, target, cur + "*" + tmp, '-', val + left - left * curVal);
            } else {
                dfs(res, num, left * curVal, j, target, cur + "*" + tmp, '*', val * curVal);
            }
        }
        
    }
}
