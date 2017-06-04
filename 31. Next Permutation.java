public class Solution {
    public void nextPermutation(int[] nums) {
    // The idea is pretty simple, scan from right to left
    // find the first element that breaking the increasing trend 
    // and find the first element that greater than the breaking item
    // swap them and reverse the rest part
        int len = nums.length;
        int i = len - 2;
        for (; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                break;
            }
        }
        
        int r = len - 1;
        if (i >= 0) {
            for (; r >= 0; r--) {
                if (nums[r] > nums[i]) {
                    break;
                }
            }
            swap(nums, r, i);
        }
        i++;
        r = len - 1;
        while (i < r) {
            swap(nums, i++, r--);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
