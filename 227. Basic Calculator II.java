public class Solution {
    public int calculate(String s) {
    // Stack to deal with * and /
        
        Stack <Integer> st = new Stack<>();
        int res = 0;
        char sign = '+';
        int len = s.length();
        if (len == 0) {
            return res;
        }
        int num = 0;
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            if (tmp >= '0' && tmp <= '9') {
                num = num * 10 + tmp - '0';
            } 
            if ((!Character.isDigit(tmp) && tmp != ' ') || i == len - 1) {
                if (sign == '+') {
                    st.push(num);
                } else if (sign == '-') {
                    st.push(-num);
                } else if (sign == '*') {
                    st.push(st.pop() * num);
                } else if (sign == '/'){
                    st.push(st.pop() / num);
                }
                sign = tmp;
                num = 0;
            }
        }
        
        for (int i : st) {
            res += i;
        }
        
        return res;
    }
}
