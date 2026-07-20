class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

       
        int nums1len = nums1.length;
        int nums2len = nums2.length;
        // if(nums1==null || nums1len == 0 || nums2== null || nums2len == 0) {
        //     return 0;
        // }
        //perform binarySearch on smaller array.. iterations would be smaller
        if(nums1len>nums2len) return findMedianSortedArrays(nums2,nums1);

        int totallen = nums1len + nums2len;

        int left=0; int right = nums1len;

        while(left<=right) {
            //assume totallen=11 and nums1.len = 5 and num2.len = 6
            int nums1partition = left + (right-left)/2; //2
            int nums2partition = (totallen + 1)/2 - nums1partition; //6-3 = 4

            int nums1left = (nums1partition == 0)?Integer.MIN_VALUE : nums1[nums1partition-1];
            int nums1right = (nums1partition == nums1.length)? Integer.MAX_VALUE :nums1[nums1partition];
            int nums2left = (nums2partition == 0)?Integer.MIN_VALUE : nums2[nums2partition-1];
            int nums2right = (nums2partition == nums2.length)? Integer.MAX_VALUE :nums2[nums2partition];

            if(nums1left <= nums2right && nums2left<=nums1right) {
                //correct partition found
                if((nums1len+nums2len)%2 == 1) {
                    return Math.max(nums1left,nums2left); //this is for ODD
                } else {
                    return (Math.max(nums1left,nums2left)+ Math.min(nums1right, nums2right))/2.0; //this is for even
                }
            } else if(nums1left>nums2right){
                right = nums1partition-1;
            } else {
                left = nums1partition+1;
            }
        }
        return 0;
    }
}
