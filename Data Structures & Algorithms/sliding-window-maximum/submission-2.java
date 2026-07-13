class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] result = new int[nums.length-k+1];
//this takes n*m time-complexity.. need to work on the optimization!!
        for(int right=0;right<=nums.length-k;right++) {
            int left = right;
            int leftMax = right + (k-1);
            int max = Integer.MIN_VALUE;
            while(left<=leftMax) {
                max = Math.max(nums[left], max);
                left++;
            }
            System.out.println("left :"+ left + " leftMax : "+leftMax +" max : "+max);
            result[right] = max;
        }
        return result;
    }
}
