class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];

        //if there are only two houses
        //return which is max
        int prev2 = nums[0];
        int prev1 = Math.max(nums[1],nums[0]);

        for(int i=2;i<n ; i++) {
            int curr = Math.max(nums[i]+prev2 , prev1);
             prev2 = prev1;
             prev1 = curr;
        }
        return prev1;
    }
}
