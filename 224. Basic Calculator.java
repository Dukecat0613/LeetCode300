public class Solution {
    public int calculate(String s) {
        // stack store the sign 
        // lazy evaluation
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int num = 0;
        int res = 0;
        st.push(sign);
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (Character.isDigit(tmp)) {
                num = num * 10 + tmp - '0';
            } else if (tmp == '+' || tmp == '-') {
                res += num * sign;
                num = 0;
                sign = st.peek() * (tmp == '+' ? 1 : -1);
            } else if (tmp == '(') {
                st.push(sign);
            } else if (tmp == ')') {
                st.pop();
            }
        }
        res += sign * num;
        return res;
    }
}
