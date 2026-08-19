class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for(int i : nums) {
            result ^= i;
        }
        return result;
        
    }
}

/**

Dry run with [4, 1, 2, 1, 2]:

result = 0
0 ^ 4 = 4
4 ^ 1 = 5
5 ^ 2 = 7
7 ^ 1 = 6
6 ^ 2 = 4
**/
