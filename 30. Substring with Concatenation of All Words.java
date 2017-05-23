public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    //first store the words frequency
        Map<String, Integer> freMap = new HashMap<>();
        int len = words.length;
        List<Integer> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        int wordLen = words[0].length();
        // frequency
        for (int i = 0; i < words.length; i++) {
            freMap.put(words[i], freMap.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            // count the words num
            int count = 0;
            Map<String, Integer> processMap = new HashMap<>();
            for (int head = i, tail = i; tail + wordLen <= s.length(); tail += wordLen) {
                String word = s.substring(tail, tail + wordLen);
                if (freMap.containsKey(word)) {
                    int curFre = processMap.getOrDefault(word, 0);
                    if (curFre == freMap.get(word)) {
                        // we will need to delete processMap words from head until we are safe to put current word
                        // to our processMap
                        while (processMap.get(word) == curFre) {
                            String headWord = s.substring(head, head + wordLen);
                            processMap.put(headWord, processMap.get(headWord) - 1);
                            count--;
                            head += wordLen;
                        }
                    }
                    processMap.put(word, processMap.getOrDefault(word, 0) + 1);
                    count++;
                    if (count == len) {
                        res.add(head);
                    }
                } else {
                    count = 0;
                    processMap.clear();
                    head = tail + wordLen;
                }
            }
        }
        return res;
    }
}
