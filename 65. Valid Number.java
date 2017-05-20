public class Solution {
    public boolean isNumber(String s) {
      //state machine
      boolean numseen = false;
      boolean allowE = true;
      boolean point = false;
      boolean Eseen = false;
      s=s.trim();
      for (int i = 0; i < s.length(); i++) {
          char tmp = s.charAt(i);
          if (tmp == '.') {
              if (point || Eseen) {
                return false;
              }
              point = true;
          } else if (tmp == 'e') {
            if (Eseen || !numseen) {
              return false;
            }
            Eseen = true;
            allowE = false;
          } else if (tmp >= '0' && tmp <= '9') {
            numseen = true;
            allowE = true;
          } else if (tmp == '+' || tmp == '-') {
            if (i > 0 && s.charAt(i - 1) != 'e') {
              return false;
            }
          } else {
            return false;
          }
      }
      return allowE && numseen;
    }
}
