class Solution {
    public int search(int[] nums, int target) {

        int len = nums.length;
        int left = 0;
        int right = len-1;

        int result = -1;
        while(left<=right) {
            int mid = (left + right)/2;

            System.out.println("mid: "+mid);

            if(nums[mid] == target) {
                result = mid;
                break;
            } else if(nums[mid] < target) {
                    left = mid+1;
                    System.out.println("left: "+left);
            } else {
                right = mid-1;
                 System.out.println("right: "+right);
            }
        }
        return result;
        
    }
}
