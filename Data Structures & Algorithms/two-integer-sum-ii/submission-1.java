class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length;
        int left = 0;
        while(left < right) {
            int sum = numbers[left] + numbers[right-1];
            if(sum == target) {
                return new int[]{left+1,right};
            } else if( sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
