class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfsum2(result, new ArrayList<>(), candidates,target, 0);
        return result;
    }

    public void dfsum2(List<List<Integer>> result, List<Integer> temp, int[] nums, int remaining, int counter) {

        if(remaining == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=counter; i < nums.length; i++) {
            if(nums[i] > remaining) break; 
            if(i> counter && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            dfsum2(result,temp, nums, remaining - nums[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}
