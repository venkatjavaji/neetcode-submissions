class Solution {
    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0) return -1;

        int current_sum = nums[0];
        int max_sum = nums[0];

        for(int i=1; i<nums.length; i++) {
            current_sum = Math.max(nums[i], current_sum+nums[i]);
            max_sum = Math.max(current_sum,max_sum);
        }
        return max_sum;
    }
}
