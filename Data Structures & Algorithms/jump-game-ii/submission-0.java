class Solution {
    public int jump(int[] nums) {

        int jumps_so_far = 0;
        int max_jumps = 0;
        int jump_count =0 ;

        for(int i=0;i<nums.length-1;i++) {
            max_jumps = Math.max(max_jumps, i+nums[i]);
            //everytime match with the jumps made so far increment the jump_count
            if(i == jumps_so_far) {
                jump_count++;
                jumps_so_far = max_jumps;
            }
        }
        return jump_count;
        
    }
}

/**

Dry run

nums = [2, 3, 1, 1, 4]

i=0: max_jumps = max(0, 0+2) = 2
     i(0) == jumps_so_far(0) -> jump_count=1, jumps_so_far=2

i=1: max_jumps = max(2, 1+3) = 4
     i(1) != jumps_so_far(2) -> no jump yet

i=2: max_jumps = max(4, 2+1) = 4
     i(2) == jumps_so_far(2) -> jump_count=2, jumps_so_far=4

i=3: max_jumps = max(4, 3+1) = 4
     i(3) != jumps_so_far(4) -> no jump

loop ends at i=3 (nums.length-1 = 4, loop runs i < 4)

Result: jump_count = 2 -> e.g. 0 -> 1 -> 4 (index 0 jumps to index 1, index 1 jumps to index 4).
**/
