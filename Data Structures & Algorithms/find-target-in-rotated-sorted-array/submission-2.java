class Solution {
    public int search(int[] nums, int target) {

        //one half is always sorted.. key is to find which half to search
        int left = 0;
        int right = nums.length-1;

        
//[1,2,3,4,5,6]
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            //left is sorted
            if(nums[left] <= nums[mid]) {
                if( target>=nums[left] && target<nums[mid]) {
                    //number is in the left sorted array
                   // [1,2,3] - 2
                    right = mid-1;
                } else {
                    //number is in the right sorted array
                    left = mid+1;
                }
            } else {
                if(target>nums[mid] && target<=nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
