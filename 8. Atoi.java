public class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        int base = 0;
        int sign = 1;
        int i = 0;
        while (i < len && str.charAt(i++) == ' '){}
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : -1;
        } 
        ++i;
        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) >= '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + str.charAt(i) - '0' ;
            i++;
        }
        return sign * base;
    }
}
