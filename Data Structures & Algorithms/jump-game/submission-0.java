class Solution {
    public boolean canJump(int[] nums) {

        //consider solving this problem using greedy approach...
        int max_jumps = 0;
        for(int i=0;i<nums.length;i++) {
            if(i>max_jumps) return false; //for example [1,0,0,1]
            max_jumps  = Math.max(max_jumps, i+nums[i]);
            if(max_jumps >= nums.length-1) return true;
        }
        
        return false;
    }
}
/**
Dry run

nums = [2, 3, 1, 1, 4]

i=0: i(0) <= max_jumps(0) OK -> max_jumps = max(0, 0+2) = 2
i=1: i(1) <= max_jumps(2) OK -> max_jumps = max(2, 1+3) = 4
     max_jumps(4) >= nums.length-1(4) -> return true

Result: true

Failing case — nums = [3, 2, 1, 0, 4]

i=0: max_jumps = max(0, 0+3) = 3
i=1: max_jumps = max(3, 1+2) = 3
i=2: max_jumps = max(3, 2+1) = 3
i=3: max_jumps = max(3, 3+0) = 3   // stuck at index 3, nums[3]=0
i=4: i(4) > max_jumps(3) -> return false
**/
