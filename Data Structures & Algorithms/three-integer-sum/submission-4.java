class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length<3) return result;
        Arrays.sort(nums);

        for(int i=0; i< nums.length-2; i++) {
            int lc = i+1; //start element
            int rc = nums.length-1; //end element
            if(i>0 && nums[i-1]== nums[i]) continue;
            while(lc<rc) {
                int sum = nums[i] + nums[lc] + nums[rc];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lc], nums[rc]));
                    while(lc<rc && nums[lc+1] == nums[lc]) lc++;

                    while(lc<rc && nums[rc-1] == nums[rc]) rc--;
                    lc++;
                    rc--;
                } else if(sum>0) {
                    rc--;
                } else {
                    lc++;
                }
            }
        }
        return result;
    }
}
