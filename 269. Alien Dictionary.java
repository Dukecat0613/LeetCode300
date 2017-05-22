public class Solution {
    public String alienOrder(String[] words) {
        // Classic Topological sort
        // Very first we need to do is to get the words priority
        List<List<Character>> access = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            access.add(new ArrayList<>());
        }
        for (int i = 0; i < words.length - 1; i++) {
            String compared = check(words[i], words[i + 1]);
            if (compared.length() == 0) {
                if (words[i].length() > words[i + 1].length()) {
                    return "";
                }
                continue;
            }
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
            // the priority character can access the later char
            char priority = compared.charAt(0);
            char later = compared.charAt(1);
            access.get(priority - 'a').add(later);
            map[later - 'a']++;
        }
        for (int i = 0; i < words[words.length - 1].length(); i++) {
            set.add(words[words.length - 1].charAt(i));
        }
        // topological sort starts, first add the no indegree char
        Queue<Integer> q = new LinkedList<>();
        // total num needs to be sorted
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'a');
            if (map[i] == 0 && set.contains(c)) {
                q.add(i);
                count++;
                res.append(c);
            }
        }
        while(!q.isEmpty()) {
            char c = (char)(q.poll() + 'a');
            List<Character> tmp = access.get(c - 'a');
            int tmpSize = tmp.size();
            for (int i = 0; i < tmpSize; i++) {
                if (map[tmp.get(i) - 'a'] > 0) {
                    map[tmp.get(i) - 'a']--;
                    if (map[tmp.get(i) - 'a'] == 0) {
                        q.add(tmp.get(i) - 'a');
                        count++;
                        res.append(tmp.get(i));
                    }
                }
            }
        }
        if (count == set.size()) {
            return res.toString();
        } else {
            return "";
        }
    }
    
    public String check(String wordA, String wordB) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordA.length() && i < wordB.length(); i++) {
            if (wordA.charAt(i) != wordB.charAt(i)) {
                sb.append(wordA.charAt(i));
                sb.append(wordB.charAt(i));
                break;
            }
        }
        return sb.toString();
    }
}
