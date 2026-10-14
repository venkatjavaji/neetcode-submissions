class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>>  result = new ArrayList<>();
            backtrack(nums,target,0,result, new ArrayList<>());
            return result;
        
    }

    void backtrack(int[] nums, int remaining, int counter, List<List<Integer>> result, List<Integer> temp) {

        if(remaining == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=counter;i<nums.length;i++) {
            if(nums[i]>remaining) break;
            temp.add(nums[i]);
            //pass i in the recursive instead of counter...
            backtrack(nums,remaining-nums[i], i, result, temp);
            temp.remove(temp.size()-1);
        }
    }
}
