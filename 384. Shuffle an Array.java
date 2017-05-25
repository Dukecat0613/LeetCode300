public class Solution {
    int[] array;
    Random rand;
    public Solution(int[] nums) {
        this.array = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = array.clone();
        for (int i = 1; i <= temp.length; i++) {
            int random = rand.nextInt(i);
            if (random != i - 1) {
                swap(temp,i-1,random);
            }
        }
        return  temp;
    }
    
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
