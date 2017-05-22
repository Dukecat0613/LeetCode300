public class Solution {
    public int longestValidParentheses(String s) {
        // Stack
        Stack<Integer> st = new Stack<>();
        int left = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else {
                if (st.isEmpty()) {
                    left = i;
                } else {
                    st.pop();
                    if (st.isEmpty()) {
                        // perferct situation
                        max = Math.max(max, i - left);
                    } else {
                        // if stack is not empty, we should calculate the current valid length
                        max = Math.max(max, i - st.peek());
                    }
                }
            }
        }
        return max;
    }
}
