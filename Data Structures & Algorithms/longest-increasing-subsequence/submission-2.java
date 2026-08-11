class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] arr = new int[nums.length]; // this array contains lengthOfLIS for every number at its index;
        Arrays.fill(arr,1); //fill all the indexes with 1, defult every number itself is a increasing order

            int maxLen = 1;
        for(int i=1;i<nums.length;i++) {
            //start from index-1 to length of nums
            for(int j=0; j<i; j++) {
                // start from index-0 to the ith index
                //[9,1,4,2,3,3,7]
                if(nums[j]<nums[i]) {
                    //this is the magic :)
                    // assign the memorized or increment the counter
                    arr[i] = Math.max(arr[i], arr[j]+1);
                }
            }
             maxLen = Math.max(arr[i],maxLen);
        }
        return maxLen;
        
    }
}
