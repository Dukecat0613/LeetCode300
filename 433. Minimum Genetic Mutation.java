public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        // Almost exactly same as word ladder.
        Set<String> set = new HashSet<>();
        int len = bank.length;
        if (len == 0) return -1;
        for (int i = 0; i < len; i++) {
            set.add(bank[i]);
        }
        if (!set.contains(end)) return -1;
        char[] genes = new char[]{'A', 'G', 'T', 'C'};
        // bfs
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited=new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(start, 0);
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            if (tmp.equals(end)) break;
            for (int i = 0; i < tmp.length(); i++) {
                StringBuilder sb = new StringBuilder(tmp);
                for (int j = 0; j < 4; j++) {
                    if (genes[j] == tmp.charAt(i)) continue;
                    sb.setCharAt(i, genes[j]);
                    String changeTmp = sb.toString();
                    if (set.contains(changeTmp) && !visited.contains(changeTmp)) {
                        queue.offer(changeTmp);
                        visited.add(changeTmp);
                        if (map.containsKey(changeTmp)) {
                            map.put(changeTmp, Math.min(map.get(changeTmp), map.get(tmp) + 1));
                        } else {
                            map.put(changeTmp, map.get(tmp) + 1);
                        }
                    }
                }
            }
        }
        if (!map.containsKey(end)) {
            return -1;
        } else {
            return map.get(end);
        }
    }
}
