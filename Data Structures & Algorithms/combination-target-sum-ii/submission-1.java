class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0, result, new ArrayList<>());
        return result;
        
    }

    void backtrack(int[] nums, int rem, int counter, List<List<Integer>> result, List<Integer> temp) {

        if(rem == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=counter;i<nums.length;i++) {
            if(nums[i]>rem) break;
            if(i>counter && nums[i] == nums[i-1])continue;
            temp.add(nums[i]);
            backtrack(nums,rem-nums[i], i+1, result, temp);
            temp.remove(temp.size()-1);
        }

    }
}
