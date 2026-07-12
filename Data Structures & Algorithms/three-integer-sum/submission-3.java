class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums); //sort the array
        //iterate until the last-2 items...
        for(int i=0; i<nums.length-2; i++) {
            int lc = i+1;
            int rc = nums.length-1;
            //handling the duplicates..
            if(i>0 && nums[i] == nums[i-1]) continue; //since it is already handlered in the earlier loop!!
            while(lc<rc) {
                int isum = nums[lc] + nums[rc];
                int target = nums[i] + isum;
                if(target == 0) {
                   result.add(Arrays.asList(nums[i],nums[lc], nums[rc]));
                   while(lc<rc && nums[lc] == nums[lc+1]) lc++; //inner duplicate check to avoid adding dup-values
                   while(lc<rc && nums[rc] == nums[rc-1]) rc--; //inner duplicate check to avoid adding dup-values
                   lc++;
                   rc--;
                } else if(target>0) { 
                    rc--;
                } else {
                    lc++;
                }
            }
        }
        return result;    
    }
}
