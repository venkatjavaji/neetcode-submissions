class Solution {
    public int[] getConcatenation(int[] nums) {

        int[] newnums = new int[2*nums.length];
        for(int i=0;i< nums.length; i++) {
            newnums[i] = nums[i];
            newnums[nums.length+i] = nums[i];
        }
        return newnums;
        
    }
}