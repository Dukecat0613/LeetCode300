public class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }
    
    public int merge(int[] nums, int begin, int end) {
        if (begin >= end) {
            return 0;
        }
        
        int mid = (begin + end) >>> 1;
        int i = begin;
        int j = mid + 1;
        int count = merge(nums, begin, mid) + merge(nums, mid + 1, end);
        for (; i <= mid; i++) {
            while (j <= end && (long)nums[i] > 2* (long)nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        Arrays.sort(nums, begin, end + 1);
        return count;
    }
}
