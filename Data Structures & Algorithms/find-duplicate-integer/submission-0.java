class Solution {
    public int findDuplicate(int[] nums) {

        int[] result = new int[nums.length];

        for(int n : nums) {

            if(result[n] == -1) {
                return n;
            }

            result[n] = -1;
        }
        
        return -1;
    }
}
