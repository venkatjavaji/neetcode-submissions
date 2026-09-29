class Solution {
    public int jump(int[] nums) {
        //assuming there will be always a valid answer
        /**
        1 - you jump from the starting positin and it will be jump=1
        2 - if the jumps_so_far = index then increment jump++
        **/

        int max_jumps = 0;
        int jumps_so_far = 0;
        int jump_count = 0;
        for(int i=0; i<nums.length-1;i++) {
            max_jumps = Math.max(max_jumps, i+nums[i]);
            if( i == jumps_so_far) {
                jump_count++;
                jumps_so_far = max_jumps;
            }
        }
        return jump_count;
        
    }
}
