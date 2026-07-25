class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfsum(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    public void dfsum(List<List<Integer>> result, List<Integer> temp, int[] nums,
        int remaining, int counter) {

            if(remaining == 0) {
                result.add(new ArrayList<>(temp));
                return;
            }
            for(int i = counter; i<nums.length; i++) {
                if(nums[i]>remaining) break; //if the current element in given array reaches ramaining
                temp.add(nums[i]);
                dfsum(result, temp, nums, remaining-nums[i], i); //sending the same i, to consider the current element indefinately...
                temp.remove(temp.size()-1);
            }
    }
}
