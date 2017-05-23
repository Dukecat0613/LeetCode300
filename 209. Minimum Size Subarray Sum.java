public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //nlgn treemap
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, i);
            Integer floor = map.floorKey(sum - s);
            if (floor != null) {
                min = Math.min(min, i - map.get(floor));
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
