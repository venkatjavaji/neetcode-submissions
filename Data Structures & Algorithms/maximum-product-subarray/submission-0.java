class Solution {
    public int maxProduct(int[] nums) {

        int leftp = 1;
        int rightp = 1;
        int ans = nums[0];

        for(int i=0;i<nums.length; i++) {

            leftp = (leftp == 0 || leftp < Integer.MIN_VALUE) ? 1 : leftp;
            rightp = (rightp ==0 || rightp < Integer.MIN_VALUE) ? 1 : rightp;

            leftp = nums[i]*leftp;
            rightp = nums[nums.length-1-i]* rightp;

            ans = Math.max(ans, Math.max(leftp,rightp));
        }
        return ans;
    }
}
