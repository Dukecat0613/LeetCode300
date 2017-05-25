public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int len = words.length;
        if (len == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < len; i++) {
            String str = words[i];
            for (int j = 0; j <= str.length(); j++) {
                String prev = str.substring(0, j);
                String post = str.substring(j);
                if (isPalindrome(prev)) {
                    String postReverse = new StringBuilder(post).reverse().toString();
                    if (map.containsKey(postReverse) && map.get(postReverse) != i && prev.length() > 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(map.get(postReverse));
                        tmp.add(i);
                        res.add(new ArrayList<>(tmp));
                    }
                }
                if (isPalindrome(post)) {
                    String prevReverse = new StringBuilder(prev).reverse().toString();
                    if (map.containsKey(prevReverse) && map.get(prevReverse) != i) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(map.get(prevReverse));
                        res.add(new ArrayList<>(tmp));
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
