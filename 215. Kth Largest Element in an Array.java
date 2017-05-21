public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Very very classical quick select
        return dfs(nums, 0, nums.length - 1, k);
    }
     
    public int dfs(int[] nums, int begin, int end, int k) {
        if (begin > end) {
            return Integer.MIN_VALUE;
        }
        //select pivot, you can use random to generate
        int index = begin;
        int pivot = nums[index];
        swap(nums, index, end);
        for (int i = begin, i < end; i ++){
            if (nums[i] <= pivot) {
                swap(nums, index++, i);
            }
        }
        swap(nums, index, end);
        if (index < k) {
            dfs(nums, index + 1, end, k);
        } else if (index == k) {
            return nums[k];
        } else {
            return dfs(nums, begin, index - 1, k);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        numt[j] = tmp;
    }
}
