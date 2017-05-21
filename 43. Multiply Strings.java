public class Solution {
    public String multiply(String num1, String num2) {
    // Remember the multipy method when we were in primary school
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[m + n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                sum += res[i + j + 1];
                res[i + j] += sum / 10;
                res[i + j + 1] += sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (sb.length() == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
