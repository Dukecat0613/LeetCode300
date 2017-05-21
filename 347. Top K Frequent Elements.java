public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        int max = 1;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(map.get(nums[i]), max);
        }
        List<List<Integer>> freArray = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            freArray.add(new ArrayList<Integer>());
        }
        
        for (int n : map.keySet()) {
            freArray.get(map.get(n)).add(n);
        }
        
        for (int i = freArray.size() - 1; i >=0 && res.size() < k; i--) {
            List<Integer> tmp = freArray.get(i);
            if (res.size() + tmp.size() <= k) {
                res.addAll(tmp);
            } else {
                int j = 0;
                while (res.size() < k) {
                    res.add(tmp.get(j++));
                }
                return res;
            }
        }
        return res;
    }
}
