class Solution {
    public boolean canJump(int[] nums) {

        int max_jump = 0;
        for(int i=0; i<nums.length;i++) {
            if(i>max_jump) return false; //early exit..
            max_jump = Math.max(max_jump, i+nums[i]);
            if(max_jump>=nums.length-1) return true;
        }
        return false;
    }
}

/** 

Failing case — nums = [3, 2, 1, 0, 4]
there are 5 steps and array is 0-index so, +index with the number of steps he can take and compare with max_jumps..

when i=0, you can jump 0+3 = 3 to the third index
when i=1, you can jump 1+2 = 3 to the third index
when i=2, you can jump 2+1 =3 to the 3rd index
when i=3, you can jump 3+0 = 3 on the same step cant go beyond

For an instance if the steps are [3,2,1,0,4]
then when i=3, you can jump 3+1=4 that is the last index

**/