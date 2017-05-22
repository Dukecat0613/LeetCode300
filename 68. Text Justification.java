public class Solution {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        // Greedy algorithms, try to fill as many as white spaces in the front words.
        int begin = 0;
        int len = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (i - begin + len + words[i].length() > maxWidth) {
                res.add(connect(words, begin, i - 1, len, maxWidth, false));
                len = 0;
                begin = i;
            }
            len += words[i].length();
        }
        res.add(connect(words, begin, words.length - 1, len, maxWidth, true));
        return res;
    }
    public static String connect(String[] words, int start, int end, int len, int maxWidth, boolean last){
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            addSpaces(sb, i - start, end - start, maxWidth - len, last);
        }
        int remain = maxWidth - sb.length();
        for (int j = 0; j < remain; j++) {
            sb.append(' ');
        }
        return sb.toString();
    }
    
    public static void addSpaces(StringBuilder sb, int start, int numWhite, int whiteLen, boolean last) {
        // if start index == numWhite, no extra whitespaces needed
        if (numWhite == 0 || start > numWhite - 1) return;
        int n = last ? 1 : (whiteLen / numWhite + (start < whiteLen % numWhite ? 1 : 0));
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
    }
    
}
