/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     int offset = 0;
     int len = 0;
     char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int i = 0;
        while(i < n) {
            if (offset == len) {
                offset = 0;
                len = read4(buffer);
                if (len == 0) {
                    break;
                }
            }
            buf[i++]  = buffer[offset++];
        }
        return i;
    }
}
