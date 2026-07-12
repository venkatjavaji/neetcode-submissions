class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int lc = 0;
        int rc = numbers.length-1;
        while(lc<rc) {
            int sum = numbers[lc] + numbers[rc];
            if(sum == target) {
                return new int[]{lc+1, rc+1};
            } else if(sum>target) {
                rc--;
            } else {
                lc++;
            }
        }
        return new int[]{};
        
    }
}
